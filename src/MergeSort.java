import java.util.Random;


public class MergeSort {
	private double[] bridge;
	
	public void sort(double[] obj){
		if(obj == null){
			throw new NullPointerException("The param can not be null!");
		}
		bridge = new double[obj.length];
		mergeSort(obj,0,obj.length-1);
		bridge = null;
	}
	
	private void mergeSort(double[] obj, int left, int right){
		if(left<right){
			int center = (left+right)/2;
			mergeSort(obj,left,center);
			mergeSort(obj,center+1,right);
			merge(obj,left,center,right);
		}
	}
	
	private void merge(double[] obj, int left, int center , int right){
		int mid = center +1;
		int third = left;
		int tmp = left;
		while(left<= center && mid<= right){
			if(obj[left] - obj[mid]<=10e-6){
				bridge[third++] = obj[left++];
			}
			else{
				bridge[third++] = obj[mid++];
			}
		}

		while(mid<= right){
			bridge[third++] = obj[mid++];
		}
		
		while(left<= center){
			bridge[third++] = obj[left++];
		}
		
		copy(obj,tmp,right);
	}
	
	private void copy(double[] obj, int left, int right){
		while(left<= right)
		{
			obj[left] =bridge[left];
			left++;
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random(6);
		
		int arraysize = 10;
		double[] sorted = new double[arraysize];
		System.out.println("Before Sort");
		for(int j=0;j<arraysize;j++){
			sorted[j] = (int)(random.nextDouble()*100);
			System.out.print((int)sorted[j]+" ");
		}
		System.out.println();
		
		MergeSort sorter = new MergeSort();
		sorter.sort(sorted);
		
		System.out.println("After Sort");
		
		for(int j=0;j<sorted.length; j++){
			System.out.print((int)sorted[j]+" ");
		}
		System.out.println();
	}

}
