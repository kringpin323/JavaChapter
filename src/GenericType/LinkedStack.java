package GenericType;

// Java 编程思想中实现的 链栈
// 这个实现非常精彩，而且使用了泛型
public class LinkedStack<T> {
	private static class Node<U>{
		U item;
		Node<U> next;
		Node() {item = null;next= null;}
		Node(U item, Node<U> next){
			this.item = item;
			this.next = next;
		}
		boolean end(){return item == null && next == null;}
	}
	
	private Node<T> top = new Node<T>();
	public void push(T item){
		// 末梢哨兵，但是不考虑并发状态下的编译器重排序么？有点疑问
		top = new Node<T>(item, top);
	}
	public T pop(){
		T result = top.item;
		if(!top.end())
			top = top.next;
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss= new LinkedStack<String>();
		for(String s: "perhap I love you".split(" "))
			lss.push(s);
		String s;
		while((s = lss.pop())!=null)
			System.out.println(s);
	}
} 
