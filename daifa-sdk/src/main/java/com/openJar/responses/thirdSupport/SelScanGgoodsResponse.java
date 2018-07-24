package com.openJar.responses.thirdSupport;

import com.openJar.beans.WorkUserGgoodsTasksScan;
import com.openJar.responses.Response;

import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.openJar.responses.thirdSupport
 * @ClassName: SelScanGgoodsResponse
 * @Author: sy
 * @CreateDate: 2018/7/19 0019 16:35
 */
public class SelScanGgoodsResponse extends Response {

    List<WorkUserGgoodsTasksScan> scanDate;

    public List<WorkUserGgoodsTasksScan> getScanDate() {
        return scanDate;
    }

    public void setScanDate(List<WorkUserGgoodsTasksScan> scanDate) {
        this.scanDate = scanDate;
    }
}
