package learn.paddy.soft;

/**
 * Created by 85014 on 2017/7/12.
 */
public class FastSortDemo {
	
	public static void swap(int[] arr, int pos_a, int pos_b){
		int tmp = arr[pos_a];
		arr[pos_a] = arr[pos_b];
		arr[pos_b] = tmp;
	}
	
	public static void fastSort(int[] nums, int start_pos, int end_pos){
		if (start_pos>=end_pos){
			return ;
		}
		
		int start = start_pos;
		int end = end_pos;
		int key = nums[start];
		
		while (start<end){
			while (start<end&&nums[end]>=key)   // 往后数
				end--;
			if (nums[end]<=key)
				swap (nums, start, end);
			while (start<end&&nums[start]<=key){    //往前数
				start++;
			if (nums[start]>=key)
				swap (nums, start, end);
			}
		}
		
		fastSort (nums, start_pos, start-1);
		fastSort (nums, end+1, end_pos);
	}
	
	public static void main (String[] args) {
		int[] a = {2,3,1,11,4,6,8};
		fastSort (a, 0, 6);
		for(int i:a){
			System.out.println (i );
		}
	}

}
