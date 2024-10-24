package org.hl.springlearn.beanlivedemo;

import lombok.extern.slf4j.Slf4j;
import org.hl.springlearn.beanlivedemo.simple.PersonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author houlei
 */
@Slf4j
public class BeanLiveApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanlivedemo/spring-config.xml");
        /**
         * Bean创建过程可以查看 AbstractBeanFactory#doGetBean 方法
         * 实例化Bean的流程可以查看 AbstractAutowireCapableBeanFactory#createBeanInstance 方法
         * 赋值属性的流程可以查看 AbstractAutowireCapableBeanFactory#populateBean 方法
         * 初始化Bean的流程可以查看 AbstractAutowireCapableBeanFactory#initializeBean 方法
         * 销毁Bean的流程可以查看 AbstractApplicationContext#destroy 方法
         */
        PersonBean personBean = (PersonBean) context.getBean("personBean");
        log.info("初始化后-----------名字：{}", personBean.getName());
        personBean.work();
        ((ClassPathXmlApplicationContext) context).destroy();
    }

}
