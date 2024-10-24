package org.hl.springlearn.beanlivedemo.simple;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author houlei
 */
@Data
@Slf4j
public class PersonBean implements InitializingBean, BeanFactoryAware, BeanNameAware, DisposableBean {

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private Integer idCard;

    public PersonBean() {
        log.info("【实例化】");
        log.info("1.调用构造方法：我出生了！");
        log.info("【实例化】完成-----------");
        log.info("实例化后-----------名字：{}", this.name);
        log.info("2.设置属性：出生登记");
    }

    @Override
    public void setBeanName(String s) {
        log.info("【初始化】");
        log.info("3.调用BeanNameAware#setBeanName方法:我要上学了，起了个学名");
        log.info("setBeanName后-----------名字：{}", this.name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("4.调用BeanFactoryAware#setBeanFactory方法：选好学校了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("6.InitializingBean#afterPropertiesSet方法：入学登记");
    }

    public void init() {
        log.info("7.自定义init方法：努力上学ing");
    }

    @Override
    public void destroy() throws Exception {
        log.info("【销毁】");
        log.info("9.DisposableBean#destroy方法：平淡的一生落幕了");
    }

    public void destroyMethod() {
        log.info("10.自定义destroy方法:睡了，别想叫醒我");
        log.info("【销毁】完成-----------------------");
    }

    public void work() {
        log.info("【使用中】");
        log.info("Bean使用中：工作，只有对社会没有用的人才放假");
        log.info("【使用中】完成---------------------------");
    }

}

