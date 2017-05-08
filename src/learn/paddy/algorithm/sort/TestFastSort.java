package learn.paddy.algorithm.sort;


/**
 * Created by 85014 on 2017/4/24.
 */
import java.util.Random;
// 快速排序


public class TestFastSort {
	
	public static void main (String[] args) {
		Random random = new Random (100);
		int[] nums = new int[10];
		for(int i=0; i<10; i++) {
			nums[i] = random.nextInt (100);
		}
		System.out.println ("排序前" );
		for (int i : nums) {
			System.out.print (i + " " );
		}
		
		fast_sort (nums, 0, nums.length - 1);
		
		System.out.println ("\n排序后" );
		for (int i : nums) {
			System.out.print (i + " " );
		}
	}
	
	static void fast_sort (int[] target, int left, int right) {
		if (left < right)
		{
			int i = left, j = right, x = target[left];
			while (i < j)
			{
				while(i < j && target[j] >= x) // 从右向左找第一个小于x的数
					j--;
				if(i < j)
					target[i++] = target[j];
				while(i < j && target[i] < x) // 从左向右找第一个大于等于x的数
					i++;
				if(i < j)
					target[j--] = target[i];
			}
			target[i] = x;
			fast_sort (target, left, i - 1); // 递归调用
			fast_sort (target, i + 1, right);
		}
		
	}
	
}

