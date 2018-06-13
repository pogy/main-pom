package com.openJar.requests.imgs;

import com.openJar.requests.interfaces.SelJdUidsByFuzzyJdLoginNameRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.openJar.responses.interfaces.SelJdUidsByFuzzyJdLoginNameResponse;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import org.junit.Test;

/**
 * Created By admin on 2017/12/24/17:41
 */
public class JdUpImgRequestTest {

    @Test
    public void JdUpImgRequestTest(){

        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        JdUpImgRequest request = new JdUpImgRequest();
        JdUpImgResponse response = client.execute(request);
        System.out.println(response.getDesc());
    }

    @Test
    public void selJdUidsByFuzzyJdLoginNameTest(){

        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        SelJdUidsByFuzzyJdLoginNameRequest request = new SelJdUidsByFuzzyJdLoginNameRequest();
        request.setJdUserNick("jd");
        SelJdUidsByFuzzyJdLoginNameResponse response = client.execute(request);
        System.out.println(response.getJdUids());
    }
}
