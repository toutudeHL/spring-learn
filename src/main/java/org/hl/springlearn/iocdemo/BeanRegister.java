package org.hl.springlearn.iocdemo;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 对象注册器，这里用于单例bean的缓存
 *
 * @author houlei
 */
@Slf4j
public class BeanRegister {

    //单例Bean缓存
    private Map<String, Object> singletonMap = new HashMap<>(32);

    /**
     * 获取单例Bean
     *
     * @param beanName bean名称
     * @return 单例Bean缓存
     */
    public Object getSingletonBean(String beanName) {
        return singletonMap.get(beanName);
    }

    /**
     * 注册单例bean
     *
     * @param beanName bean名称
     * @param bean     bean实例
     */
    public void registerSingletonBean(String beanName, Object bean) {
        log.debug("注册单例bean:{}", beanName);
        if (singletonMap.containsKey(beanName)) {
            return;
        }
        singletonMap.put(beanName, bean);
    }

}


