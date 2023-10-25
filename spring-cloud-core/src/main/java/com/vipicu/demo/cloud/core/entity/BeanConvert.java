package com.vipicu.demo.cloud.core.entity;


/**

 * ----------------------------------------
 * 基础实体转换
 *
 * @author oohmygosh
 * @since 2021-10-28
 */
public interface BeanConvert {

    /**
     * 获取自动转换后的JavaBean对象
     *
     * @param clazz 转换对象类
     * @param <T>   转换对象
     * @return T 待转换对象
     */
    default <T> T convert(Class<T> clazz) {
        return null;
    }
}
