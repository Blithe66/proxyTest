package com.yixin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemoImpl implements ProxyDemo{
    public String getName() {
        System.out.println("tom");
        return "tom";
    }
    public int getAge() {
        System.out.println(11);
        return 11;
    }
}
