package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
*  https://leetcode.com/problems/summary-ranges/
*  Given a sorted integer array without duplicates, return the summary of its ranges.
*
*  For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        
        // List we will build to be returned
        ArrayList<String> range = new ArrayList<String>();
        
        
        
        // Temporary range entry
        String temp = "";
        
        // If passed array is empty, return
        if (nums.length == 0)
            return range;
        
        // If passed array has only one element
        // Add it to range and return
        if (nums.length == 1) {
            range.add(Integer.toString(nums[0]));
            return range;
        }
        
        temp = Integer.toString(nums[0]);
        boolean addArrow = false;
        
        for (int i = 1; i < nums.length; ++i) {
            // When our current number isn't consecutive from the previous
            if ((long)nums[i] - (long)nums[i-1] > 1) {
                // When this number is breaking a string of consecutive numbers
                if (addArrow) {
                    temp += "->" + nums[i-1];
                    range.add(temp);
                    temp = Integer.toString(nums[i]);
                    addArrow = false;
                } else {
                    // The previous number has no immediate neighbours
                    range.add(temp);
                    temp = Integer.toString(nums[i]);
                }
                    
                // If we are at the end of the array, add our current number
                if (i == nums.length - 1) range.add(temp);
            } else {
                // Our current number is consecutive from the previous
                addArrow = true;
                
                // If we are at the end of the array, add our number with an arrow
                if (i == nums.length - 1) {
                    temp += "->" + nums[i];
                    range.add(temp);
                }
            }
        }
        return range;
    }
}
