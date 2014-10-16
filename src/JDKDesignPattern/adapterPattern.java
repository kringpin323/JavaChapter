package JDKDesignPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class adapterPattern {
	public static void main(String... args) {
		adapterPatt();
		
	}
	
	public static void adapterPatt(){
		List abc = java.util.Arrays.asList("abc","adf","dfd");
		List abc1 = new ArrayList<String>(abc);
		System.out.println(abc);
	}
	
	public static void adapterIn(){
		InputStreamReader inR = new InputStreamReader(System.in);
		BufferedReader inB = new BufferedReader(inR);
		
	}
}
