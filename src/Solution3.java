import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/5
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 3.无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution3 {

    public static void main(String[] args){
        lengthOfLongestSubstring("tmmeddpt");
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>start){
                max = Math.max(max,i-start);
                start = map.get(s.charAt(i));
            }else {
                if(i == s.length()-1){
                    max = i-start+1>max ? i-start+1:max;
                }
            }
            map.put(s.charAt(i),i+1);
        }
        return max;
    }
}
