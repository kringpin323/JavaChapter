package JDKDesignPattern;

public class PrototypePattern {
	public static void main(String[] args) {
		
	}
	
	public static void abc(){
		Object abc = new Object();
		ObjectForClone abc2 = new ObjectForClone();
		//�̳���java.lang.Object.clone()������ǳ�㸴��
		// �������ͨ������֤��
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
