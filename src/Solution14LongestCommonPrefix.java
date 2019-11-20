/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/20
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class Solution14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String commonPrefix = "";
        String first = "";
        if (null != strs && strs.length > 0) {
            first = strs[0];
        }

        out:
        for (int i = 0; i < first.length(); i++) {
            String tempCommonPrefix = first.substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(tempCommonPrefix)) {
                    break out;
                }
            }
            commonPrefix = tempCommonPrefix;
        }

        return commonPrefix;
    }

}
