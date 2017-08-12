package com.shigu.main4.item.services;

/**
 * Created by zhaohongbo on 17/7/31.
 */
public interface ItemPicRelationService {
    /**
     * 移除包关联
     * @param fileId
     * @param goodsId
     * @return
     */
    boolean removeFileRelation(String fileId, Long goodsId);

    /**
     * 移除包关联,按path与type
     * @param path
     * @param type
     * @return
     */
    boolean removeFileRelation(String path,String type);



    /**
     * 添加包关联
     * @param goodsId
     * @param fileId
     */
    void addFileRelation(Long goodsId,String fileId);

    /**
     * 改变包关联
     * @param from
     * @param to
     * @return
     */
    int updateFileRelation(String from,String to);

    /**
     * 改变文件目录时
     * @param from
     * @param to
     * @return
     */
    int updateFileRelationByDir(String from,String to);
}
