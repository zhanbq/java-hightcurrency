package com.jikeshijian.ch02.townums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 两数之和
 */
public class TowNnumbers {

    public static int[] sum(int[] nums, int sum){

        int[] res = new int[2];

        HashMap<Integer,Integer> coutMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(coutMap.containsKey(sum-nums[i])){
                res[0] = coutMap.get(sum-nums[i]);
                res[0] = i;
            }else {
                coutMap.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int sum = 9;
        int[] res = TowNnumbers.sum(nums, sum);

        System.out.println();
    }
}
