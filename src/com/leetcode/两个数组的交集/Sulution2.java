package com.leetcode.两个数组的交集;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 返回重复的元素
 * @author heibai
 * @date 2021/1/13 22:32
 */
public class Sulution2 {
    public int[] intersect(int[] num1,int[] num2){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num: num1
        ) {
            //如果map里包含num值
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else {
                map.put(num,1);
            }
        }

        ArrayList<Integer> list=new ArrayList<>();

        for (int num: num2
        ) {
            if ( map.containsKey(num) && map.get(num) != 0){
                list.add(num);
                map.replace(num,map.get(num)-1);
            }
        }
        int[] ret=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
