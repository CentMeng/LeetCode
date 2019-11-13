/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/13
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 正则匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class Solution10 {

    public static void main(String[] args) {
        System.out.println(isMatch3("aab", "c*a*b"));
    }

    /**
     * 此种方法无法处理'*' 匹配零个
     *
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        if (pattern.startsWith("*")) {
            return false;
        }

        char[] textc = text.toCharArray();
        char[] patternc_temp = pattern.toCharArray();
        StringBuilder stringTemp = new StringBuilder();

        char currentTempPattern = '*';
        //缩减匹配
        for (int i = 0; i < patternc_temp.length; i++) {
            if ('*' == patternc_temp[i]) {
                if ('*' == stringTemp.charAt(stringTemp.length() - 1)) {
                    continue;
                } else {
                    currentTempPattern = patternc_temp[i - 1];
                }
            } else if (currentTempPattern == patternc_temp[i]) {
                continue;
            } else {
                currentTempPattern = '*';
            }
            stringTemp.append(patternc_temp[i]);
        }

        char[] patternc = stringTemp.toString().toCharArray();


        //遇到.或者字母都可以前进一位
        int step = 0;
        int stop = 0;
        String currentPattern = "*";
        for (int i = 0; i < textc.length; i++) {
            if (patternc[step] == textc[i] || patternc[step] == '.') {
                //匹配成功匹配下一个
                step++;
            } else if (stop == 0 && step != 0 && (textc[i] == patternc[step - 1] || '.' == patternc[step - 1])) {
                currentPattern = String.valueOf(textc[i - 1]);
                stop++;
            } else if (patternc[step] == '*' && textc[i] == currentPattern.toLowerCase().charAt(0)) {
                currentPattern = String.valueOf(textc[i - 1]);
                stop++;
            } else if (step + 1 < patternc.length && patternc[step + 1] == textc[i]) {
                //用下一个字符匹配成功匹配下一个
                step++;
            } else {
                return false;
            }
            if (step >= patternc.length) {
                return false;
            }
        }

        return true;
    }

    /**
     * 递归回溯,不断截取递归判定
     * aab
     * a*b
     *
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatch3(String text, String pattern) {
        //递归回溯结束点
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        //如果pattern长度大于2并且第二位是*，这一步isMatch3(text, pattern.substring(2)可以判定用到*匹配零个前字符isMatch3(text, pattern.substring(2)
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //这个匹配判定用到*匹配零个前字符
            return (isMatch3(text, pattern.substring(2)) ||
                    //这个匹配判定*代表n个字符
                    (first_match && isMatch3(text.substring(1), pattern)));
        } else {
            //判定第二位不是*的情况都移位判定，每回递归只判断第一位，直到空
            return first_match && isMatch3(text.substring(1), pattern.substring(1));
        }
    }


    /**
     * 因为题目拥有 最优子结构 ，一个自然的想法是将中间结果保存起来。我们通过用 \text{dp(i,j)}dp(i,j) 表示 \text{text[i:]}text[i:] 和 \text{pattern[j:]}pattern[j:] 是否能匹配。我们可以用更短的字符串匹配问题来表示原本的问题。
     * <p>
     * 算法
     * <p>
     * 我们用 [方法 1] 中同样的回溯方法，除此之外，因为函数 match(text[i:], pattern[j:]) 只会被调用一次，我们用 \text{dp(i, j)}dp(i, j) 来应对剩余相同参数的函数调用，这帮助我们节省了字符串建立操作所需要的时间，也让我们可以将中间结果进行保存。
     *
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatch2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
