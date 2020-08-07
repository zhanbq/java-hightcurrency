package com.graphic.algorithm.ch1;

public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {2,4,6,8,23,45,56,612,773,881,9991,88882};
        int index = BinarySearch.binarySearch(arr, 23);
        System.out.printf("index "+ index);
    }

    /**
     * 二分查找法,作用于 有数数组.
     * 二分查找法接受一个有序数组和一个元素.如果指定的元素包含在数组中,这个函数将返回其位置.
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target){
        int low = 0 ;
        int high = arr.length-1;

        while (low<=high){ //只要范围没有缩小到至包含一个元素
            int mid = (low + high)/2; //其中间索引位置,如果(low+high)不是偶数,结果自动取整.
            int guess = arr[mid];
            if(guess == target) {
                return mid;
            }
            if(guess > target){
                high = mid - 1;
            }
            if(guess < target){
                low = mid + 1;
            }
        }
        return -1;
    }
}
