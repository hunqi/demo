package org.rs.exercise;

public class SortUtils {
    public static void bubbleSort(Integer[] nums) {
        if (nums == null) {
            return;
        }

        Integer min = null;
        for (int i=0; i<nums.length - 1; i++) {
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] > nums[j]) {
                    min = nums[j];
                    nums[j] = nums[i];
                    nums[i] = min;
                }
            }
        }
    }
}
