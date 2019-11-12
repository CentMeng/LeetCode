/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/12
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class Solution9 {

    public static void main(String[] args){
        System.out.println(isPalindrome(10));
    }

    /**
     * 利用与回文数相差等于0思路
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        int temp = x;
        int palind = 0;
        if(x < 0){
            return false;
        }
        while(temp != 0){
            int p = temp%10;
            palind = palind*10+p;
            temp = temp /10;
        }

        if(x-palind == 0){
            return true;
        }else{
            return false;
        }
    }
}
