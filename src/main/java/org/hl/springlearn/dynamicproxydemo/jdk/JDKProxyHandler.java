package org.hl.springlearn.dynamicproxydemo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理处理器
 * 实现了InvocationHandler接口，用于在方法调用前后添加额外的逻辑
 */
public class JDKProxyHandler implements InvocationHandler {

    // 目标对象，即被代理的对象
    private Object target;

    /**
     * 构造方法，用于初始化目标对象
     *
     * @param target 被代理的对象
     */
    public JDKProxyHandler(Object target) {
        this.target = target;
    }

    /**
     * 重写InvocationHandler接口的invoke方法
     * 在方法调用前后添加额外的逻辑
     *
     * @param proxy  代理对象
     * @param method 被调用的方法
     * @param args   方法的参数
     * @return 方法的返回值
     * @throws Throwable 可能抛出的异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在方法调用前打印日志
        System.out.println("Before method invocation");
        // 调用目标对象的方法
        Object result = method.invoke(target, args);
        // 在方法调用后打印日志
        System.out.println("After method invocation");
        // 返回方法的返回值
        return result;
    }

}
