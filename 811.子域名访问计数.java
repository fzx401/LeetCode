/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-06 21:29:24
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-06 22:41:12
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 *
 * https://leetcode.cn/problems/subdomain-visit-count/description/
 *
 * algorithms
 * Medium (76.86%)
 * Likes:    189
 * Dislikes: 0
 * Total Accepted:    45.9K
 * Total Submissions: 59.7K
 * Testcase Example:  '["9001 discuss.leetcode.com"]'
 *
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com"
 * ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名
 * "leetcode.com" 以及 "com" 。
 * 
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3
 * 为域名本身。
 * 
 * 
 * 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了
 * 9001 次。
 * 
 * 
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序
 * 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：cpdomains = ["9001 discuss.leetcode.com"]
 * 输出：["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
 * 解释：例子中仅包含一个网站域名："discuss.leetcode.com"。
 * 按照前文描述，子域名 "leetcode.com" 和 "com" 都会被访问，所以它们都被访问了 9001 次。
 * 
 * 示例 2：
 * 
 * 
 * 输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
 * "5 wiki.org"]
 * 输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5
 * org","1 intel.mail.com","951 com"]
 * 解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1
 * 次，"wiki.org" 5 次。
 * 而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5
 * 次。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= cpdomain.length <= 100
 * 1 <= cpdomain[i].length <= 100
 * cpdomain[i] 会遵循 "repi d1i.d2i.d3i" 或 "repi d1i.d2i" 格式
 * repi 是范围 [1, 10^4] 内的一个整数
 * d1i、d2i 和 d3i 由小写英文字母组成
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] strs = domain.split(" ");
            int count = Integer.parseInt(strs[0]);
            String[] subdomains = strs[1].split("\\."); // Java中\代表转义字符，故"\\."代表"\.","\."才代表正则表达式
            if (subdomains.length == 2) {
                map.put(String.join(".", subdomains), map.getOrDefault(String.join(".", subdomains), 0) + count);
                map.put(subdomains[1], map.getOrDefault(subdomains[1], 0) + count);
            } else if (subdomains.length == 3) {
                map.put(String.join(".", subdomains), map.getOrDefault(String.join(".", subdomains), 0) + count);
                map.put(String.join(".", Arrays.copyOfRange(subdomains, 1, subdomains.length)),
                        map.getOrDefault(String.join(".", Arrays.copyOfRange(subdomains, 1, subdomains.length)), 0)
                                + count);
                map.put(String.join(".", subdomains[subdomains.length - 1]),
                        map.getOrDefault(String.join(".", subdomains[subdomains.length - 1]), 0) + count);
            }

        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue().toString() + " " + entry.getKey());
        }
        return res;
    }
}
// @lc code=end
