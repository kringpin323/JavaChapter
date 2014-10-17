package RTTI;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
interface David{}

class Toy{
//	Toy(){} 
// 我们看看到底会发生什么？
// 抛出不能初始化 情况
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, David{
	FancyToy(){ super(1); }
}

public class testRTTI {
	
	static void printInfo(Class cc){
		System.out.println("class name："+cc.getName()+" is interface? ["+cc.isInterface()+"]");
		System.out.println("Simple name: "+ cc.getSimpleName());
		System.out.println("Canonical name: "+cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		// Java 使用 Class 对象来执行其RTTI
		Class c = null;
		try{
			c = Class.forName("RTTI.FancyToy");
		}catch(ClassNotFoundException e){
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face: c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass(); // 得到了超类
		Object obj = null;
		try{
			obj = up.newInstance();
		}catch(InstantiationException e){
			System.out.println("Cannot instantiate");
			System.exit(1);
		}catch(IllegalAccessException e){
			System.out.println("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}



