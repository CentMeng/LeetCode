import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/5
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Solution1 {

    /**
     * 此题最开始用暴力法+冒泡排序的方式，后来看讲解，知道了可以借助map来提升
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int dis = target - nums[i];
            if(map.containsKey(dis)){
                return new int[]{map.get(dis),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSumFirst(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
