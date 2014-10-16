package JDKDesignPattern;

public class PrototypePattern {
	public static void main(String[] args) {
		
	}
	
	public static void abc(){
		Object abc = new Object();
		ObjectForClone abc2 = new ObjectForClone();
		//继承自java.lang.Object.clone()方法是浅层复制
		// 这个可以通过代码证明
		abc2.clone();
//		ObjectForClone abc2 = new ObjectForClone();
	}
}	

class ObjectForClone implements Cloneable{
	public Object clone(){
		Object o = null;
		try{
			o = super.clone();
		}catch(CloneNotSupportedException e){
			System.out.println(e.toString());
		}
		return o;
	}
}
