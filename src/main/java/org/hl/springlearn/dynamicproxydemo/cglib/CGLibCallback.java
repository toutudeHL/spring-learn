package org.hl.springlearn.dynamicproxydemo.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理回调类
 * 实现了MethodInterceptor接口，用于在方法调用前后添加额外的逻辑
 */
public class CGLibCallback implements MethodInterceptor {

    /**
     * 重写MethodInterceptor接口的intercept方法
     * 在方法调用前后添加额外的逻辑
     *
     * @param o           代理对象
     * @param method      被调用的方法
     * @param objects     方法的参数
     * @param methodProxy 方法代理对象
     * @return 方法的返回值
     * @throws Throwable 可能抛出的异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 在方法调用前打印日志
        System.out.println("Before method invocation by CGLib");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After method invocation by CGLib");
        return result;
    }

}