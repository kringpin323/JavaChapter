package JDKDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class JavaMemory {
	public static void main(String[] args)
	{
		try
		{
			Runtime r  = Runtime.getRuntime();
			System.out.println(r.freeMemory());
			List list = new ArrayList();
//			ArrayList list = new ArrayList();
			list.add(10);
			list.add(100);
			System.out.println(r.freeMemory());
			
			ArrayList list2 = new ArrayList();
			
			System.out.println(r.freeMemory());
			//System.out.println(list.size());
			
			// test answer for David 
			// @Date 2014-10-08
			// 同样的代码运行情况也不一定
			// ArrayList 93377800
			// List 92874464
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
