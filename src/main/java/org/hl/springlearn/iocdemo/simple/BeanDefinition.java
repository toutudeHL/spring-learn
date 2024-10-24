package org.hl.springlearn.iocdemo.simple;

import lombok.Data;

/**
 * Bean定义
 * 在spring中，这个定义包含了Bean的元数据信息，如Bean的名称、类型、作用域、初始化方法、销毁方法等。
 *
 * @author houlei
 */
@Data
public class BeanDefinition {
    private String beanName;

    private Class<?> beanClass;
}
