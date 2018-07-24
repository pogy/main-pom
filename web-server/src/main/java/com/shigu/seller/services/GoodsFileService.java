package com.shigu.seller.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.item.services.ItemPicRelationService;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.ShopLicense;
import com.shigu.seller.bo.BigPicOuterLinkBO;
import com.shigu.seller.vo.DatuVO;
import com.shigu.seller.vo.FileSizeVO;
import com.shigu.seller.vo.GoodsFileSearchVO;
import com.shigu.seller.vo.GoodsFileVO;
import com.shigu.session.main4.ShopSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 商品文件关联类
 * Created by zlm on 2017/7/25.
 */
@Service
public class GoodsFileService extends OssIO {
    @Autowired
    GoodsFileMapper goodsFileMapper;

    @Autowired
    OssIO ossIO;

    @Autowired
    ShopLicenseService shopLicenseService;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    ItemPicRelationService itemPicRelationService;

    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    ShopSizeMapper shopSizeMapper;

    @Autowired
    ShopVideoTimeMapper shopVideoTimeMapper;

    final String ROOT_PATH = "udf/";

    final long DEFAULT_SIZE = 1024*1024;

    @PostConstruct
    private void init() {
        super.setAccessKeyId(ossIO.getAccessKeyId());
        super.setAccessKeySecret(ossIO.getAccessKeySecret());
        super.setEndpoint(ossIO.getEndpoint());
        super.setDomain("http://imgzip.571xz.com/");
        super.setBucketName("imgzip");
    }

    /**
     * web真传认证
     *
     * @param shopId
     * @return
     * @throws UnsupportedEncodingException
     */
    public Map<String, String> createPostSignInfo(Long shopId) throws UnsupportedEncodingException {
        return super.createPostSignInfo(getTempDir(shopId));
    }

    /**
     * 查店铺的容量支持
     * @param shopId
     * @return
     */
    public Long shopDataSize(Long shopId){
        /*ShopLicense license=shopLicenseService.selShopLIcenseByType(shopId, ShopLicenseTypeEnum.SHOPDATA);
        if (license == null) {
            //判断是否电商
            ShiguShopExample example=new ShiguShopExample();
            List<Long> marketIds=new ArrayList<>();
            marketIds.add(1087L);
            marketIds.add(617L);
            marketIds.add(621L);
            example.createCriteria().andShopIdEqualTo(shopId).andMarketIdIn(marketIds);
            int much=shiguShopMapper.countByExample(example)>0?3:1;
            return much*DEFAULT_SIZE;
        }
        return Long.valueOf(license.getContext());*/
        ShopSizeExample shopSizeExample=new ShopSizeExample();
        shopSizeExample.createCriteria().andShopIdEqualTo(shopId);
        List<ShopSize> shopSizes=shopSizeMapper.selectByExample(shopSizeExample);
        if(shopSizes.size()==0){
            return DEFAULT_SIZE;
        }else if(shopSizes.get(0).getPicSize()==null){
            return DEFAULT_SIZE;
        }else {
            return shopSizes.get(0).getPicSize()*1024;
        }
    }

    /**
     * 确认上传文件
     * @param shopId
     */
    public GoodsFileVO uploadFile(Long shopId,String fileId) throws JsonErrException {
        //取新文件大小
        Long newSize=super.getSizeInfo(getTempDir(shopId)+fileId)/1024;
        //取已存总大小
        Long hadSize=super.getSizeInfo(getHomeDir(shopId))/1024;
        //取容量
        Long shopSize=shopDataSize(shopId);
        if(newSize+hadSize>shopSize){//超了
            throw new JsonErrException("容量超出,上传失败");
        }
        //迁移
        super.moveFile(getTempDir(shopId)+fileId, getHomeDir(shopId)+fileId);
        GoodsFileVO fileVO=new GoodsFileVO();
        fileVO.setFileId(fileId);
        fileVO.setFileType("picBkg");
        String tmpId=fileId.toLowerCase();
        if (fileId.endsWith(".zip") || fileId.endsWith(".7z") || fileId.endsWith(".rar") ) {
            fileVO.setFileType("picBkg");
        } else if (tmpId.endsWith(".jpg") || tmpId.endsWith(".jpeg") || tmpId.endsWith(".bmp") ||
                tmpId.endsWith(".png") || tmpId.endsWith(".webp") || tmpId.endsWith(".gif") ||
                tmpId.endsWith(".tiff") || tmpId.endsWith(".tga") || tmpId.endsWith(".ico")) {
            fileVO.setFileType("img");
        } else if(fileId.endsWith("/")) {
            fileVO.setFileType("folder");
        } else {
            fileVO.setFileType("other");
        }
        fileVO.setFileName(fileId);
        fileVO.setFileCreateTime(new Date().getTime());
        BeanMapper.map(sizeparseToShow(newSize.doubleValue()),fileVO);
        return fileVO;
    }
    /**
     * g更加文件路径获取
     */
    public List<ItemShowBlock> selGoodsFileByFile(Long shopId,String fileKey) {
        GoodsFileExample goodsExample=new GoodsFileExample();
        goodsExample.createCriteria().andFileKeyEqualTo(parseMyFilePath(shopId,fileKey));
        List<GoodsFile> goodsFiles = goodsFileMapper.selectByExample(goodsExample);

        List<ItemShowBlock> items = shopForCdnService.searchItemOnsale( BeanMapper.getFieldList(goodsFiles, "id", Long.class), "hz", 1, goodsFiles.size()).getContent();
        return items;
    }

    /**
     * 获取文件列表
     */
    public List<GoodsFileVO> selFilesByFileId(Long shopId , String fileKey) {
        List<GoodsFileVO> files = BeanMapper.mapList(super.getFileList(parseMyFilePath(shopId,fileKey)), GoodsFileVO.class);
        List<GoodsFileVO> newFiles = new ArrayList<GoodsFileVO>();
        List<String> fileKeys=BeanMapper.getFieldList(files,"fileId",String.class);//文件ID
        List<String> hasConnected=new ArrayList<>();
        if(fileKeys.size()>0){
            GoodsFileExample goodsFileExample=new GoodsFileExample();
            goodsFileExample.createCriteria().andFileKeyIn(fileKeys);
            goodsFileExample.setDistinct(true);
            List<GoodsFile> gfiles=goodsFileMapper.selectFieldsByExample(goodsFileExample, FieldUtil.codeFields("file_key"));
            hasConnected=BeanMapper.getFieldList(gfiles,"fileKey",String.class);
        }
        for (GoodsFileVO item : files) {
            fileKeys.add(item.getFileId());
            item.setHasLinkGoods(hasConnected.contains(item.getFileId()));
            item.setFileId(item.getFileId().replace(getHomeDir(shopId),""));
            item.setFileName(item.getFileName().replace(getHomeDir(shopId),""));
            if(item.getFileId().equals("")){
                item.setFileName("/");
            }
            String fileId=item.getFileId();
            if (fileId.contains("/") && fileId.indexOf("/") != fileId.length()-1&&!fileKey.endsWith("/")) {//过滤下层文件的显示
                continue;
            }

            String tmpId=item.getFileId().toLowerCase();
            if (tmpId.endsWith(".zip") || tmpId.endsWith(".7z") || tmpId.endsWith(".rar")) {
                item.setFileType("picBkg");
            } else if (tmpId.endsWith(".jpg") || tmpId.endsWith(".jpeg") || tmpId.endsWith(".bmp") ||
                    tmpId.endsWith(".png") || tmpId.endsWith(".webp") || tmpId.endsWith(".gif") ||
                    tmpId.endsWith(".tiff") || tmpId.endsWith(".tga") || tmpId.endsWith(".ico")) {
                item.setFileType("img");
            } else if (item.getFileId().endsWith("/")) {
                item.setFileType("folder");
            } else {
                item.setFileType("other");
            }
            double fileSize = Double.parseDouble(item.getFileSize());
            BeanMapper.map(sizeparseToShow(fileSize),item);
            newFiles.add(item);
         }
        Collections.sort(newFiles);
         return newFiles;
    }

    /**
     * 文件大小显示转化
     * @param size
     * @return
     */
    public FileSizeVO sizeparseToShow(Double size){
        FileSizeVO sizeVO=new FileSizeVO();
        DecimalFormat df=new DecimalFormat("0.0");
        if (1048576 < size) {
            double mSize = div(size, (double)1048576, 3);
            sizeVO.setFileSize(df.format(mSize));
            sizeVO.setUnit("M");
        } else {
            double kSize = div(size, (double)1024, 3);
            sizeVO.setFileSize(df.format(kSize));
            sizeVO.setUnit("KB");
        }
        return sizeVO;
    }

    public  double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 查询商品为一个文件
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    public ShiguPager<GoodsFileSearchVO> searchGoodsForFile(Long shopId,String webSite,String keyword,Integer pageNo,Integer pageSize){
        ShiguPager<ItemShowBlock> pager=shopForCdnService.searchItemOnsale(keyword,shopId,webSite
                ,"time_down",pageNo,pageSize);
        ShiguPager<GoodsFileSearchVO> vopager=new ShiguPager<>();
        vopager.setTotalPages(pager.getTotalPages());
        vopager.setNumber(pager.getNumber());
        vopager.setTotalCount(pager.getTotalCount());
        List<ItemShowBlock> itemList=pager.getContent();
        List<GoodsFileSearchVO> volist=parseBlockToSearchVO(itemList);
        vopager.setContent(volist);
        List<Long> goodsIds=BeanMapper.getFieldList(volist,"goodsId",Long.class);
        Map<Long,GoodsFileSearchVO> map=BeanMapper.list2Map(volist,"goodsId",Long.class);

        //补充信息
        if(goodsIds.size()>0){
            GoodsFileExample example=new GoodsFileExample();
            example.createCriteria().andGoodsIdIn(goodsIds);
            List<GoodsFile> goodsFiles=goodsFileMapper.selectByExample(example);
            for(GoodsFile gf:goodsFiles){
                GoodsFileSearchVO vo=map.get(gf.getGoodsId());
                if (vo != null) {
                    vo.setHasLinkGoods(true);
                    vo.setLinkFileId(gf.getFileKey().replace(getHomeDir(shopId),""));
                }
            }
        }
        return vopager;
    }

    /**
     * 已关联商品
     * @param fileId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public ShiguPager<GoodsFileSearchVO> fileRelationFile(Long shopId, String fileId, String webSite, Integer pageNo, Integer pageSize){
        GoodsFileExample example=new GoodsFileExample();
        example.createCriteria().andFileKeyEqualTo(getHomeDir(shopId)+fileId);
        example.setStartIndex((pageNo-1)*pageSize);
        example.setEndIndex(pageSize);
        List<GoodsFile> files=goodsFileMapper.selectByConditionList(example);
        ShiguPager<GoodsFileSearchVO> vopager=new ShiguPager<>();
        if(files.size()<pageSize && pageNo==1){
            vopager.setTotalCount(files.size());
        }else{
            vopager.setTotalCount(goodsFileMapper.countByExample(example));
        }
        vopager.setNumber(pageNo);
        List<Long> goodsIds=BeanMapper.getFieldList(files,"goodsId",Long.class);
        if(goodsIds.size()>0){
            ShiguPager<ItemShowBlock> pager = shopForCdnService.searchItemOnsale(goodsIds,webSite,pageNo,pageSize);
            vopager.setContent(parseBlockToSearchVO(pager.getContent()));
        }
        return vopager;
    }

    private List<GoodsFileSearchVO> parseBlockToSearchVO(List<ItemShowBlock> itemList){
        List<GoodsFileSearchVO> volist=new ArrayList<>();
        if (itemList != null) {
            for(ItemShowBlock isb:itemList){
                GoodsFileSearchVO vo=new GoodsFileSearchVO();
                vo.setGoodsId(isb.getItemId());
                vo.setGoodsNo(isb.getGoodsNo());
                vo.setImgSrc(isb.getImgUrl());
                vo.setPrice(isb.getPrice());
                vo.setTitle(isb.getTitle());
                volist.add(vo);
            }
        }
        return volist;
    }

    /**
     * 是否有大图
     * @param goodsId
     * @return
     */
    public boolean hasDatu(Long goodsId){
        if (goodsId == null) {
            return false;
        }
        GoodsFileExample example=new GoodsFileExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId);
        return goodsFileMapper.countByExample(example)>0;
    }

    /**
     * 得到链接
     * @param goodsId
     * @return
     */
    public DatuVO datuUrl(Long goodsId) {
        GoodsFileExample example = new GoodsFileExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId);
        List<GoodsFile> files = goodsFileMapper.selectByExample(example);
        if (files.size() > 0) {
            GoodsFile goodsFile=files.get(0);
            DatuVO vo=new DatuVO();
            vo.setUrl(goodsFile.getType()==1?super.getDomain() + files.get(0).getFileKey():files.get(0).getFileKey());
            vo.setPwd(goodsFile.getPasswd());
            return vo;
        } else {
            return null;
        }
    }
    /**
     * 增加关联关系
     * @param fileKey
     * @param goodsIds
     * @return
     */
    public void saveGoodsFile(String fileKey,Long shopId, String goodsIds,String webSite) throws JsonErrException {
        String[] ids=goodsIds.split(",");
        List<Long> longIds=new ArrayList<>();
        for(String i:ids){
            longIds.add(Long.valueOf(i));
        }
        //验证商品是自家店的
        if(longIds.size()>0&&!isMyGoods(longIds,shopId,webSite)){
            throw new JsonErrException("商品ID非法");
        }
        for(Long id:longIds){
            try {
                itemPicRelationService.addFileRelation(id,getHomeDir(shopId)+fileKey);
            } catch (Exception e) {
            }
        }
    }

    /**
     * 取消关联关系
     * @param goodsId
     * @return
     */
    public int delGoodsfile(Long goodsId,Long shopId,String fileId,String webSite) throws JsonErrException {
        //验证商品是自家店的
        if(!isMyGoods(goodsId,shopId,webSite)){
            throw new JsonErrException("商品ID非法");
        }
        GoodsFileExample example=new GoodsFileExample();
        example.createCriteria().andFileKeyEqualTo(getHomeDir(shopId)+fileId).andGoodsIdEqualTo(goodsId);
        return itemPicRelationService.removeFileRelation(getHomeDir(shopId)+fileId,goodsId)?1:0;
    }

    /**
     * 修改商品统计中的数量
     * @param goodsId
     * @param hadBigzip
     */
    private void updateGoodsCountForSearch(Long goodsId,String webSite,Boolean hadBigzip){
        itemPicRelationService.updateBigPicWeight(hadBigzip,goodsId,webSite);
    }

    /**
     * 验证商品是自家的
     * @param goodsIds
     * @param shopId
     * @param webSite
     * @return
     */
    private boolean isMyGoods(List<Long> goodsIds,Long shopId,String webSite){
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.createCriteria().andStoreIdEqualTo(shopId).andGoodsIdIn(goodsIds);
        example.setWebSite(webSite);
        return shiguGoodsTinyMapper.countByExample(example)==goodsIds.size();
    }
    /**
     * 验证商品是自家的
     * @param goodsId
     * @param shopId
     * @param webSite
     * @return
     */
    private boolean isMyGoods(Long goodsId,Long shopId,String webSite){
        ShiguGoodsTiny tiny=new ShiguGoodsTiny();
        tiny.setWebSite(webSite);
        tiny.setGoodsId(goodsId);
        tiny=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny,FieldUtil.codeFields("goods_id,store_id"));
        if (tiny == null||!shopId.equals(tiny.getStoreId())) {
            return false;
        }
        return true;
    }

    /**
     * 删除文件
     * @param fileKey
     *  @param fileType
     * @return
     */
    public boolean deleteFile(Long shopId,String fileKey, String fileType) {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            fileKey = fileKey +"/";
        }
        String path=getHomeDir(shopId)+fileKey;
        itemPicRelationService.removeFileRelation(path,fileType);
        return super.deleteFile(path);
    }

    /**
     * 重命名文件
     * @param fileKey
     * @param fileType
     * @param newName
     * @return
     */
    public boolean  rename(Long shopId,String fileKey, String fileType, String newName) throws JsonErrException {
        if (!fileKey.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            fileKey = fileKey +"/";
        }
        if (!newName.endsWith("/") && fileType.equalsIgnoreCase("folder") ) {
            newName = newName +"/";
        }
        String newFileKey = newName;
        if(fileKey.contains("/") && !fileType.equalsIgnoreCase("folder")) {
            newFileKey = fileKey.substring(0, fileKey.indexOf("/"))+"/"+ newName;
        }
        if(super.fileExist(getHomeDir(shopId)+newFileKey)){
            throw new JsonErrException("存在同名文件");
        }
        boolean result=super.renameFile(getHomeDir(shopId)+fileKey, getHomeDir(shopId)+newFileKey);
        if(result){
            //修改表
            //如果文件夹
            if (fileType.equalsIgnoreCase("folder") ) {//如果是文件夹
                itemPicRelationService.updateFileRelationByDir(getHomeDir(shopId)+fileKey,getHomeDir(shopId)+newFileKey);
            }else{
                itemPicRelationService.updateFileRelation(getHomeDir(shopId)+fileKey,getHomeDir(shopId)+newFileKey);
                ShopVideoTimeExample shopVideoTimeExample=new ShopVideoTimeExample();
                shopVideoTimeExample.createCriteria().andShopIdEqualTo(shopId).andVideoEqualTo(fileKey);
                List<ShopVideoTime> shopVideoTimes= shopVideoTimeMapper.selectByExample(shopVideoTimeExample);
                if(shopVideoTimes.size()!=0){
                    ShopVideoTime shopVideoTime=new ShopVideoTime();
                    shopVideoTime.setId(shopVideoTimes.get(0).getId());
                    shopVideoTime.setVideo(newFileKey);
                    shopVideoTimeMapper.update(shopVideoTime);
                }
            }
        }
        return result;
    }

    /**
     * 移动文件
     * @param fileId
     * @param targetFlordId
     * @return
     */
    public boolean moveFile(Long shopId,String fileId,  String targetFlordId) throws JsonErrException {
        String targetFileId;
        if(targetFlordId.equals("")&&fileId.contains("/")){//移到根目录
            targetFileId=fileId.substring(fileId.indexOf("/")+1, fileId.length());
        }else{
            targetFileId=targetFlordId+fileId;
        }
        if(fileId.equals(targetFileId)){
            return false;
        }
        if(super.fileExist(getHomeDir(shopId)+targetFileId)){
            throw new JsonErrException("目标文件夹下已经存在同名文件");
        }
        boolean result=super.moveFile(getHomeDir(shopId)+fileId, getHomeDir(shopId)+targetFileId);
        if(result){
            //修改表
            itemPicRelationService.updateFileRelation(getHomeDir(shopId)+fileId,getHomeDir(shopId)+targetFileId);
        }
        return result;
    }

    /**
     * 更新外链
     *
     * @param bo
     * @throws JsonErrException
     */
    public void saveOrUpdateOuterLink(BigPicOuterLinkBO bo, ShopSession shop) throws JsonErrException {
        if (bo == null || bo.getGoodsId() == null || bo.getLink() == null) {
            throw new JsonErrException("无法关联商品到链接");
        }
        if (bo.getIsChecked() == null || !bo.getIsChecked()) {
            saveOrUpdateOuterLinkSingle(bo,shop.getWebSite(), bo.getGoodsId());
        } else {
            ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
            shiguGoodsTiny.setWebSite(shop.getWebSite());
            shiguGoodsTiny.setGoodsId(bo.getGoodsId());
            shiguGoodsTiny.setStoreId(shop.getShopId());
            ShiguGoodsTiny shiguGoodsTiny1 = shiguGoodsTinyMapper.selectOne(shiguGoodsTiny);
            if (shiguGoodsTiny1 != null && StringUtils.isNotEmpty(shiguGoodsTiny1.getGoodsNo())) {
                shiguGoodsTiny.setGoodsNo(shiguGoodsTiny1.getGoodsNo());
                shiguGoodsTiny.setGoodsId(null);
            }
            List<ShiguGoodsTiny> select = shiguGoodsTinyMapper.select(shiguGoodsTiny);
            if (select.size() > 0) {
                for (Long aLong : select.stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList())) {
                    saveOrUpdateOuterLinkSingle(bo,shop.getWebSite(), aLong);
                }
            }
        }

    }

    private void saveOrUpdateOuterLinkSingle(BigPicOuterLinkBO bo,String webSite, Long goodsId) {
       itemPicRelationService.updateFileOuter(goodsId,webSite,bo.getPsw(),bo.getLink(),2);
    }


    /**
     * 移动文件
     * @param dir
     * @return
     */
    public String createDir(Long shopId, String dir) throws JsonErrException {
        if(super.fileExist(getHomeDir(shopId)+dir+"/")){
            throw new JsonErrException("文件夹已经存在");
        }
        String fildPath=super.createDir(getHomeDir(shopId), dir);
        return fildPath.replace(getHomeDir(shopId),"");
    }

    public double getSizeInfo(Long shopId) {
        return div((double)super.getSizeInfo(getHomeDir(shopId)), (double)1024*1024, 3);
    }

    public boolean fileExist(String filePath) {
        return super.fileExist(filePath);
    }

    public String zipUrl(Long shopId,String key){
        return super.getDomain()+getHomeDir(shopId)+key;
    }

    /**
     * 检测文件路径合法性
     * @param fileId
     * @return
     */
    public boolean checkFileId(String fileId) {
        if (StringUtils.isEmpty(fileId)) {
            return true;
        }
        if (fileId.contains("/") && fileId.indexOf("/") != fileId.lastIndexOf("/")) {
            return false;
        }

        for (int i=0; i < sCharCount; i++) {
            if (fileId.contains(sChar[i])) {
                return false;
            }
        }

        return true;
    }

    public List<GoodsFile> selGoodsFileInfo(List<Long> goodsIds) {
        GoodsFileExample example = new GoodsFileExample();
        if (goodsIds == null||goodsIds.size()==0) {
            return new ArrayList<>();
        }
        example.createCriteria().andGoodsIdIn(goodsIds);
        return goodsFileMapper.selectByExample(example);
    }

    private static String sChar[] = {"<", ">", "&", "$", "\t", "\n", "\r", "../"};
    private static int sCharCount = sChar.length;




    /**
     * 拿用户根目录
     * @param shopId
     * @return
     */
    private String getHomeDir(Long shopId) {
        return  ROOT_PATH + shopId + "/zip/";
    }

    /**
     * 转换用户目录到绝对路径
     * @param shopId
     * @param fileId
     * @return
     */
    private String parseMyFilePath(Long shopId,String fileId){
        return getHomeDir(shopId)+(fileId==null?"":fileId);
    }

    /**
     * 得到用户临时目录
     * @param shopId
     * @return
     */
    private String getTempDir(Long shopId) {
        return ROOT_PATH + shopId + "/temp/";
    }

}
