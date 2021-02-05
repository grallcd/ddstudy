package com.ddstudy.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Grain Rain
 * @date 2021/2/5
 */
public class ValidPalindrome {

    public static void main(String[] args) {

        ValidPalindrome solution = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean result = solution.isPalindrome(s);
        System.out.println(result);

    }

    /**
     * 双指针首尾移动判断字符是否相等
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        char[] chars = s.toLowerCase().toCharArray();
        int length = chars.length;
        if (length == 0) {
            return true;
        }

        int left = 0;
        int right = length - 1;

        while (left < right) {
            if (isNotDigitOrChar(chars[left])) {
                left++;
                continue;
            }
            if (isNotDigitOrChar(chars[right])) {
                right--;
                continue;
            }

            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * 判断字符是否是数字 or 字母
     * 数字ASCII 48-57 字母：65-90 97-122
     *
     * @param c
     * @return
     */
    public boolean isNotDigitOrChar(char c) {
        return (c < '0' || c > '9') && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z');
    }
}
