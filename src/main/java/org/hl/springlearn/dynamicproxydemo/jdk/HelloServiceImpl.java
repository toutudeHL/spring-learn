package org.hl.springlearn.dynamicproxydemo.jdk;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }

}