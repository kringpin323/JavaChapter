
public class bubbleSort {
	public bubbleSort(){
		int a[] = {45,34,56,67,78,3,12,56,76,789,898,967,6};
		int temp =0 ;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					temp= a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new bubbleSort();
	}
}
