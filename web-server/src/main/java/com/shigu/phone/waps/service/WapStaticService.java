package com.shigu.phone.waps.service;

import com.openJar.beans.app.AppCatGroup;
import com.openJar.beans.app.AppSearchNav;
import com.openJar.beans.app.AppSite;
import com.openJar.exceptions.OpenException;
import com.shigu.phone.baseservices.BaseStaticService;
import com.shigu.phone.basevo.CatVO;
import com.shigu.phone.waps.vo.ParentCatVO;
import com.shigu.phone.waps.vo.SubCatVO;
import com.shigu.search.vo.CateNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WapStaticService {

    @Autowired
    private BaseStaticService baseStaticService;

    /**
     * 查询站点
     * @return
     */
    public  List<AppSite> selWebSites(){
        return baseStaticService.selWebSites();
    }

    public List<AppCatGroup>  selCat(String webSite, Integer type){
        return baseStaticService.selCat(webSite,type);
    }

    public List<AppSearchNav> searchNav(Integer type, Long sid, String webSite){
        return baseStaticService.searchNav(type,sid,webSite);
    }


    public List<ParentCatVO> queryParentCatList(String webSite) throws OpenException {
        List<CateNav> list = baseStaticService.queryParentCatList(webSite);
        if (list == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("未查询到数据");
            throw openException;
        }
        List<ParentCatVO> parentCatVOS = new ArrayList<>();
        list.stream().filter(item-> item != null).forEach(item->{
            ParentCatVO parentCatVO = new ParentCatVO();
            parentCatVO.setPid(item.getId());
            parentCatVO.setName(item.getText());
            parentCatVOS.add(parentCatVO);
        });

        return parentCatVOS;
    }

    public List<SubCatVO> querySubCatList(String webSite, Integer pId) throws OpenException {
        List<CateNav> list = baseStaticService.querySubCatList(webSite,pId);
        if (list == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("未查询到数据");
            throw openException;
        }
        List<SubCatVO> subCatVOS = new ArrayList<>();
        list.stream().filter(item-> item != null).forEach(item->{
            SubCatVO subCatVO = new SubCatVO();
            subCatVO.setCid(item.getId());
            subCatVO.setName(item.getText());
            subCatVOS.add(subCatVO);
        });

        return subCatVOS;
    }
}
