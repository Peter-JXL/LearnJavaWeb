package com.peterjxl.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();

        // 2. 动态代理增强 Lenovo对象
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sale")){
                    System.out.println("专车接送买电脑.....");
                    double money = (double) args[0];
                    money *= 1.1;
                    Object result = method.invoke(lenovo, money);
                    System.out.println("免费送货.....");
                    return result + "键盘和鼠标";
                }else {
                    Object result = method.invoke(lenovo, args);
                    return result;
                }
            }
        });

        //3.调用方法
        String computer = proxy_lenovo.sale(8000);
        proxy_lenovo.show();
        System.out.println(computer);
    }
}
