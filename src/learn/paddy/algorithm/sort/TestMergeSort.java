package learn.paddy.algorithm.sort;

/**
 * Created by 85014 on 2017/4/25.
 */
import java.util.Random;
import java.util.Random.*;

//归并排序

public class TestMergeSort {
	
	// 递归
	static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
		if (start >= end)
			return;
		int len = end - start, mid = (len >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2)
			result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
		while (start1 <= end1)
			result[k++] = arr[start1++];
		while (start2 <= end2)
			result[k++] = arr[start2++];
		for (k = start; k <= end; k++)
			arr[k] = result[k];
	}
	public static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		merge_sort_recursive(arr, result, 0, len - 1);
	}
	
	public static void main (String[] args) {
		int[] a = new int[10];
		Random random = new Random (10);
		for(int i=0; i<10; i++) {
			a[i] = random.nextInt (100);
		}
		System.out.println ("排序前" );
		for (int each : a) {
			System.out.print (each +  " ");
		}
		System.out.println ("\n排序后");
		merge_sort(a);
		for (int each : a) {
			System.out.print (each + " " );
		}
		
	}
}
