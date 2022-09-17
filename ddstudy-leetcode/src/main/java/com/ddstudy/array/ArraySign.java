package com.ddstudy.array;

/**
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * 示例 2：
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * <p>
 * 示例 3：
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sign-of-the-product-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author grallcd
 * @since 2022/9/17
 */
public class ArraySign {


    public int arraySign(int[] nums) {
        int lessThanZero = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                lessThanZero++;
            }
        }
        return lessThanZero == 0 ? 1 : (lessThanZero % 2 == 0 ? 1 : -1);
    }

    public static void main(String[] args) {
        ArraySign solution = new ArraySign();
        int[] nums1 = new int[]{-1, -2, -3, -4, 3, 2, 1};
        assert solution.arraySign(nums1) == 1;

        int[] nums2 = new int[]{1, 5, 0, 2, -3};
        assert solution.arraySign(nums2) == 0;

        int[] nums3 = new int[]{-1, 1, -1, 1, -1};
        assert solution.arraySign(nums3) == -1;
    }
}
