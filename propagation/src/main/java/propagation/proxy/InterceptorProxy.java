package propagation.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class InterceptorProxy implements MethodInterceptor {

    Object targetObject;

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke interceptor");
        Object result = methodProxy.invoke(targetObject, args);
        System.out.println("before invoke interceptor");
        return result;
    }

    public Object getProxyObject(Object object) {
        this.targetObject = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(targetObject.getClass());
        return enhancer.create();
    }

    public static void main(String[] args) {
        ((UserManager) new InterceptorProxy().getProxyObject(new UserManager())).addUser();
    }

}
