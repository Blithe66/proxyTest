package com.yixin;



import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object var1, Method var2, Object[] var3, MethodProxy var4) throws Throwable {
        System.out.println("-----before------"+var2.getName());
        Object o = var4.invokeSuper(var1, var3);
        System.out.println("=-----after-----"+var2.getName());
        return o;
    }
}
