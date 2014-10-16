package JDKDesignPattern;

public class FactoryPattern {
	public static void main(String[] args) throws Exception{
		Integer abc = Integer.valueOf(12); // -128 到 127 之间的装箱
		Integer a200 = Integer.valueOf(200);
		Integer b200 = Integer.valueOf(200);
		System.out.println(a200==b200); // false
		
		Integer a127 = Integer.valueOf(127);
		Integer b127 = Integer.valueOf(127);
		System.out.println(a127==b127); // true
		
		Integer new127 = new Integer(127);
		Integer new127b = new Integer(127);
		System.out.println(new127 == new127b); // false
		
//		Class.forName("adapterPattern"); // 
	}
}
