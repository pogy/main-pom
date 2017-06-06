package com.shigu.main4.test.active;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Created by sean on 2016-07-30-0030.
 */
@Component
public class TemplateUtil {
    private Configuration configuration = null;

    public TemplateUtil() {
        configuration = new Configuration(Configuration.VERSION_2_3_22);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        configuration.setClassForTemplateLoading(this.getClass(), "/template/");
        configuration.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        configuration.setNumberFormat("0.#########");
    }

    public <T> void write(String templateName, Map<String, T> dataMap, Writer out) throws IOException, TemplateException {
        configuration.getTemplate(templateName).process(dataMap, out);
    }
}
