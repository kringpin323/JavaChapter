package RTTI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * �˴��и�Java 8 ��������
 * ���� Factory�Ǻ���ʽ��̽ӿ�
 * ��Lamdba ��д�������
 * */
δ // ���������ң��������������δ���
public class Part {
	// ��������Ļ����д��������б������������࣬���๤�� ע�ᵽ������ά���Ĺ����б���
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			// ����10������
			System.out.println(Part.createRandom());
		}
	}
	
	public String toString(){
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	static {
		// �����б� ����� 7 ������
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
	}
	private static Random rand = new Random(47);
	public static Part createRandom(){
		int n = rand.nextInt(partFactories.size());
		// ���ȡ����������ʹ�ù������ɲ�Ʒ
		return partFactories.get(n).create();
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
	public static class Factory implements RTTI.Factory<AirFilter>{
		public AirFilter create(){
			return new AirFilter();
		}
	}
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








