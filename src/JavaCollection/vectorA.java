
package JavaCollection;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;


public class vectorA {
	public static void main(String[] args) {
		//		Vector a = new Vector();
		new1();
	}

	// 内存泄露？
	public static void new1(){
		Vector<David> v = new  Vector( 10 );  
//		ArrayList
		
		
		
		//		for  ( int  i = 1 ;i < 100 ; i ++ ){  
		//			Object o = new  Object();  
		//			v.add(o);  
		//			o = null;  
		//		} 
		David o =  new David(1);

		o.getClass().getClassLoader();
		David.class.getClassLoader();
		
		v.add(o);
		o.setNum(2);
		System.out.println(v);
		v.get(0).setNum(3);
		System.out.println(v);

		System.out.println(o==v.get(0)); // true 同一个对象

		v.setElementAt(null, 0);

		System.out.println(v); // 确实是两个引用，那么就可以解释 程序员写程序层次的 内存溢出了。

		//		v = null;
		o.setNum(4);
		System.out.println(o);
	}

	public static void new2(){
//		SoftReference  
//
//		WeakReference 
//
//		PhantomReference 
//
//		FinalReference
	}

	public static void new3(){
//		ConcurrentHashMap
		Hashtable ab= new Hashtable();
		ArrayList a1 = new ArrayList();
	}
}

class FileSearch{  
	private byte [] content;  
	private File mFile;  
	public FileSearch(File file){  
		mFile = file;  
	}  
//	public boolean hasString(String str){  
//		int size = getFileSize(mFile);  
//		content =  new  byte [size];  
//		loadFile(mFile, content);  
//		String s =  new String(content);  
//		return s.contains(str);  
//	}  
} 

class David{
	private int num=0;

	public David(int num){
		this.num = num;
	}

	public void setNum(int num){
		this.num = num;
	}

	public String toString(){
		return "I am class David "+num+" !";
	}
}

class  SoftHashMap  extends  AbstractMap  {   
	/**  The internal HashMap that will hold the SoftReference.  */    
	private   final  Map hash  =   new  HashMap();   
	/**  The number of "hard" references to hold internally.  */    
	private   final   int  HARD_SIZE;   
	/**  The FIFO list of hard references, order of last access.  */    
	private   final  LinkedList hardCache  =   new  LinkedList();   
	/**  Reference queue for cleared SoftReference objects.  */    
	private  ReferenceQueue queue  =   new  ReferenceQueue();   
	// Strong Reference number   
	public  SoftHashMap()  {  this ( 100 ); }    
	public  SoftHashMap( int  hardSize)  { HARD_SIZE  =  hardSize; }    

	public  Object get(Object key)  {   
		Object result  =   null ;   
		//  We get the SoftReference represented by that key    
		SoftReference soft_ref  =  (SoftReference)hash.get(key);   
		if  (soft_ref  !=   null )  {   
			//  From the SoftReference we get the value, which can be   
			//  null if it was not in the map, or it was removed in   
			//  the processQueue() method defined below    
			result  =  soft_ref.get();   
			if  (result  ==   null )  {   
				//  If the value has been garbage collected, remove the   
				//  entry from the HashMap.    
				hash.remove(key);   
			}   else   {   
				//  We now add this object to the beginning of the hard   
				//  reference queue.  One reference can occur more than   
				//  once, because lookups of the FIFO queue are slow, so   
				//  we don't want to search through it each time to remove   
				//  duplicates.   
				// keep recent use object in memory   
				hardCache.addFirst(result);   
				if  (hardCache.size()  >  HARD_SIZE)  {   
					//  Remove the last entry if list longer than HARD_SIZE    
					hardCache.removeLast();   
				}    
			}    
		}    
		return  result;   
	}    

	/**  We define our own subclass of SoftReference which contains   
    not only the value but also the key to make it easier to find   
    the entry in the HashMap after it's been garbage collected.  */    
	private   static   class  SoftValue  extends  SoftReference  {   
		private   final  Object key;  //  always make data member final    
		/**  Did you know that an outer class can access private data   
      members and methods of an inner class?  I didn't know that!   
      I thought it was only the inner class who could access the   
      outer class's private information.  An outer class can also   
      access private members of an inner class inside its inner   
      class.  */    
		private  SoftValue(Object k, Object key, ReferenceQueue q)  {   
			super (k, q);   
			this .key  =  key;   
		}    
	}    

	/**  Here we go through the ReferenceQueue and remove garbage   
    collected SoftValue objects from the HashMap by looking them   
    up using the SoftValue.key data member.  */    
	public   void  processQueue()  {   
		SoftValue sv;   
		while  ((sv  =  (SoftValue)queue.poll())  !=   null )  {   
			if (sv.get() ==   null ) {  
				//             Log.e( " processQueue " ,  " null " );  
			} else {  
				//             Log.e( " processQueue " ,  " Not null " );  
			}   
			hash.remove(sv.key);  //  we can access private data!   
			//       Log.e( " SoftHashMap " ,  " release  "   +  sv.key);  
		}    
	}    
	/**  Here we put the key, value pair into the HashMap using   
    a SoftValue object.  */    
	public  Object put(Object key, Object value)  {   
		processQueue();  //  throw out garbage collected values first    
		//     Log.e( " SoftHashMap " ,  " put into  "   +  key);  
		return  hash.put(key,  new  SoftValue(value, key, queue));   
	}    
	public  Object remove(Object key)  {   
		processQueue();  //  throw out garbage collected values first    
		return  hash.remove(key);   
	}    
	public   void  clear()  {   
		hardCache.clear();   
		processQueue();  //  throw out garbage collected values    
		hash.clear();   
	}    
	public   int  size()  {   
		processQueue();  //  throw out garbage collected values first    
		return  hash.size();   
	}    
	public  Set entrySet()  {   
		//  no, no, you may NOT do that!!! GRRR    
		throw   new  UnsupportedOperationException();   
	}
	@Override
	public Object getOrDefault(Object key, Object defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void forEach(BiConsumer action) {
		// TODO Auto-generated method stub

	}
	@Override
	public void replaceAll(BiFunction function) {
		// TODO Auto-generated method stub

	}
	@Override
	public Object putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean replace(Object key, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object replace(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object computeIfAbsent(Object key, Function mappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object computeIfPresent(Object key, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object compute(Object key, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object merge(Object key, Object value, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}   
}  
