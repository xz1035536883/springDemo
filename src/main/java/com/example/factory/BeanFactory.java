package com.example.factory;

import com.example.service.IAccountService;

import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author ryan.xu
 * @since 2020/3/29
 */
public class BeanFactory {
    private static Properties props;

    private static Map<String,Object> beans;

    static {

        try {
            props = new Properties();
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(inputStream);
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properites失败");
        }
    }

    /**
     * 根据Bean名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBeans(String beanName){
        return beans.get(beanName);
    }

//    public static Object getBeans(String beanName){
//        Object obj = null;
//        String beanPath = props.getProperty(beanName);
//        try {
//            obj = Class.forName(beanPath).newInstance();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return obj;
//    }

}
