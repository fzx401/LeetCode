/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-07 22:53:45
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-09 21:18:39
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
package Sort;

import java.util.ArrayList;
import java.util.List;

public class bubbleSort {
    static void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(1);
        l.add(3);
        bubbleSort.sort(l);
        for (Integer i : l) {
            System.out.println(i);
        }
    }
}
