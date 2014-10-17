package RTTI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
	// 被代理者
	private Object proxied;
	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}
	// 代理类， 下面的Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real))
	// 中的第二个参数的接口中的其中一个方法，至于是哪个方法就看调用情况
	// 第三个参数 args 就是调用方法里面的 参数
	// 最后返回 使用 被代理者（原本类）的方法返回值，结束操作
	// 因此 JDK的动态代理必须实现Interface，参数要求必须有Interface列表
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("*** proxy: "+proxy.getClass()+"| method: "+method+"| args: "+args);
		if(args!= null)
			for(Object arg:args)
				System.out.println(" "+arg);
		return method.invoke(proxied, args);
	}
}

// 动态代理重写 
public class SimpleDynamicProxy{
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bamboo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		
		System.out.println("======分割线==========");
		
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}
}


