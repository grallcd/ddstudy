package com.ddstudy.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author Grain Rain
 * @date 2020/12/2
 */
public class PalindromeNumber {

    /**
     * 先将原数进行反转，再将反转后的数字和原整数进行对比
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int init = x;
        int result = 0;

        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;
            result = result * 10 + tmp;

        }
        return result == init;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int num = 7;
        boolean flag = palindromeNumber.isPalindrome(num);
        System.out.println(flag);
    }
}
