package com.shigu.main4.item.newservice.impl;

import com.shigu.main4.item.newservice.NewShowForCdnService;
import com.shigu.main4.item.services.ShowForCdnServiceImpl;
import com.shigu.main4.item.vo.news.NewCdnItem;
import org.springframework.stereotype.Service;

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
    public NewCdnItem selItemInstockById(Long id) {
        return (NewCdnItem) super.selItemInstockById(id);
    }

    @Override
    public NewCdnItem selItemInstockById(Long id, String webSite) {
        return (NewCdnItem) super.selItemInstockById(id,webSite);
    }
}
