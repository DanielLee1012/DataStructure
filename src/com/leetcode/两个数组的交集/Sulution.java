package com.leetcode.两个数组的交集;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 两个数组的交集,返回不重复的元素
 * @author heibai
 * @date 2021/1/13 22:25
 */
public class Sulution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int num: nums1
             ) {
            set.add(num);
        }
        List<Integer> list= new ArrayList<>();

        for (int num: nums2
             ) {
            if (set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] ret=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
