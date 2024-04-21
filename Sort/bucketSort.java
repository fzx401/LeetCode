/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-09 20:12:16
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-09 21:18:40
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
package Sort;

import java.util.ArrayList;
import java.util.List;

public class bucketSort {
    static List<Integer> sort(List<Integer> list, int bucketSize) {
        Integer minVal = list.get(0);
        Integer maxVal = list.get(0);
        for (Integer i : list) {
            if (i < minVal) {
                minVal = i;
            } else if (i > maxVal) {
                maxVal = i;
            }
        } // 找出数组的最小值和最大值
        Integer bucketNum = (maxVal - minVal) / bucketSize + 1; // 根据桶的大小，确定桶的个数
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketNum); // 创建二维List
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        for (Integer j : list) {
            int index = (j - minVal) / bucketSize;
            buckets.get(index).add(j);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            // 对每个桶内进行快速排序
            List<Integer> curList = bucketSort.fastSort(buckets.get(i));
            // buckets.set(i, curList);
            res.addAll(curList);
        }
        return res;

    }

    static List<Integer> fastSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int len = list.size();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(list.get(len / 2));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (list.get(i) < tmp.get(0)) {
                left.add(list.get(i));
            } else if (list.get(i) > tmp.get(0)) {
                right.add(list.get(i));
            }
        }
        List<Integer> leftRes = fastSort(left);
        List<Integer> rightRes = fastSort(right);
        leftRes.addAll(tmp);
        leftRes.addAll(rightRes);
        return leftRes;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);
        l.add(3);
        for (Integer i : l) {
            System.out.println(i);
        }
        List<Integer> newList = bucketSort.sort(l, 2);
        for (Integer i : newList) {
            System.out.println(i);
        }
    }
}