package RTTI;

class Base{}
class Derived extends Base{}

public class DiffInstanClass {
	static void test(Object x){
		System.out.println(x.getClass());
		System.out.println(x instanceof Base);
		System.out.println(x instanceof Derived);
		System.out.println(Base.class.isInstance(x));
		System.out.println(Derived.class.isInstance(x));
		// ����������𣿻���������������������
		System.out.println(x.getClass() == Base.class);
		System.out.println(x.getClass() == Derived.class);
		System.out.println(x.getClass().equals(Base.class));
		System.out.println(x.getClass().equals(Derived.class));
		// ȷ������
	}
	
	public static void main(String[] args) {
		test(new Base());
		/*
class RTTI.Base
true
false
true
false
true
false
true
false
		 * */
		test(new Derived());
		/*
class RTTI.Derived
true
true
true
true
false
true
false
true
		 * */
	}
}
