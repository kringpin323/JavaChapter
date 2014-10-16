package JDKDesignPattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactoryMethod {
	public static void main(String[] args) {
		
	}
	
	public static void FactoryM1(){
		//Collection 的 Iterator() 是起源，有子类决定使用那个 Iterator()
		// ArrayList 使用自己的 Iterator()
		List abc1 = new ArrayList<String>();
		// LinkedList 使用 AbstractList 的 Iterator()
		List abc2 = new LinkedList<String>();
	}
}
