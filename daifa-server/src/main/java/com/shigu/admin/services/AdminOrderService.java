package com.shigu.admin.services;

import com.createExcel.exceptions.IndexRepetitionException;
import com.createExcel.utils.CreateExcel;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.shigu.admin.vo.PrintExcelVO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class AdminOrderService {
    private DaifaMultipleMapper daifaMultipleMapper;
    @Autowired
    public void setDaifaMultipleMapper(DaifaMultipleMapper daifaMultipleMapper) {
        this.daifaMultipleMapper = daifaMultipleMapper;
    }


    public void pushExcel(HttpServletResponse response,String nick) throws IOException {
        OutputStream out = response.getOutputStream();
        //报头用于提供一个推荐的文件名，并强制浏览器显示保存对话框
        //attachment表示以附件方式下载。如果要在页面中打开，则改为 inline
        response.setHeader("Content-Disposition", "attachment; filename=PrintExcel1.xls");

        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
        daifaTradeExample.createCriteria().andBuyerNickEqualTo(nick).andSendStatusEqualTo(1);
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andRefundStatusEqualTo(0).andTakeGoodsStatusNotEqualTo(1);

        MultipleExample example= MultipleExampleBuilder.from(daifaTradeExample)
                .join(daifaOrderExample)
                .on(daifaTradeExample.createCriteria().equalTo(DaifaTradeExample.dfTradeId,DaifaOrderExample.dfTradeId))
                .build();
        List<PrintExcelVO> list=daifaMultipleMapper.selectFieldsByMultipleExample(example, PrintExcelVO.class);

        CreateExcel createExcel=new CreateExcel();
        Workbook workbook= null;
        try {
            workbook = createExcel.createWorkbook(list);
        } catch (IndexRepetitionException e) {
            e.printStackTrace();
        }
        workbook.write(out);
        out.flush();
        out.close();
    }


}
