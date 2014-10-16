package JavaPattern;

/*
 * intern是一个native的方法，
 * 但按照其文档解释，应该是JVM维护了一个当前进程曾经出现过的字符串的hash表，
 * 在调用intern时，会查询该表。如果已经存在，则直接返回对该String的引用；
 * 如果没有，则创建一个，并加入到hash中。
 * 
 * 另外，如果使用字面量(literal)来定义字符串，则自动会调用intern，从而减少内存占用
 * */

public class StringIntern {
	public static void main(String[] args) {
		System.out.println(sameOrNot());
		System.out.println(InternSame());
		System.out.println(InternLiteral());
	}
	
	public static boolean sameOrNot(){
		String a = new String("abc");
		String b = new String("abc");
		return a==b;
	}
	
	public static boolean InternSame(){
		String a = new String("abc").intern();
		String b = new String("abc").intern();
		return a==b;
	}
	
	public static boolean InternLiteral(){
		String a = new String("abc");
		String b = "abc";
		String c = "abc".intern();// 调用与否效果一样
		return b==c;
	}
}
