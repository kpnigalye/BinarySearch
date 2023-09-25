// Problem Statment: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
// Time Complexity: O(log n)
// Approach: Run binary search twice to find first and last position of the element respectively

package Tutorial;

import java.util.Arrays;

public class BSFirstAndLastOccurance {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findOccuranceOfElement(nums, target, true);
        result[1] = findOccuranceOfElement(nums, target, false);
        return result;
    }

    static int findOccuranceOfElement(int[] nums, int target, boolean findFirstIndex) {
        int start = 0, end= nums.length-1;
        int index = -1;

        while (start <= end) {
            int med = start + (end-start)/2;

            if(target < nums[med]) {
                end = med-1;
            } else if (target > nums[med]) {
                start = med+1;
            } else {
                index = med;
                if(findFirstIndex)
                    end = med-1;
                else
                    start = med+1;
            }
        }
        return index;
    }
}
