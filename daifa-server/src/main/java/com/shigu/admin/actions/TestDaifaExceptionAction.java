package com.shigu.admin.actions;

import com.shigu.config.DaifaSessionConfig;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @类编号
 * @类名称：TestDaifaExceptionAction
 * @文件路径：com.shigu.admin.actions.TestDaifaExceptionAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/1 17:50
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
public class TestDaifaExceptionAction {

    @RequestMapping("admin/testDaifaException")
    public String testDaifaException( Model model){

        Session session = SecurityUtils.getSubject().getSession();
        String auth = (String) session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);

        model.addAttribute("userName", auth);
        return "admin/testDaifaException";
    }

    @RequestMapping("admin/testException")
    @ResponseBody
    public JSONObject testException(String level) throws DaifaException {
        JSONObject obj = JsonResponseUtil.success ();


        switch (level) {
            case "debug": {
                obj.put ("msg", "debug");
                throw new DaifaException ("此条码对应的商品全部暂未拿到货DEBUG", DaifaException.DEBUG);

            }
            case "warn": {
                obj.put ("msg", "warn");
                throw new DaifaException ("此条码对应的商品全部暂未拿到货WARN", DaifaException.WARN);

            }
            case "info": {
                obj.put ("msg", "info");
                throw new DaifaException ("此条码对应的商品全部暂未拿到货INFO", DaifaException.INFO);

            }
            case "error": {
                obj.put ("msg", "error");
                throw new DaifaException ("此条码对应的商品全部暂未拿到货ERROR", DaifaException.ERROR);

            }
            case "fatal": {
                obj.put ("msg", "fatal");
                throw new DaifaException ("此条码对应的商品全部暂未拿到货FATAL", DaifaException.FATAL);

            }
            case "default": {
                obj.put ("msg", "default");
                throw new DaifaException ("此条码对应的商品全部暂未拿到货default");

            }
            default: {
                obj.put ("msg", "orther");


            }

            return obj;
        }
    }
}
