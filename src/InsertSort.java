import java.util.Arrays;


public class InsertSort {
	public static void main(String[] args)
	{
		int[] arr= new int[]{800,9,3,6,12,54,35,411,3,245,1,0,4};
		InsertSort.InsertSort(arr);
	}
	public static int[] InsertSort(int[] arr)
	{
		int i,j;
		int insertNote;//Ҫ���������
		int[] array=arr;

		//������ĵڶ���Ԫ�ؿ�ʼѭ���������е�Ԫ�ز���
		for (i=1;i<array.length;i++)
		{
			//���������еĵ�2��Ԫ��Ϊ��һ��ѭ��Ҫ����������
			insertNote = array[i];
			j=i-1;
			while(j>=0&&insertNote<array[j])   
			{
				//���Ҫ������Ԫ��С�ڵ�j��Ԫ��,�ͽ���j��Ԫ������ƶ�
				array[j+1]=array[j];
				j--;
			}
			//ֱ��Ҫ�����Ԫ�ز�С�ڵ�j��Ԫ��,��insertNote���뵽������
			array[j+1]=insertNote; 
		}
		//��ӡ����������
		System.out.println(Arrays.toString(array));
		return array;
	}
}
