package com.library.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.Writer;

/**
 * @Author Qinghan Huang
 * @Date 2023/4/21 22:15
 * @Desc For getting Thymeleaf engine
 * @Version 1.0
 */
public class ThymeleafUtil {
    private static final TemplateEngine engine;
    static {
        engine=new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        engine.setTemplateResolver(r);
    }
    public static TemplateEngine getEngine(){
        return engine;
    }
    public  static void process(String template, IContext context, Writer writer){
        engine.process(template, context, writer);
    }

}
