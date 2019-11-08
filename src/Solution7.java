/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/7
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class Solution7 {

    public static void main(String[] args) {
        System.out.println("result:" + reverse(-1234));
    }

    /**
     * 利用取余取末位,之前代码是用取末位，放stringbuilder里
     * @param x
     * @return
     */
    public static int reverse(int x) {

        long temp = 0;

        while (x != 0) {
            int t = x %10;
            temp = temp*10+t;
            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
        return (int) temp;
    }
}
