package com.jk.ch3;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Administrator
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        System.out.println("输入 : "+JSON.toJSONString(nums));
        System.out.println("res "+JSON.toJSONString(threeSum(nums)));
    }


    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        return  null;
    }


    /**
     * mine  超出时间限制 而且结果错误  o(╥﹏╥)o
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < nums.length; i++) {

            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }

            for (int j = 0; j < nums.length; j++) {
                if(j>i){
                    if(nums[i] == nums[j] ){
                        continue;
                    }
                    int tmp = 0 - nums[i] - nums[j];
                    for (int k = 0; k < nums.length; k++) {
                        if(k>j && tmp == nums[k] && nums[k] != nums[j]){
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }

}
