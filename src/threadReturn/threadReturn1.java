package threadReturn;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class threadReturn1 {
	
	 public static void main(String[] args) {
		 callable1();
		 callable2();
	}
	
	 public static void callable1() {  
	        Callable<Integer> callable = new Callable<Integer>() {  
	            public Integer call() throws Exception {  
	                return new Random().nextInt(100);  
	            }  
	        };  
	        FutureTask<Integer> future = new FutureTask<Integer>(callable);  
	        new Thread(future).start();  
	        try {  
	            Thread.sleep(5000);// ������һЩ����  
	            System.out.println(future.get());  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        } catch (ExecutionException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	 
	 	public static void callable2(){
	 		ExecutorService threadPool = Executors.newSingleThreadExecutor();  
	        Future<Integer> future = threadPool.submit(new Callable<Integer>() {  
	            public Integer call() throws Exception {  
	                return new Random().nextInt(100);  
	            }  
	        });  
	        try {  
	            Thread.sleep(5000);// ������һЩ����  
	            System.out.println(future.get());  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        } catch (ExecutionException e) {  
	            e.printStackTrace();  
	        }  
	 	}
	 	
	 	public static void callable3(){
	 		 ExecutorService threadPool = Executors.newCachedThreadPool();  
	         CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);  
	         for(int i = 1; i < 5; i++) {  
	             final int taskID = i;  
	             cs.submit(new Callable<Integer>() {  
	                 public Integer call() throws Exception {  
	                     return taskID;  
	                 }  
	             });  
	         }  
	         // ������һЩ����  
	         for(int i = 1; i < 5; i++) {  
	             try {  
	                 System.out.println(cs.take().get());  
	             } catch (InterruptedException e) {  
	                 e.printStackTrace();  
	             } catch (ExecutionException e) {  
	                 e.printStackTrace();  
	             }  
	         }  
	 	}
}
