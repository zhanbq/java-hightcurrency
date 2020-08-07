package com.jikeshijian.ch02.MaxSlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 求滑动窗口最大值
 */
public class MaxSlidingWindow {


    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (num == null)
            return arr;
        if (num.length < size || size <= 0)
            return arr;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] >= num[queue.getLast()]){
                System.out.println("queue.getLast() : "+queue.getLast()+"  ||  num[queue.getLast()] : "+num[queue.getLast()]);
                queue.pollLast();
            }
            while (!queue.isEmpty() && queue.getFirst() < i - (size - 1))
                queue.pollFirst();
            queue.offerLast(i);
            if (i + 1 >= size)
                arr.add(num[queue.getFirst()]);
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] nums = {22, 32, 42, 22, 62, 22, 52, 12};
        ArrayList<Integer> res = MaxSlidingWindow.maxInWindows(nums, 3);
        System.out.printf("res" + res);
    }
}
