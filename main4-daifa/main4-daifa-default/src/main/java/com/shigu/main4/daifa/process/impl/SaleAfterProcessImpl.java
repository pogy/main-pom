package com.shigu.main4.daifa.process.impl;

import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.SaleAfterProcess;

public class SaleAfterProcessImpl implements SaleAfterProcess {
    @Override
    public void newSaleAfter(SaleAfterBO bo) throws DaifaException {

    }

    @Override
    public String afterApplyDeal(SaleAfterBO bo) throws DaifaException {
        return null;
    }

    @Override
    public String storeRefundDeal(StoreRefundDealBO bo) throws DaifaException {
        return null;
    }

    @Override
    public String saleAfterExpress(SaleAfterExpressBO bo) throws DaifaException {
        return null;
    }

    @Override
    public String saleAfterRemark(SaleAfterBO bo) throws DaifaException {
        return null;
    }

    @Override
    public String refundFailInStock(InStockBO bo) throws DaifaException {
        return null;
    }

    @Override
    public String moneyConsultRefuse(MoneyConsultBO bo) throws DaifaException {
        return null;
    }

    @Override
    public String moneyConsult(MoneyConsultBO bo) throws DaifaException {
        return null;
    }
}
