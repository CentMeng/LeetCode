/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/5
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 最长回文子串（回文子串就是正读和反读都一样）
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }


    /**
     * 解题思路，遍历字符串然后设定步长（冒泡思维），再二分比较相对位置值
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        int startIndex = 0;
        int endIndex = 0;
        int currentMax = 0;
        //遍历字符串
        for (int i = 0; i < s.length() && currentMax + i <= s.length(); i++) {
            //步长
            int step = currentMax + i + 1;
            out:
            for (int j = step; j < s.length(); j++) {
                int length = (int) Math.ceil((j - i) / 2.0);
                for (int k = 0; k < length; k++) {
                    if (!s.substring(i + k, i + k + 1).equals(s.substring(j - k, j - k + 1))) {
                        continue out;
                    }
                }
                int diss = endIndex - startIndex;
                if (j - i > diss) {
                    startIndex = i;
                    endIndex = j;
                    //增加步长，要找最长的肯定比这个步长大
                    currentMax = diss > currentMax ? diss : currentMax;
//                        System.out.println("j "+j+"i "+i+"currentMax "+currentMax+"endIndex"+endIndex+"startIndex"+startIndex);
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    /**
     * 解题思路，二分法，从中间开始
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        int startIndex = 0;
        int endIndex = 0;
        int length = s.length();
        int halfLength = (int) Math.ceil(s.length() / 2.0);
        String leftStr = s.substring(0, halfLength);
        String rightStr = s.substring(halfLength, s.length());
        for (int i = halfLength; i >= 0; i--) {

        }
        //遍历字符串
//        for(int i =0 ;i<s.length();i++){
//            System.out.println("First:"+i);
//            //步长
//            for(int j=i+1;j<s.length();j++){
//                System.out.println("Step:"+j);
//                int length = (int) Math.ceil((j-i)/2.0);
//                boolean isResult = true;
//                for(int k=0;k<length;k++){
//                    System.out.println("subString:"+s.substring(i+k,i+k+1)+" "+s.substring(j-k,j-k+1));
//                    if(!s.substring(i+k,i+k+1).equals(s.substring(j-k,j-k+1))){
//                        isResult =false;
//                    }
//                }
//                if(isResult){
//                    if(j-i>endIndex-startIndex){
//                        startIndex = i;
//                        endIndex = j;
//                        System.out.println("startIndex:"+startIndex+"endIndex:"+endIndex);
//                    }
//                }
//            }
//        }
        return s.substring(startIndex, endIndex + 1);
    }
}
