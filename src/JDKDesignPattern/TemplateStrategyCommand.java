package JDKDesignPattern;

import java.util.concurrent.Callable;
import java.util.concurrent.*;

public class TemplateStrategyCommand {
	public static void main(String[] args) {

	}

	public static void Command1(){
		//		ThreadPoolExecutor; �����ʹ��û�� ������÷�����
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new test1());
		exec.submit(new test1());
		exec.submit(new test2());
		// �������ߺͽ������ڿռ��ʱ���Ͻ����
		//		exec.invokeAll()

	}

	public static void Strategy1(){
		ThreadPoolExecutor aaa1 = new ThreadPoolExecutor(1,1,1,null,null);
		// ����ģʽ��ѡ�����
		/*
		 * ThreadPoolExecutor.AbortPolicy����ʾ�ܾ������׳��쳣
			ThreadPoolExecutor.DiscardPolicy����ʾ�ܾ����񵫲����κζ���
			ThreadPoolExecutor.CallerRunsPolicy����ʾ�ܾ����񣬲��ڵ����ߵ��߳���ֱ��ִ�и�����
			ThreadPoolExecutor.DiscardOldestPolicy����ʾ�ȶ�����������еĵ�һ������Ȼ����������ӽ����С�
		 */
		aaa1.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	}
	
	public static void Template1(){
		ThreadPoolExecutor aaa1 = new ThreadPoolExecutor(1,1,1,null,null);
		// ���ֻ��Դ���ڲ����Կ������Ѿ���֪���������������ģ�巽������ʵ����̫��
		//		ThreadPoolExecutor.Worker;
		
	}
}

// ��װ������ʹ�ӿ�һ��
class test1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

class test2 implements Callable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
