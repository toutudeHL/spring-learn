package org.hl.springlearn.dynamicproxydemo.cglib;


import org.springframework.cglib.proxy.Enhancer;

public class CGLibProxyTest {

    /**
     * 主方法，用于测试CGLib动态代理
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建Enhancer对象，用于生成代理类
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类，即被代理的类
        enhancer.setSuperclass(GreetingService.class);
        // 设置代理类的回调对象，即方法拦截器
        enhancer.setCallback(new CGLibCallback());
        // 创建代理对象
        GreetingService proxy = (GreetingService) enhancer.create();
        // 调用代理对象的方法，实际调用的是回调对象的intercept方法
        proxy.sayHello();
    }

}