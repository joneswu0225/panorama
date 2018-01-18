package com.jones.panorama.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiong.wu on 2016/9/5.
 */
public class FreemarkerUtil {
    private static Logger logger = Logger.getLogger(FreemarkerUtil.class);
    public static Configuration cfg;
    private static Map<String,Object> initMap = new HashMap<>();

    public FreemarkerUtil() throws IOException {
        init();
    }

    /**
     * 初始化方法 初始化Configuration
     * @param
     * @exception
     */
    private static void init() throws IOException {
        cfg = new Configuration();
        cfg.setNumberFormat("#.##");
        cfg.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        cfg.setDateFormat("yyyy-MM-dd");
        cfg.setTimeFormat("HH:mm:ss");
//        TemplateLoader template = new ClassTemplateLoader(FreemarkerUtil.class, "/templates/");
//        cfg.setTemplateLoader(template);
        cfg.setDefaultEncoding("UTF-8");
    }

    /**
     * 实例化 Configuration对象
     * @param
     * @exception
     * @return 无返Configuration 的一个实例化对象
     */
    private static Configuration getConfiguration() throws IOException {
        if (cfg == null)
            init();
        return (cfg);
    }

    /**
     * 通过模板生成页面
     * @param map 模板中需要的数据
     * @param templatePath 模板路径
     * @exception
     * @return 返回生成的页面中的字符串
     */

    public static String process(Map<String, Object> map, String templatePath) throws Exception {
        return process("UTF-8", map, templatePath);
    }

    /**
     * 通过模板生成页面
     * @param map 模板中需要的数据
     * @param templatePath 模板路径
     * @exception
     * @return 返回生成的页面中的字符串
     */
    public static String process(String encoding, Map<String, Object> map, String templatePath){
        map.putAll(initMap);
        String result = null;
        try {
            Configuration conf = getConfiguration(); //通过FreeMarker的Configuration对象可以读取ftl文件
            Template temp = temp = conf.getTemplate(templatePath, encoding); //在模板文件目录中相对应的flt文件
            StringWriter sw = new StringWriter();
            temp.process(map, sw);
            result = sw.toString();
            sw.flush();
            sw.close();
        } catch (Exception e) {
            logger.error("根据freemarker模板 " + templatePath + " 生成html失败", e);
        }
        return result;
    }

    public static void process(Map<String, Object> map, String templatePath, String savePath)
            throws Exception {
        map.putAll(initMap);
        Configuration conf = getConfiguration();
        Template template = conf.getTemplate(templatePath);
        File file = new File(savePath);
        file.getParentFile().mkdirs();
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                file), "UTF-8");
        try {
            template.process(map, osw);
            osw.flush();
            osw.close();
        } catch (Exception e) {
            logger.error("模版数据生成错误", e);
        }
    }
}
