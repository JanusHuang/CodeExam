package hessian4.server;

import hessian4.interf.Hello;

/**
 * @author zhijing.huang
 *         Created by zhijing.huang on 2014/9/9.
 */
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return name != null ? "hello " + name : "hello hessian";
    }

    @Override
    public void printHello(String name) {
        System.out.println("Hello " + name);
    }
}
