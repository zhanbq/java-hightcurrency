package com.jk.ch3;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {1,0,3,4,5,0,1,0};
        moveZeros1(nums);
        moveZeros2(nums);

    }


    /**
     * 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
     * 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
     * 这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
     *
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     */
    public static void moveZeros1(int[] nums){

        //零的位置标记
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i]!=0){

                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j]=tmp;
                j++;
            }

        }
        System.out.println("moveZeros1 result "+JSON.toJSONString(nums));
    }

    private static void moveZeros2(int[] nums) {
        //零的位置标记
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i]!=0){
                if(i>j){
                    /*
                    当i=j时没有必要交换,如果全是零或全是非零的数组 也都没有必要交换
                    那么i最终一定比j快
                    当i>j时,只需要把 i 的值赋值给j 并把原位置的值置0。同时这里也把交换
                    操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
                     */
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }

        }
        System.out.println("moveZeros2 result "+JSON.toJSONString(nums));


    }
}
