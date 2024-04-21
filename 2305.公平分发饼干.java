/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-14 22:43:47
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-15 22:39:35
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
/*
 * @lc app=leetcode.cn id=2305 lang=java
 *
 * [2305] 公平分发饼干
 *
 * https://leetcode.cn/problems/fair-distribution-of-cookies/description/
 *
 * algorithms
 * Medium (73.04%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    14.9K
 * Total Submissions: 20.3K
 * Testcase Example:  '[8,15,10,20,8]\n2'
 *
 * 给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k
 * 表示等待分发零食包的孩子数量，所有 零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。
 * 
 * 分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。
 * 
 * 返回所有分发的最小不公平程度。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：cookies = [8,15,10,20,8], k = 2
 * 输出：31
 * 解释：一种最优方案是 [8,15,8] 和 [10,20] 。
 * - 第 1 个孩子分到 [8,15,8] ，总计 8 + 15 + 8 = 31 块饼干。
 * - 第 2 个孩子分到 [10,20] ，总计 10 + 20 = 30 块饼干。
 * 分发的不公平程度为 max(31,30) = 31 。
 * 可以证明不存在不公平程度小于 31 的分发方案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：cookies = [6,1,3,2,2,4,1,2], k = 3
 * 输出：7
 * 解释：一种最优方案是 [6,1]、[3,2,2] 和 [4,1,2] 。
 * - 第 1 个孩子分到 [6,1] ，总计 6 + 1 = 7 块饼干。 
 * - 第 2 个孩子分到 [3,2,2] ，总计 3 + 2 + 2 = 7 块饼干。
 * - 第 3 个孩子分到 [4,1,2] ，总计 4 + 1 + 2 = 7 块饼干。
 * 分发的不公平程度为 max(7,7,7) = 7 。
 * 可以证明不存在不公平程度小于 7 的分发方案。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= cookies.length <= 8
 * 1 <= cookies[i] <= 10^5
 * 2 <= k <= cookies.length
 * 
 * 
 */

// @lc code=start

class Solution {
    private int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        dfs(0, new int[k], cookies.length, k, cookies);
        return ans;
    }

    public void dfs(int index, int[] v, int n, int k, int[] cookies) {
        // v代表长度为k的桶数组，依次尝试向第k个桶里添加cookie元素
        // 上述依次尝试的过程即为下面的for循环
        if (index == n) {
            int maxv = 0;
            for (int i = 0; i < k; i++) {
                maxv = Math.max(maxv, v[i]);
            }
            ans = Math.min(maxv, ans);
            return;
        }

        for (int i = 0; i < k; ++i) {
            if (v[i] + cookies[index] >= ans) {
                continue; // 如果把当前第index个饼干分配给第i个人会超过当前结果，则直接剪枝
            }
            v[i] += cookies[index];
            dfs(index + 1, v, n, k, cookies); // 深度优先搜索，直到将所有的cookie都添加完为止
            v[i] -= cookies[index];
        }

    }
}
// @lc code=end
