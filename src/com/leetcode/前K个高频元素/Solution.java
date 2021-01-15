package com.leetcode.前K个高频元素;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author heibai
 * @date 2021/1/15 10:57
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int num: nums
             ) {
            if (map.containsKey(num)){
                map.replace(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return map.get(num1)-map.get(num2);
            }
        });

        for (int key: map.keySet()
             ) {
            if (pq.size() < k){
                pq.add(key);
            }else {
                if (map.get(key) > map.get(pq.peek())){
                    pq.remove();
                    pq.add(key);
                }
            }
        }
        ArrayList<Integer> ret=new ArrayList<>();
        while (!pq.isEmpty()){
            ret.add(pq.remove());
        }
        int[] res=new int[ret.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ret.get(i);
        }
        return res;
    }
}
