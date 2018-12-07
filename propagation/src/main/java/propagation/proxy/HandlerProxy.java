package propagation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HandlerProxy implements InvocationHandler {

    Object targetObject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke handler");
        Object result = method.invoke(targetObject, args);
        System.out.println("after invoke handler");
        return result;
    }

    public Object getProxyObject(Object object) {
        this.targetObject = object;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        ((IUserManager) new HandlerProxy().getProxyObject(new UserManager())).addUser();
    }

}
