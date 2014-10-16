import java.util.Random;

public class JavaSort {
	public void straightlnsertionSort(double[] sorted){
		int sortedLen = sorted.length;
		for(int j=2; j<sortedLen;j++){
			if(sorted[j]<sorted[j]-1){
				sorted[0] = sorted[j];
				sorted[j] = sorted[j-1];
				
				int insertPos = 0;
				for(int k= j-2;k>=0;k--){
					if(sorted[k] > sorted[0]){
						sorted[k+1] = sorted[k];
					}
					else{
						insertPos = k+1;
						break;
					}
				}
				sorted[insertPos] = sorted[0];
			}
		}
	}
	
	public void shellInertionSort(double[] sorted, int inc){
		int sortedLen = sorted.length;
		for( int j = inc+1;j<sortedLen;j++){
			if(sorted[j]<sorted[j-inc]){
				sorted[0] = sorted[j];
				
				int insertPos = j;
				 for (int k=j-inc;k>=0;k-=inc)
				 {
					 if(sorted[k]> sorted[0]){
						 sorted[k+inc] = sorted[k];
						 if(k-inc<=0){
							 insertPos = k;
						 }
					 }else{
						 insertPos = k+inc;
						 break;
					 }
				 }
				 sorted[insertPos] = sorted[0];
			}
		}
	}
	
	public void shellInsertionSort(double[] sorted){
		int[] incs = {7,5,3,1};
		int num = incs.length;
		
		int inc =0 ;
		for(int j=0;j<num;j++){
			inc = incs[j];
			shellInertionSort(sorted, inc);
			
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random(6);
		
		int arraysize = 21;
		double[] sorted = new double[arraysize];
		System.out.println("Before Sort");
		for(int j=1; j<arraysize;j++){
			sorted[j] = (int)(random.nextDouble()*100);
			System.out.print((int)sorted[j]+" ");
		}
		System.out.println();
		
		JavaSort sorter = new JavaSort();
		
		sorter.straightlnsertionSort(sorted);
		
		System.out.println("After Sort");
		
		for(int j=1;j<sorted.length;j++){
			System.out.print((int)sorted[j]+" ");
		}
		System.out.println();
		
		
	}
}
