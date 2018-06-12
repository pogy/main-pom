package com.shigu.sn.api.service;

import com.openJar.beans.SnTokenInfo;
import com.shigu.exception.AppNotBuyException;
import org.springframework.stereotype.Service;

@Service
public class SnAuthService {

    public SnTokenInfo getSnTokenInfo(String code) throws AppNotBuyException{

        return new SnTokenInfo();
    }
}
