import java.util.Arrays;


public class HeapSort {
	int a[] = {45,34,56,67,78,3,12,56,76,789,898,967,6};
	
	public static void main(String[] args) {
		new HeapSort();
	}
	
	public HeapSort(){
		heapSort(a);
	}
	
	public void heapSort(int[] a){
		System.out.println("¿ªÊ¼ÅÅÐò");
		int arrayLength = a.length;
		
		for(int i=0;i<arrayLength-1;i++){
			buildMaxHeap(a,arrayLength-1-i);
			
			swap(a,0,arrayLength-1-i);
			System.out.println(Arrays.toString(a));
		}
	}
	
	private void swap(int[] data,int i , int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	private void buildMaxHeap(int[] data,int lastIndex){
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k =i ;
			while(k*2+1<=lastIndex){
				int biggerIndex = 2*k +1;
				if(biggerIndex <lastIndex){
					if(data[biggerIndex]<data[biggerIndex+1]){
						biggerIndex++;
					}
				}
				if(data[k]<data[biggerIndex]){
					swap(data,k,biggerIndex);
					k= biggerIndex;
				}
				else{
					break;
				}
			}
		}
	}
}
