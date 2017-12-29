package com.shigu.goodsup.jd.bo;

import com.shigu.goodsup.jd.vo.PropertyItemVO;
import com.shigu.goodsup.jd.vo.PropertyValueVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JdUploadTmpBO extends JdUploadBO{
    private List<String> picUrls;
    private List<JdUploadPropImgBO> propImg;
    private List<JdUploadSkuBO> skus;
    private List<JdUploadPropInputBO> inputs;
    private List<JdUploadPropInputBO> props;
    private List<Long> sellerCids;
    public void callProp_img(List<String> prop_img) {
        if(prop_img==null){
            this.propImg=new ArrayList<>();
        }else{
            this.propImg=prop_img.stream().map(s -> {
                JdUploadPropImgBO bo=new JdUploadPropImgBO();
                String[] ss=s.split("##");
                bo.setImg(ss[1]);
                String[] sss=ss[0].split("_");
                bo.setPid(new Long(sss[0]));
                bo.setVid(new Long(sss[1]));
                return bo;
            }).collect(Collectors.toList());
        }
    }

    public void callSku_props(List<String> sku_props){
        if(sku_props!=null&&sku_props.size()>0){
            for(String sku:sku_props){
                String[] skus=sku.split(":");
                JdUploadPropInputBO bo=new JdUploadPropInputBO();
                if(skus[1].contains("###")){
                    bo.setValue(skus[1].substring(3));
                }else{
                    bo.setVid(new Long(skus[1]));
                    if(bo.getVid()<0L){
                        continue;
                    }
                }
                bo.setPid(new Long(skus[0]));
                addSkus(bo);
            }
        }
    }
    private void addSkus(JdUploadPropInputBO sku){
        if(this.inputs==null){
            this.inputs=new ArrayList<>();
        }
        if(this.props==null){
            this.props=new ArrayList<>();
        }
        if(sku.getVid()!=null){
            this.props.add(sku);
        }else{
            this.inputs.add(sku);
        }

    }

    public String selSkuProp(){
        StringBuilder sku= new StringBuilder();
        for(JdUploadSkuBO s:skus){
            String str=s.getPid()+":";
            for(JdUploadSkuBO ss:s.getSizes()){
                sku.append(str).append(ss.getVid()).append("|");
            }
        }
        if(sku.length()>0){
            sku = new StringBuilder(sku.substring(0, sku.length() - 1));
            return sku.toString();
        }else{
            return null;
        }
    }
    public String selSkuSale(){
        StringBuilder sku= new StringBuilder();
        for(JdUploadSkuBO s:skus){
            for(JdUploadSkuBO ss:s.getSizes()){
                sku.append(ss.getPrice()).append("|");
            }
        }
        if(sku.length()>0){
            sku = new StringBuilder(sku.substring(0, sku.length() - 1));
            return sku.toString();
        }else{
            return null;
        }
    }
    public String selSkuStock(){
        StringBuilder sku= new StringBuilder();
        for(JdUploadSkuBO s:skus){
            for(JdUploadSkuBO ss:s.getSizes()){
                sku.append(ss.getNum()).append("|");
            }
        }
        if(sku.length()>0){
            sku = new StringBuilder(sku.substring(0, sku.length() - 1));
            return sku.toString();
        }else{
            return null;
        }
    }

    public String selAttrs(){
        StringBuilder pstr= new StringBuilder();
        for(JdUploadPropInputBO p:props){
            pstr.append(p.getPid()).append(":").append(p.getVid()).append("|");
        }
        for(JdUploadSkuBO s:skus){
            pstr.append(s.getPid()).append(":").append(s.getVid()).append("|");
        }
        for(JdUploadSkuBO s:skus.get(0).getSizes()){
            pstr.append(s.getPid()).append(":").append(s.getVid()).append("|");
        }
        if(pstr.length()>0){
            pstr = new StringBuilder(pstr.substring(0, pstr.length() - 1));
            return pstr.toString();
        }else{
            return null;
        }
    }

    public String selAlias(List<PropertyItemVO> sales,PropertyItemVO color){
        StringBuilder str= new StringBuilder();
        for(JdUploadSkuBO s:skus){
            PropertyValueVO v= color.getPropValueByVid(s.getVid());
            if(!v.getOldName().equals(s.getName())){
                str.append(s.getPid()).append(":").append(s.getVid()).append(":").append(s.getName()).append("|");
            }
        }
        for(JdUploadSkuBO s:skus.get(0).getSizes()){
            for(PropertyItemVO p:sales){
                if(Objects.equals(p.getPid(), s.getPid())){
                    PropertyValueVO v= p.getPropValueByVid(s.getVid());
                    if(!v.getOldName().equals(s.getName())){
                        str.append(s.getPid()).append(":").append(s.getVid()).append(":").append(s.getName()).append("|");
                    }
                    break;
                }
            }
        }
        if(str.length()>0){
            str = new StringBuilder(str.substring(0, str.length() - 1));
            return str.toString();
        }else{
            return null;
        }
    }

    public String selOuterId(){
        StringBuilder sku= new StringBuilder();
        for(JdUploadSkuBO s:skus){
            for(JdUploadSkuBO ss:s.getSizes()){
                sku.append(ss.getCode()==null?"":ss.getCode()).append("|");
            }
        }
        if(sku.length()>0){
            sku = new StringBuilder(sku.substring(0, sku.length() - 1));
            return sku.toString();
        }else{
            return null;
        }
    }

    public String selInputPids(){
        StringBuilder sku= new StringBuilder();
        for(JdUploadPropInputBO s:inputs){
            sku.append(s.getPid()).append("|");
        }
        if(sku.length()>0){
            sku = new StringBuilder(sku.substring(0, sku.length() - 1));
            return sku.toString();
        }else{
            return null;
        }
    }
    public String selInputValues(){
        StringBuilder sku= new StringBuilder();
        for(JdUploadPropInputBO s:inputs){
            sku.append(s.getValue()).append("|");
        }
        if(sku.length()>0){
            sku = new StringBuilder(sku.substring(0, sku.length() - 1));
            return sku.toString();
        }else{
            return null;
        }
    }


    /*********************************************get()set()****************************************************/



    public List<String> getPicUrls() {
        return this.picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public List<JdUploadPropImgBO> getPropImg() {
        return this.propImg;
    }

    public void setPropImg(List<JdUploadPropImgBO> propImg) {
        this.propImg = propImg;
    }

    public List<JdUploadSkuBO> getSkus() {
        return this.skus;
    }

    public void setSkus(List<JdUploadSkuBO> skus) {
        this.skus = skus;
    }

    public List<JdUploadPropInputBO> getInputs() {
        return this.inputs;
    }

    public void setInputs(List<JdUploadPropInputBO> inputs) {
        this.inputs = inputs;
    }

    public List<JdUploadPropInputBO> getProps() {
        return this.props;
    }

    public void setProps(List<JdUploadPropInputBO> props) {
        this.props = props;
    }
    public List<Long> getSellerCids() {
        return this.sellerCids;
    }

    public void setSellerCids(List<Long> sellerCids) {
        this.sellerCids = sellerCids;
    }
}
