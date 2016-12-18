/*
* Copyright (c) 2016 Tom Deng
* 
* Permission is hereby granted, free of charge, to any person obtaining
* a copy of this software and associated documentation files (the
* "Software"), to deal in the Software without restriction, including
* without limitation the rights to use, copy, modify, merge, publish,
* distribute, sublicense, and/or sell copies of the Software, and to
* permit persons to whom the Software is furnished to do so, subject to
* the following conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
* LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
* OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
* WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package tech.codemaster.pattern.gof.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tomdeng<14068728@qq.com>
 * @since 1.0
 */
public class JdkDynamicProxyFactory implements InvocationHandler {
    private Object target;

    /**
     * 构造方法
     *
     * @param target 目标对象
     */
    public JdkDynamicProxyFactory(Object target) {
        super();
        this.target = target;
    }


    /**
     * 执行目标对象的方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------before------------------");
        // 执行目标对象的方法
        Object result = method.invoke(target, args);
        // 在目标对象的方法执行之后简单的打印一下
        System.out.println("-------------------after------------------");
        return result;
    }

    /**
     * 获取目标对象的代理对象
     *
     * @return 代理对象
     */
    public Object getProxy() {
        return java.lang.reflect.Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
