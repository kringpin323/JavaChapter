package JavaPattern;

/*
 * intern��һ��native�ķ�����
 * ���������ĵ����ͣ�Ӧ����JVMά����һ����ǰ�����������ֹ����ַ�����hash��
 * �ڵ���internʱ�����ѯ�ñ�����Ѿ����ڣ���ֱ�ӷ��ضԸ�String�����ã�
 * ���û�У��򴴽�һ���������뵽hash�С�
 * 
 * ���⣬���ʹ��������(literal)�������ַ��������Զ������intern���Ӷ������ڴ�ռ��
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
		String c = "abc".intern();// �������Ч��һ��
		return b==c;
	}
}
