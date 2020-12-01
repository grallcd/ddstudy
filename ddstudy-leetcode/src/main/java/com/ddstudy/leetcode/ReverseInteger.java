package com.ddstudy.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author Grain Rain
 * @date 2020/12/1
 */
public class ReverseInteger {


    /**
     * 要考虑溢出的情况：
     * 1.如果 result * 10 + tmp 溢出，那么result > ( MAX_VALUE-tmp ) / 10 >= MAX_VALUE / 10
     * 2.如果 result > MAX_VALUE / 10 ,则一定会溢出
     * 3.如果 result == MAX_VALUE / 10 ,则 tmp > 7 就会溢出，
     * <p>
     * 7或8是因为最大值2的31次方是2147483648，最小值负2的31次方减一是-2147483647，这两个数值的个位数是7和8.
     * 当result为2147483640时，再加7就会溢出。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tmp < -8)) return 0;
            result = result * 10 + tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(-123);
        System.out.println(result);
    }
}
