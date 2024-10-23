package org.hl.springlearn.iocdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author houlei
 */
@Slf4j
public class iocApplication {

    public static void main(String[] args) {
        //1.创建bean工厂(同时完成了加载资源、创建注册单例bean注册器的操作)
        BeanFactory beanFactory = new BeanFactory();

        //2.第一次获取bean（通过反射创建bean，缓存bean）
        log.info("第一次获取bean");
        BeanDao userDao1 = (BeanDao) beanFactory.getBean("BeanDao");
        userDao1.hello();
        log.info("----------------------");
        log.info("第二次获取bean");
        //3.第二次获取bean（从缓存中获取bean）
        BeanDao userDao2 = (BeanDao) beanFactory.getBean("BeanDao");
        userDao2.hello();
    }
}
