package com.shigu.main4.item.vo;

import java.io.Serializable;

/**
 * Created by wxc on 2017/4/6.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class AggsCount implements Serializable {

    private long value;
    private long count;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
