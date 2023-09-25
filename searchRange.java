// Problem Statment: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
// Time Complexity: O(log n)
// Approach: Run binary search twice to find first and last position of the element respectively

class Solution {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
  
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccuranceOfElement(nums, target);
        result[1] = findLastOccuranceOfElement(nums, target);
        return result;
    }

    static int findFirstOccuranceOfElement(int[] nums, int target) {
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
                end = med-1;
            }
        }
        return index;
    }

    static int findLastOccuranceOfElement(int[] nums, int target) {
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
                start = med+1;
            }
        }
        return index;
    }

}
