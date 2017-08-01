package leetcode;

import java.util.Arrays;

public class MaximumAverageSubarrayI {
	
	public static void main(String[] args) {
		int a[] = {7,4,5,8,8,3,9,8,7,6};
		System.out.println(findMaxAverage(a, 7));
	}
	public static double findMaxAverage(int[] nums, int k) {
		int len = nums.length;
		if (nums == null || len == 0) return 0;
        if (len == 1) return nums[0];
		if (k > len) {
			return findMaxAverage(nums, len);
		}
        double sum = 0;
		for (int i = 0; i < k; i++){
            sum += nums[i];
        }
		double maxAvg = sum / k;
		for (int i = 1,j = k; i <= len - k; i++, j++) {
			sum -= nums[i-1];
			sum += nums[j];
			double avg = sum / k;
			if (avg > maxAvg) maxAvg = avg;
		}
		return maxAvg;
    }
	
	

}
