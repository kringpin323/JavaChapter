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
		
		Class<? super FancyToy> up = ftClass.getSuperclass(); // ����˵������� ���ܳ������ȷ��ʾ��ʽ

		System.out.println(up); // class RTTI.Toy ����˳���
		
		up = FancyToy.class; // ������Ա����˵����FancyToy ������߳��඼����
		
//		Class<Toy> up2 = ftClass.getSuperclass(); // �޷����룬˵���˷��ص���ʵ���ǳ���
		
		Class<Toy> up3 = (Class<Toy>) up; // ΪʲôҪת�ͣ�
		
		Object obj = up.newInstance(); // ����˵����Ȼ up��Toy�࣬����newInstanceֻ������ object���󣬵�ȷ������
		
	}
	
	// �����д�˺ܶ��instanceof���ʽ��˵����ƿ��ܴ���覴ã�����˵SpringԴ��ô��
	public void Cast(){ // ����Ҫ�� cast ����
		Double ab = 10.0;
		Integer abc = Integer.valueOf(1);
		if(abc instanceof Integer) // ����õ� ClassCastException�����
			System.out.println("Yes");
		else{
			System.out.println("No");
		}
	}
	
	public void WildClassReferences(){
		// ͨ��� ? �κ�����
		Class<?> intClass = int.class;
		intClass = double.class; // ���ڶ�������
		Class<? extends Number> bounded = int.class; // Number���ͻ����κ�Number���͵�����
		bounded = double.class;
		bounded = Number.class;
	}
	
	public void testIntegerAndInt(){
		Class intClass = int.class; // 
		Class<Integer> genericIntClasss = int.class;
		System.out.println(genericIntClasss == int.class); // ������� true
		genericIntClasss = Integer.class; // Same thing
		System.out.println(genericIntClasss == int.class); // ������� false
		// ���� Class<Integer> �ܽ��� int.class �� Integer.class
		intClass = double.class;
//		genericIntClasss = double.class; // ���ܣ���Ϊ ��ͬ����
		System.out.println(Integer.class == int.class); // ��� false
	}
}
