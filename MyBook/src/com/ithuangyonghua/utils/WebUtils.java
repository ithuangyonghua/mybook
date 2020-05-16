package com.ithuangyonghua.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(T bean,Map value){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        if(strInt==""||strInt==null){
            return defaultValue;
        }
        try{
            return Integer.valueOf(strInt);
        }catch(Exception e){
            e.printStackTrace();
        }
        return defaultValue;
    }
}
