package com.shigu.main4.item.newservice.impl;

import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.item.newservice.NewShowForCdnService;
import com.shigu.main4.item.services.ShowForCdnServiceImpl;
import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("newShowForCdnService")
public class NewShowForCdnServiceImpl extends ShowForCdnServiceImpl implements NewShowForCdnService {
    @Override
    public NewCdnItem selItemById(Long id) {
        return (NewCdnItem) super.selItemById(id);
    }

    @Override
    public NewCdnItem selItemById(Long id, String webSite) {
        return (NewCdnItem) super.selItemById(id,webSite);
    }

    @Override
    public List<SingleSkuVO> selSingleSkus(Long id) {
        List<SingleSkuVO> pull = SpringBeanFactory.getBean(ItemSkuModel.class, id).pull();
        return pull==null?new ArrayList<>():pull;
    }

    @Override
    public NewCdnItem selItemInstockById(Long id) {
        return (NewCdnItem) super.selItemInstockById(id);
    }

    @Override
    public NewCdnItem selItemInstockById(Long id, String webSite) {
        return (NewCdnItem) super.selItemInstockById(id,webSite);
    }

    @Override
    public Integer updateSkuPriceStock(List<SingleSkuVO> skus,String webSite) {
        return super.updateSkuPriceStock(skus,webSite);
    }
}
