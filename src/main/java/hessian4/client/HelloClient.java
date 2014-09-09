package hessian4.client;

import com.caucho.hessian.client.HessianProxyFactory;
import hessian4.interf.Hello;

import java.net.MalformedURLException;

/**
 * @author zhijing.huang
 *         Created by zhijing.huang on 2014/9/9.
 */
public class HelloClient {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:8080/HessianServer/hessian";
        HessianProxyFactory factory = new HessianProxyFactory();
        Hello d = (Hello) factory.create(Hello.class, url);
        System.out.println(d.sayHello("janus"));
        d.printHello("Hessian");
    }
}
