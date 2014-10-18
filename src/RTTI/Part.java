package RTTI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 此处有个Java 8 的新任务，
 * 由于 Factory是函数式编程接口
 * 用Lamdba 改写这个程序
 * */
// 错误，提升我，这个程序还有任务未完成
public class Part {
	// 在最基本的基类中创建工厂列表，基类生产超类，超类工厂 注册到基类中维护的工厂列表中
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			// 创建10个工厂
			System.out.println(Part.createRandom());
		}
	}
	
	public String toString(){
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	static {
		// 工厂列表 添加了 7 个工厂
		
		
		partFactories.add(()->new FuelFilter());
		partFactories.add(()->new AirFilter());
		partFactories.add(()->new CabinFilter());
		partFactories.add(()->new OilFilter());
		
		partFactories.add(()->new FanBelt());
		partFactories.add(()->new GeneratorBelt());
		partFactories.add(new PowerSteeringBelt.Factory());
	}
	private static Random rand = new Random(47);
	public static Part createRandom(){
//		int n = rand.nextInt(partFactories.size());
		// 随机取出工厂并且使用工厂生成产品
		return partFactories.get(1).create();
	}
}

class Filter extends Part{}

class FuelFilter extends Filter{
	public static class Factory implements RTTI.Factory<FuelFilter>{
		@Override
		public FuelFilter create() {
			// TODO Auto-generated method stub
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter{
//	public static class Factory implements RTTI.Factory<AirFilter>{
//		public AirFilter create(){
//			return new AirFilter();
//		}
//	}
}

class CabinFilter extends Filter{
	public static class Factory implements RTTI.Factory<CabinFilter>{
		public CabinFilter create(){
			return new CabinFilter();
		}
	}
}

class OilFilter extends Filter{
	public static class Factory implements RTTI.Factory<OilFilter>{
		public OilFilter create(){
			return new OilFilter();
		}
	}
}

class Belt extends Part{}

class FanBelt extends Belt{
	public static class Factory implements RTTI.Factory<FanBelt>{
		public FanBelt create(){return new FanBelt();}
	}
}
class GeneratorBelt extends Belt{
	public static class Factory implements RTTI.Factory<GeneratorBelt>{
		public GeneratorBelt create(){return new GeneratorBelt();}
	}
}

class PowerSteeringBelt extends Belt{
	public static class Factory implements RTTI.Factory<PowerSteeringBelt>{
		public PowerSteeringBelt create(){return new PowerSteeringBelt();}
	}
}








