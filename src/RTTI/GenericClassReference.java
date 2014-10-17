package RTTI;

public class GenericClassReference {
	public static void main(String[] args) throws Exception{
//		new GenericClassReference().Generic();
		GenericClassReference GCRF = new GenericClassReference();
		GCRF.Cast();
	}
	
	public void Generic() throws Exception{
		Class<FancyToy> ftClass = FancyToy.class;
		
		FancyToy fancyToy = ftClass.newInstance();
		
		Class<? super FancyToy> up = ftClass.getSuperclass(); // 或者说，这才是 接受超类的正确表示形式

		System.out.println(up); // class RTTI.Toy 输出了超类
		
		up = FancyToy.class; // 这里可以编译就说明，FancyToy 本身或者超类都可以
		
//		Class<Toy> up2 = ftClass.getSuperclass(); // 无法编译，说明了返回的其实不是超类
		
		Class<Toy> up3 = (Class<Toy>) up; // 为什么要转型？
		
		Object obj = up.newInstance(); // 就是说，虽然 up是Toy类，但是newInstance只是生成 object对象，的确含糊了
		
	}
	
	// 程序编写了很多的instanceof表达式，说明设计可能存在瑕疵，这是说Spring源码么？
	public void Cast(){ // 很重要的 cast 方法
		Double ab = 10.0;
		Integer abc = Integer.valueOf(1);
		if(abc instanceof Integer) // 避免得到 ClassCastException的情况
			System.out.println("Yes");
		else{
			System.out.println("No");
		}
	}
	
	public void WildClassReferences(){
		// 通配符 ? 任何事物
		Class<?> intClass = int.class;
		intClass = double.class; // 现在都可以了
		Class<? extends Number> bounded = int.class; // Number类型或者任何Number类型的子类
		bounded = double.class;
		bounded = Number.class;
	}
	
	public void testIntegerAndInt(){
		Class intClass = int.class; // 
		Class<Integer> genericIntClasss = int.class;
		System.out.println(genericIntClasss == int.class); // 蛋，输出 true
		genericIntClasss = Integer.class; // Same thing
		System.out.println(genericIntClasss == int.class); // 蛋，输出 false
		// 就是 Class<Integer> 能接受 int.class 和 Integer.class
		intClass = double.class;
//		genericIntClasss = double.class; // 不能，因为 不同类型
		System.out.println(Integer.class == int.class); // 输出 false
	}
}
