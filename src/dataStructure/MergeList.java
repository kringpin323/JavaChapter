package dataStructure;

public class MergeList {
	// �ݹ�ʵ��
	// �����������ݹ飬�ѣ�Node a b �Ž������ͷ���һ��C�����C�ܽ�a,b����ϲ������㡣
	static Node SortedMerge(Node a , Node b){
		Node result = null;
		
		// ���ڵݹ飬������Ǽ�����ȷ�����
		// ����ܽ��������Ѷ���
		// ��Ϊ��û���˵�����£�ֻ�ܷ�������һ������������һ��Ҳ�Ѿ�����
		// ǰ���������ô������������ִ���ģ��������ֻ����������
		// ǰ�沿�ֵĴ���������������˳���н���ˣ��ݹ�Ҳ���������������ݹ������
		// �������߼�������ѧ���ɷ�
		// �ݹ��ս�����������һ�������ˣ�������һ����
		if(a == null)
			return b;
		else if(b==null)
			return a;
		
		if(a.data <= b.data){ // ˳��
			result =a;
			// ���ʵĵݹ�Ӧ�ã�result����һ��������� a����ĺ�b�Ĳ���
			result.next = SortedMerge(a.next,b);
		}
		else{
			result =b;
			result.next = SortedMerge(a,b.next);
		}
		return result;
	}
	
	// ��Java��������ʵ�֣�ѭ��ʵ��
	public static Node Merger(Node ln1, Node ln2){
		// ���ڱ�
		Node cp1 = ln1; 
		Node cp2= ln2;
		
		// �����Ͽ����� head �� current
		Node head = null;
		Node current = null;
		
		while(cp1!=null && cp2!=null){ // ����������Ȼ�������
			if(cp1.data <= cp2.data){ // ˳��
				if(head == null){
					// ����ǣ���ʼ����ʱ��head��current���� cp1
					head = cp1;  // ֻ������һ��
					current = cp1;
				}else{
					// ���ǳ�ʼ��״̬��
					current.next = cp1;
					current = cp1;
				}
				// cp1 ������һ��
				cp1 = cp1.next;
			}else{ // ����˵�� cp2 �Ƚ�С
				if(head == null){
					head = cp2;
					current = cp2;
				}else{
					// �ǳ�ʼ��״̬�� current ָ�� cp2
					current.next = cp2;
					current = cp2;
				}
				// cp2 ������һ��
				cp2 = cp2.next;
			}
		}
		if(cp1!=null && cp2 == null)//����Ȼ������ô��cp1 ����  ��������
		{
			current.next = cp1;
		}
		else if(cp1==null && cp2!=null){// cp2���к�������
			current.next = cp2;
		}
		
		// ���ϣ��ܽ��ĸ� �α������
		// head �� current ���ص���������α꣬����ϳɵ�����
		// cp1, cp2 ,ԭ�����������������Ϊ�����������
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
		// ����Ӧ���� n2 -> n4 -> n6
		
		Node n5 = new Node(5,null);
		Node n3 = new Node(3,n5);
		Node n1 = new Node(1,n3);
		// �ڶ����� n1-> n3-> n5
		
		Output(n1);
		Output(n2);
//		Output(SortedMerge(n1,n2));
		Output(Merger(n1,n2)); // ţ�ƣ��ǵݹ�д��
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

