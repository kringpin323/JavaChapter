package JDKDesignPattern;

import java.util.Observable;
import java.util.Observer;

public class ObserverPattern {
	public static void main(String[] args) {
//		Observer
		// 没实际使用，还是不是特别理解
	}
}

class ConcreteObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}

class ConcreteObservable extends Observable{
	
}