package com.shigu.productAi.configs;

import org.springframework.beans.factory.annotation.Value;
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
public class ProductAiConfig {
    @Value("${ai_access_key_id}")
    public String accessKeyId;
    @Value("${ai_secret_key}")
    public String secretKey;
    @Value("${ai_image_set_id}")
    public String imageSetId;
    @Value("${ai_clothes_search_id}")
    public String clothesSearchId;
    @Value("${ai_version}")
    public String version;


}
