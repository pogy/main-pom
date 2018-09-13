package com.shigu.main4.pay.responses;

import com.shigu.main4.pay.vos.XzbUserPayTradeRecordVO;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：XzbUserPayTradeRecordResponse
 * 类路径： com.shigu.main4.pay.responses.XzbUserPayTradeRecordResponse
 * 创建者： whx
 * 创建时间： 8/7/18 4:43 PM
 * 项目： main-pom
 * 描述：用户支付账单查询
 */
public class XzbUserPayTradeRecordResponse extends XzbResponse implements Serializable {
    private List<XzbUserPayTradeRecordVO> tradeLog;

    private Integer totalPages;

    private Integer currentPage;

    public List<XzbUserPayTradeRecordVO> getTradeLog() {
        return tradeLog;
    }

    public void setTradeLog(List<XzbUserPayTradeRecordVO> tradeLog) {
        this.tradeLog = tradeLog;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
