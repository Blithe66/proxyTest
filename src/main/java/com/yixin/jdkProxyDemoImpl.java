package com.yixin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class jdkProxyDemoImpl implements InvocationHandler {
    private ProxyDemo proxyDemo;

    public jdkProxyDemoImpl() {
    }

    public jdkProxyDemoImpl(ProxyDemo proxyDemo) {
        super();
        this.proxyDemo = proxyDemo;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String name = method.getName();
        if("getName".equals(name)){
            System.out.println("-------=====before===------"+method.getName());
            Object invoke = method.invoke(proxyDemo, args);
            System.out.println("-------=====after=====-------" + method.getName());
            return invoke;
        }else{
            return method.invoke(proxyDemo,args);
        }
    }
}
