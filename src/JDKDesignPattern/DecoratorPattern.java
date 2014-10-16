package JDKDesignPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PushbackReader;
import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class DecoratorPattern {
	public static void main(String[] args) {

	}

	public void abc(){
		// 还是搞不定
		InputStreamReader ab = new InputStreamReader(System.in);

		BufferedReader aa = new BufferedReader(ab);

		PushbackReader bb = new PushbackReader(aa);

		StringBufferInputStream abc = new StringBufferInputStream(new ObjectInputStream(System.in));
	}
	
	public void aa1(){
		ArrayList abc = new ArrayList();
	}
}
