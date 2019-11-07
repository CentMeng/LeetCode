import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/6
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc Z 字形变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution6 {

    public static void main(String[] args){
        System.out.println(convert("LeetCodeIoveYou",4));
    }

    /**
     * 创建min(rows,s.length)个数组来代表每行存储字符串，然后再遍历s，向前行进，
     * 如果到达最后一行，则放到上一行，如果到达最顶行则向下行进
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goDown = true;
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == rows.size() - 1) {
                goDown = false;
            } else if (0 == currentRow) {
                goDown = true;
            }
            if (goDown) {
                currentRow++;
            }else{
                currentRow--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();

    }
}
