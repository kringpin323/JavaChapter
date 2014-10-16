
public class quickSort {
	int a[] = {45,34,56,67,78,3,12,56,76,789,898,967,6};
	
	public quickSort(){
		quick(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public int getMiddle(int[] list, int low, int high){
		int tmp = list[low];
		while(low < high){
			while(low<high && list[high]>= tmp){
				high--;
			}
			list[low] = list[high];
			while(low<high &&list[low]<=tmp){
				low++;
			}
			list[high] = list[low];
		}
		list[low] = tmp;
		return low;
	}
	
	public void _quickSort(int[] list, int low, int high){
		if(low < high){
			int middle = getMiddle(list,low, high);
			_quickSort(list,low,middle-1);
			// 需要使用 尾递归优化
			_quickSort(list, middle+1,high);
		}
	}
	
	public void quick(int[] a2){
		if(a2.length >0){
			_quickSort(a2,0,a2.length-1);
		}
	}
	
	public static void main(String[] args) {
		new quickSort();
	}
}
