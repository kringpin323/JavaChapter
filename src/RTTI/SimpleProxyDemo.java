package RTTI;

interface Interface{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Do something");
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("Do something else "+arg);
	}
	
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy do sth");
		proxied.doSomething();
	}
	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy do sth else");
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bamboo");
	}
	
	public static void main(String[] args) {
		consumer(new RealObject());
		System.out.println("=================·Ö¸î==========");
		consumer(new SimpleProxy(new RealObject()));
	}
}
