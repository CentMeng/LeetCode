/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/15
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 整数转罗马数字
 */
public class Solution12IntegerToRoman {

    public static void main(String[] args) {
        //MMCDLXVII
        System.out.println(intToRoman2(2467));
    }

    public static String intToRoman(int num) {

        String[] Q = new String[]{"","M","MM","MMM"};
        String[] B = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] S = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] G = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder result = new StringBuilder();

        result.append(Q[num/1000]);
        num = num%1000;
        result.append(B[num/100]);
        num = num%100;
        result.append(S[num/10]);
        num = num%10;
        result.append(G[num/1]);

        return result.toString();

    }

    /**
     * 贪心算法，每回都按最大的算，然后包含最大的减去，再用最大的去比对
     * 同时列出特殊情况4，40，400，9，90，900情况，这些情况正好是逆序的比如4是IV所以贪心匹配如果没有4则会匹配1会出现4个I
     * 而和6不同贪心匹配5是V后面可以接I，直到9，所以需要再列举出这些情况，其实贪心算法是列举法的改进，都需要列举出来特殊的情况
     *
     * 贪心算法可以用生活中的经验
     * 在以前还使用现金购物的时候，如果我们不想让对方找钱，付款的时候我们会尽量选择面值大的纸币给对方
     * 这样才会使得我们给对方的纸币张数最少，对方点钱的时候也最方便。
     *
     * 所以匹配时候每次都用最大的匹配
     * @param num
     * @return
     */
    public static String intToRoman2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        //进位减少循环
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);

                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }


}
