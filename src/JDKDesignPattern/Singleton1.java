package JDKDesignPattern;

import java.text.DecimalFormat;

public class Singleton1 {
	public static void main(String[] args) {
		Runtime.getRuntime();
	}
	
	public static void sing(){
		// 这个我TM真服了
		DecimalFormat ab = new DecimalFormat();
	}
}
