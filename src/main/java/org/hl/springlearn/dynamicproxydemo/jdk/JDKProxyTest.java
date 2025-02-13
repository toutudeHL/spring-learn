package org.hl.springlearn.dynamicproxydemo.jdk;

import java.lang.reflect.Proxy;

public class JDKProxyTest {

    /**
     * 主方法，用于测试JDK动态代理
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建目标对象，即被代理的对象
        HelloService target = new HelloServiceImpl();
        // 创建代理处理器，用于在方法调用前后添加额外的逻辑
        JDKProxyHandler handler = new JDKProxyHandler(target);
        // 创建代理对象，使用Proxy.newProxyInstance方法
        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                // 目标对象的类加载器
                target.getClass().getClassLoader(),
                // 目标对象实现的接口
                target.getClass().getInterfaces(),
                // 代理处理器
                handler);
        // 调用代理对象的方法，实际调用的是代理处理器的invoke方法
        proxy.sayHello();
    }

}