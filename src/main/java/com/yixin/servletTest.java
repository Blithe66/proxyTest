package com.yixin;

import org.assertj.core.internal.cglib.proxy.Enhancer;

import javax.servlet.http.HttpServlet;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class servletTest extends HttpServlet {

    public static void main(String[] args) {
        //cglib动态代理
        MyCglibInterceptor myCglibInterceptor = new MyCglibInterceptor();
        Enhancer enhancer = new Enhancer();
        ProxyDemoImpl proxyDemo = new ProxyDemoImpl();
        enhancer.setSuperclass( proxyDemo.getClass());
        enhancer.setCallback(myCglibInterceptor);
        ProxyDemoImpl proxyDemo1 = (ProxyDemoImpl) enhancer.create();
        proxyDemo1.getName();
        proxyDemo1.getAge();

        //jdk动态代理
        ProxyDemo proxyDemo2 = new ProxyDemoImpl();
        InvocationHandler jdkProxyDemoImpl = new jdkProxyDemoImpl(proxyDemo);
        ProxyDemo proxyDemo3 = (ProxyDemo) Proxy.newProxyInstance(proxyDemo2.getClass().getClassLoader(), proxyDemo2.getClass().getInterfaces(), jdkProxyDemoImpl);
        proxyDemo3.getName();
        proxyDemo3.getAge();
    }
}
