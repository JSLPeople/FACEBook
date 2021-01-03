package com.jsu.utils;

import com.jsu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {

    /**
     * 把Map中的值注入到对应的JavaBean属性中
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean){

        try {
            System.out.println("注入之前："+ bean);
            /**
             * 把所有请求参数都注入到user中
             */
            BeanUtils.populate(bean,value);
            System.out.println("注入之后："+ bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化成int类型
     * @param strInt
     * @param defultValue
     * @return
     */
    public static  int parseInt(String strInt,int defultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defultValue;
    }
}
