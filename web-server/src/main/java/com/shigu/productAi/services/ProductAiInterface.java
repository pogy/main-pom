package com.shigu.productAi.services;

import com.shigu.productAi.beans.*;

import java.util.List;

/**
 * Created by pc on 2017-07-12.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */

public interface ProductAiInterface {

    ProductAiVo addAi(ProductAiAddBo bo);
    List<AiImageInfo> search(ProductAiSearchBo bo);
    ProductAiVo delete(ProductAiDelBo bo);



}
