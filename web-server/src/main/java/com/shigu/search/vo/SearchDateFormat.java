package com.shigu.search.vo;

import java.util.Calendar;
import java.util.Date;

/**
 * 搜索时间转化
 * Created by zhaohongbo on 17/4/7.
 */
public class SearchDateFormat {

    private Date start;

    private Date end;

    public SearchDateFormat(Integer d) {
        if (d != null) {
            Calendar cal=Calendar.getInstance();
            end=cal.getTime();
            cal.add(Calendar.DAY_OF_YEAR,0-d);
            start=cal.getTime();
        }
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
