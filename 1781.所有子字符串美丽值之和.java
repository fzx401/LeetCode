
/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-03 22:38:41
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-06 11:06:56
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
/*
 * @lc app=leetcode.cn id=1781 lang=java
 *
 * [1781] 所有子字符串美丽值之和
 */

// @lc code=start
import java.util.HashMap;
import java.util.Collection;

class Solution {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) { // 遍历字符串中的字符，分别将其作为起始字符
            HashMap<Character, Integer> set = new HashMap<>();
            int maxFreq = 0;
            int minFreq = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                set.put(c, set.getOrDefault(c, 0) + 1);
                Collection<Integer> cur = set.values();
                Integer[] curlist = cur.toArray(new Integer[0]);
                maxFreq = max(curlist);
                minFreq = min(curlist);
                res += (maxFreq - minFreq);
            }
        }
        return res;
    }

    public static int max(Integer[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(max) > 0) {
                max = a[i];
            }
        }
        return max;
    }

    public static int min(Integer[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(min) < 0) {
                min = a[i];
            }
        }
        return min;
    }
}

// @lc code=end
