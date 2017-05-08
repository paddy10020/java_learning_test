package learn.paddy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 85014 on 2017/4/25.
 */

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the
// array which gives the sum of zero.


public class ThreeSum {
	
	public static void main (String[] args) {
//		int[] test = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		int[] test = new int[]{0, 0, 0, 0};
		List<List<Integer>> result = solution (test);
		System.out.println (result );
	}
	
	public static List<List<Integer>> solution (int[] nums) {
		List<List<Integer>> result = new ArrayList<> ( );
		if (nums.length < 3) {
			return result;
		}
		Arrays.sort ( nums );
		int len = nums.length;
		for(int i=0;i < len - 2; i++){
			if (i > 0 && nums[i] == nums[i-1])
				continue;
			if (nums[i] > 0)
				break;
			int j = i+1, k = len - 1;
			while (j < k){
				if (j>i+1 && nums[j]==nums[j-1]) {
					j++;
					continue;
				}
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> tmp = new ArrayList<> ( );
					tmp.add (nums[i]);
					tmp.add (nums[j]);
					tmp.add (nums[k]);
					result.add (tmp);
					j++;
					k--;
				}
				else if (sum > 0)
					k--;
				else if (sum < 0)
					j++;
			}
		}
		return result;
	}
	
}
