package JDKDesignPattern;

import java.util.concurrent.Callable;
import java.util.concurrent.*;

public class TemplateStrategyCommand {
	public static void main(String[] args) {

	}

	public static void Command1(){
		//		ThreadPoolExecutor; 这个的使用没有 下面的用法方便
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new test1());
		exec.submit(new test1());
		exec.submit(new test2());
		// 将调用者和接收者在空间和时间上解耦合
		//		exec.invokeAll()

	}

	public static void Strategy1(){
		ThreadPoolExecutor aaa1 = new ThreadPoolExecutor(1,1,1,null,null);
		// 策略模式，选择策略
		/*
		 * ThreadPoolExecutor.AbortPolicy：表示拒绝任务并抛出异常
			ThreadPoolExecutor.DiscardPolicy：表示拒绝任务但不做任何动作
			ThreadPoolExecutor.CallerRunsPolicy：表示拒绝任务，并在调用者的线程中直接执行该任务
			ThreadPoolExecutor.DiscardOldestPolicy：表示先丢弃任务队列中的第一个任务，然后把这个任务加进队列。
		 */
		aaa1.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	}
	
	public static void Template1(){
		ThreadPoolExecutor aaa1 = new ThreadPoolExecutor(1,1,1,null,null);
		// 这个只在源码内部可以看到，已经不知道具体情况，所以模板方法我其实看不太懂
		//		ThreadPoolExecutor.Worker;
		
	}
}

// 封装操作，使接口一致
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
