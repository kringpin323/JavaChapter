package JDKDesignPattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactoryMethod {
	public static void main(String[] args) {
		
	}
	
	public static void FactoryM1(){
		//Collection �� Iterator() ����Դ�����������ʹ���Ǹ� Iterator()
		// ArrayList ʹ���Լ��� Iterator()
		List abc1 = new ArrayList<String>();
		// LinkedList ʹ�� AbstractList �� Iterator()
		List abc2 = new LinkedList<String>();
	}
}
