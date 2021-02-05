package com.ddstudy.leetcode;

import java.util.Arrays;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Grain Rain
 * @date 2021/2/5
 */
public class MergeSortedArray {


    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = new int[]{5, 6, 7, 8, 0, 0, 0};
        int m = 4;
        int[] nums2 = new int[]{2, 3, 4};
        int n = 3;

        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 利用双指针从 num1 后往前添加，不用再创建新的数组来存储 num1 的数据
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // num1 中最小的元素要大于 num2 中的元素时，num2 中还会剩下元素没有赋值过去，此时需 copy 数组
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
