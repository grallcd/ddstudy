package com.ddstudy.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Grain Rain
 * @date 2020/12/4
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"hello", "hel", "haha"};
        String prefix = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(prefix);

        String prefix2 = longestCommonPrefix.longestCommonPrefix2(strs);
        System.out.println(prefix2);
    }

    /**
     * 横向扫描法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int count = strs.length;
        String first = strs[0];
        for (int i = 1; i < count; i++) {
            first = commonPrefix(first, strs[i]);
            if (first.length() == 0) {
                break;
            }
        }
        return first;
    }

    public String commonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 分治法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix2(strs, 0, strs.length - 1);
        }

    }

    public String longestCommonPrefix2(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int medium = (end - start) / 2 + start;
        String leftPrefix = longestCommonPrefix2(strs, start, medium);
        String rightPrefix = longestCommonPrefix2(strs, medium + 1, end);
        return commonPrefix(leftPrefix, rightPrefix);
    }

}
