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
        if (x < 0 || (x % 10 == 0 && x != 0)) {
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

    /**
     * 将原数的后半部分进行反转，如果和前半部分相等，则是回文数
     * 当前半部分小于等于反转后的数字时，则表示反转的位数已经到达一半了
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x = x / 10;
        }

        // 当数字长度为奇数时，只需将 revertNum / 10 即可
        return x == revertNum || x == revertNum / 10;
    }


    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int num = 0;
        boolean flag = palindromeNumber.isPalindrome(num);
        System.out.println(flag);
    }
}
