package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gtx on 2018/9/3 0003.
 *
 * @author gtx
 * @since
 */
public class KdnPostInfoVO implements Serializable {
    /**
     * State	String	物流状态: 0-无轨迹，1-已揽收，2-在途中 201-到达派件城市，3-签收,4-问题件
     */
    private int state;
    /**
     * 快递公司名
     */
    private String companyName;
    /**
     * LogisticCode	String	快递单号	R
     */
    private String logisticCode;
    /**
     * 订单ID
     */
    private Long oid;

    private List<KdnPostTraceInfoVO> postTraceInfoVOS;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public List<KdnPostTraceInfoVO> getPostTraceInfoVOS() {
        return postTraceInfoVOS;
    }

    public void setPostTraceInfoVOS(List<KdnPostTraceInfoVO> postTraceInfoVOS) {
        this.postTraceInfoVOS = postTraceInfoVOS;
    }

    @Override
    public String toString() {
        return "KdnPostInfoVO{" +
                "state=" + state +
                ", companyName='" + companyName + '\'' +
                ", logisticCode='" + logisticCode + '\'' +
                ", oid=" + oid +
                ", postTraceInfoVOS=" + postTraceInfoVOS +
                '}';
    }
}
