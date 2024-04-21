/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-04 23:04:06
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-06 10:09:51
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
/*
 * @lc app=leetcode.cn id=2869 lang=java
 *
 * [2869] 收集元素的最少操作次数
 *
 * https://leetcode.cn/problems/minimum-operations-to-collect-elements/description/
 *
 * algorithms
 * Easy (71.18%)
 * Likes:    5
 * Dislikes: 0
 * Total Accepted:    4.5K
 * Total Submissions: 6.3K
 * Testcase Example:  '[3,1,5,4,2]\n2'
 *
 * 给你一个正整数数组 nums 和一个整数 k 。
 * 
 * 一次操作中，你可以将数组的最后一个元素删除，将该元素添加到一个集合中。
 * 
 * 请你返回收集元素 1, 2, ..., k 需要的 最少操作次数 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,1,5,4,2], k = 2
 * 输出：4
 * 解释：4 次操作后，集合中的元素依次添加了 2 ，4 ，5 和 1 。此时集合中包含元素 1 和 2 ，所以答案为 4 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,1,5,4,2], k = 5
 * 输出：5
 * 解释：5 次操作后，集合中的元素依次添加了 2 ，4 ，5 ，1 和 3 。此时集合中包含元素 1 到 5 ，所以答案为 5 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [3,2,5,3,1], k = 3
 * 输出：4
 * 解释：4 次操作后，集合中的元素依次添加了 1 ，3 ，5 和 2 。此时集合中包含元素 1 到 3  ，所以答案为 4 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= nums.length
 * 1 <= k <= nums.length
 * 输入保证你可以收集到元素 1, 2, ..., k 。
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<>(); // 使用HashSet记录在[1,2,...,k]中尚未收集到的元素
        for (int i = 0; i < k; i++) {
            set.add(i + 1);
        }
        Stack<Integer> numsStack = new Stack<>();
        numsStack.addAll(nums);
        int cnt = 0;
        while (set.size() > 0) {
            Integer removed = numsStack.removeLast();
            cnt++;
            if (set.contains(removed)) {
                set.remove(removed);
            }

        }
        return cnt;
    }
}
// @lc code=end
