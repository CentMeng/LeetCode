/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/14
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class Solution11 {

    public static void main(String[] args){
        System.out.println(maxArea2(new int[]{1,2,3,4,5,6,7,8,9,10,11}));
    }

    /**
     * 就是长宽算面积
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int temp = Math.min(height[i],height[j])*Math.abs(j-i);
                if(temp > maxArea){
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }

    /**
     * 双指针思路，就是一首一尾指针，根据两个谁小不断向中间靠拢，直到重合
     * 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }

}
