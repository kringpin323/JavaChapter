package RTTI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
	// ��������
	private Object proxied;
	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}
	// �����࣬ �����Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real))
	// �еĵڶ��������Ľӿ��е�����һ���������������ĸ������Ϳ��������
	// ���������� args ���ǵ��÷�������� ����
	// ��󷵻� ʹ�� �������ߣ�ԭ���ࣩ�ķ�������ֵ����������
	// ��� JDK�Ķ�̬�������ʵ��Interface������Ҫ�������Interface�б�
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

// ��̬������д 
public class SimpleDynamicProxy{
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bamboo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		
		System.out.println("======�ָ���==========");
		
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}
}


