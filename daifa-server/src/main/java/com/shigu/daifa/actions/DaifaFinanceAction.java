package com.shigu.daifa.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DaifaFinanceAction {

    @RequestMapping("daifa/financialStatistic")
    public String financialStatistic(){
        return  null;
    }
}
