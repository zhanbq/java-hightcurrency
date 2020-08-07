package com.jikeshijian.ch02.MyPriortyQueue;

import java.util.PriorityQueue;

public class KthLargest {

    /**
     * 优先队列 最小堆==>维护前k个最大数,
     *    根节点 是前k个最大数中的值最小的数
     */
    private final PriorityQueue<Integer> q;

    private final int k; //阈值 用来维护前k个最大数
    public KthLargest(int k, int[] a) {
        this.q = new PriorityQueue<>(k);
        this.k = k;
        for (int n : a){
            add(n);
        }
    }

    private int add(int n) {
        if(q.size() < k){
            //队列未满,加入优先队列,内部排序
            q.offer(n);
        }else if (q.peek() < n){
            //队列满,取最小元素比较,因为q维护的是前 k个最大的数,
            // 所以,如果q中最小元素比n小,则去掉原最小元素,加入新的新元素
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
