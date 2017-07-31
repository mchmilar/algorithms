package leetcode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{-1,0,0,0,0,3,3}));

	}
	public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 1;
        for (int finder = 1; finder < nums.length; finder++) {
            if (nums[i] > nums[i-1])
                i++;
            else if (nums[finder] > nums[i] && nums[finder] > nums[i-1]) {
                nums[i] = nums[finder];
                i++;
            }
        }
        return i;
    }
}
