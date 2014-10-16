package JavaReflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReMethod {
	public static void main(String[] args) throws Exception{
//		new ReMethod().Foo();
		new ReMethod().gConstructor();
	}
	
	public void gConstructor() throws Exception{
		Class<?> clz = Class.forName("JavaReflex.Susie");
		Field ff = clz.getDeclaredField("susie");
		int a = ff.getModifiers();
		System.out.println(Modifier.toString(a));
		Class<?> type = ff.getType();
		System.out.println(type.getName());
	}
	
	public void Foo() throws Exception{
//		Class<?> clz = new Susie().getClass();
		Class<?> clz = Class.forName("JavaReflex.Susie");
		Object o = clz.newInstance();
		Method m = clz.getMethod("helloWorld",String.class,String.class);
		
		for(int i=0;i<16;i++){
			m.invoke(o, Integer.toString(i),"David");
		}
	}
	
	public void hell(){
		Method[] methods = new Susie().getClass().getMethods();

		for(Method me:methods){
			System.out.println(me);
		}
	}
}

class Susie2 {
	public String helloWorld(String name){
		System.out.println("what you name?¡¡£º"+name);
		System.out.println("I am Susie!");
		return "Susie";
	}
	
	public void IamNotGood(){
		
	}
}

