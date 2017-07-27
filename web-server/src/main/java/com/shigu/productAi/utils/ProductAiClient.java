package com.shigu.productAi.utils;

import cn.productai.api.core.DefaultProductAIClient;
import cn.productai.api.core.DefaultProfile;
import cn.productai.api.core.IProfile;
import cn.productai.api.core.IWebClient;
import cn.productai.api.core.enums.LanguageType;
import com.shigu.productAi.configs.ProductAiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pc on 2017-07-12.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Component
public class ProductAiClient {

    private static IWebClient client;
    @Autowired
    ProductAiConfig config;

    public  IWebClient getClient(){
        if(client == null){
            synchronized (this) {
                if(client == null) {
                    IProfile profile = new DefaultProfile();
                    profile.setGlobalLanguage(LanguageType.Chinese);
                    profile.setVersion(config.version);
                    profile.setSecretKey(config.secretKey);
                    profile.setAccessKeyId(config.accessKeyId);
                    client = new DefaultProductAIClient(profile);
                }
            }
        }

        return client;
    }
}
