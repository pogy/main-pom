package com.shigu.main4.monitor.test;

import com.opentae.data.mall.interfaces.ShiguShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

/**
 * Created by zhaohongbo on 17/5/17.
 */
@Service
@Scope("prototype")
public class OodTestImpl implements OodTest{
    @Transient
    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Override
    public void test() {
        System.out.println(shiguShopMapper);
    }
}
