package org.rs.exercise.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rs.exercise.SortUtils;

public class SortUtilsTest {

    @DisplayName("若数组为null, 返回原数组")
    @Test
    public void testBubbleSort_shouldReturnTheOriginalArray_ifArrayIsNull(){
        Integer[] nums = null;
        SortUtils.bubbleSort(nums);
        Assertions.assertNull(nums);
    }

    @DisplayName("若数组为空, 返回原数组")
    @Test
    public void testBubbleSort_shouldReturnTheOriginalArray_ifArrayIsEmpty(){
        Integer[] nums = new Integer[0];
        SortUtils.bubbleSort(nums);
        Assertions.assertTrue(nums.length == 0);
    }

    @DisplayName("若数组仅含一个元素, 返回原数组")
    @Test
    public void testBubbleSort_shouldReturnTheOriginalArray_ifArrayHasOnlyElement(){
        Integer[] nums = new Integer[]{2};
        SortUtils.bubbleSort(nums);
        Assertions.assertTrue(nums.length == 1);
        Assertions.assertTrue(2 == nums[0]);
    }

    @DisplayName("应该按照升序排序")
    @Test
    public void testBubbleSort_shouldReturnAscOrderedList(){
        Integer[] nums = {9, 2, 6, 8, 1, 13};
        SortUtils.bubbleSort(nums);
        Assertions.assertSame(1, nums[0]);
        Assertions.assertSame(13, nums[nums.length - 1]);
        Assertions.assertSame(2, nums[1]);
    }

}
