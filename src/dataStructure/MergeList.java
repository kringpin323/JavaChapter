package dataStructure;

public class MergeList {
	// 递归实现
	// 从语义上理解递归，把，Node a b 放进来，就返回一个C，这个C能将a,b有序合并还给你。
	static Node SortedMerge(Node a , Node b){
		Node result = null;
		
		// 对于递归，下面的是假设正确的情况
		// 这个总结条件最难定义
		// 因为在没有了的情况下，只能返回另外一个，而且另外一个也已经有序
		// 前面的序列怎么样不是这个部分处理的，这个部分只处理结束情况
		// 前面部分的处理情况，在下面的顺序中解决了，递归也是由于这个解决，递归的语义
		// 更像是逻辑推理，数学归纳法
		// 递归终结条件，其中一个结束了，返回另一个？
		if(a == null)
			return b;
		else if(b==null)
			return a;
		
		if(a.data <= b.data){ // 顺序
			result =a;
			// 精彩的递归应用，result的下一个是有序的 a后面的和b的并表
			result.next = SortedMerge(a.next,b);
		}
		else{
			result =b;
			result.next = SortedMerge(a,b.next);
		}
		return result;
	}
	
	// 纯Java有序链表实现，循环实现
	public static Node Merger(Node ln1, Node ln2){
		// 两哨兵
		Node cp1 = ln1; 
		Node cp2= ln2;
		
		// 字面上看，是 head 与 current
		Node head = null;
		Node current = null;
		
		while(cp1!=null && cp2!=null){ // 结束条件果然还是如此
			if(cp1.data <= cp2.data){ // 顺序
				if(head == null){
					// 大概是，初始化的时候，head和current都是 cp1
					head = cp1;  // 只会运行一次
					current = cp1;
				}else{
					// 不是初始化状态，
					current.next = cp1;
					current = cp1;
				}
				// cp1 进入下一个
				cp1 = cp1.next;
			}else{ // 这里说明 cp2 比较小
				if(head == null){
					head = cp2;
					current = cp2;
				}else{
					// 非初始化状态将 current 指向 cp2
					current.next = cp2;
					current = cp2;
				}
				// cp2 进入下一个
				cp2 = cp2.next;
			}
		}
		if(cp1!=null && cp2 == null)//最后果然是这样么，cp1 还有  后续链表
		{
			current.next = cp1;
		}
		else if(cp1==null && cp2!=null){// cp2还有后续链表
			current.next = cp2;
		}
		
		// 综上，总结四个 游标的作用
		// head ， current 返回的链表的两游标，处理合成的链表
		// cp1, cp2 ,原来的两链表，可以理解为分离的两链表
		return head;
	}
	
	static class Node{
		int data;
		Node next=null;
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		Node n6 = new Node(6,null);
		Node n4 = new Node(4,n6);
		Node n2 = new Node(2,n4);
		// 现在应该是 n2 -> n4 -> n6
		
		Node n5 = new Node(5,null);
		Node n3 = new Node(3,n5);
		Node n1 = new Node(1,n3);
		// 第二条是 n1-> n3-> n5
		
		Output(n1);
		Output(n2);
//		Output(SortedMerge(n1,n2));
		Output(Merger(n1,n2)); // 牛逼，非递归写法
	}
	
	public static void Output(Node temp0){
		Node temp = temp0;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
	}
}

