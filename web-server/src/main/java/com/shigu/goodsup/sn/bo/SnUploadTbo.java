package com.shigu.goodsup.sn.bo;

import com.shigu.goodsup.jd.bo.JdUploadPropImgBO;
import com.shigu.goodsup.jd.bo.JdUploadPropInputBO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SnUploadTbo extends SnUploadBo{
    private List<String> picUrls;
    private List<JdUploadPropImgBO> propImg;
    private List<SnUploadSkuBo> skus;
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


    public String selSkuSale(){
        StringBuilder sku= new StringBuilder();
        for(SnUploadSkuBo s:skus){
            for(SnUploadSkuBo ss:s.getSizes()){
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
        for(SnUploadSkuBo s:skus){
            for(SnUploadSkuBo ss:s.getSizes()){
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


    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public List<JdUploadPropImgBO> getPropImg() {
        return propImg;
    }

    public void setPropImg(List<JdUploadPropImgBO> propImg) {
        this.propImg = propImg;
    }

    public List<SnUploadSkuBo> getSkus() {
        return skus;
    }

    public void setSkus(List<SnUploadSkuBo> skus) {
        this.skus = skus;
    }

    public List<JdUploadPropInputBO> getInputs() {
        return inputs;
    }

    public void setInputs(List<JdUploadPropInputBO> inputs) {
        this.inputs = inputs;
    }

    public List<JdUploadPropInputBO> getProps() {
        return props;
    }

    public void setProps(List<JdUploadPropInputBO> props) {
        this.props = props;
    }

    public List<Long> getSellerCids() {
        return sellerCids;
    }

    public void setSellerCids(List<Long> sellerCids) {
        this.sellerCids = sellerCids;
    }
}
