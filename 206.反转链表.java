/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-05 23:31:08
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-15 22:41:45
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (74.20%)
 * Likes:    3548
 * Dislikes: 0
 * Total Accepted:    1.8M
 * Total Submissions: 2.5M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 
 * 
 * 
 * 
 * 
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 递归方式
        // if (head == null || head.next == null) {
        // return head;
        // }
        // ListNode reversedLinkedList = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return reversedLinkedList;
        // 迭代方式
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) { // 当前节点的next节点即使为空也无所谓，因为在下一轮循环时会自动判定退出while
            ListNode removed = cur.next;
            cur.next = prev;
            prev = cur;
            cur = removed;
        }
        return prev;

    }
}
// @lc code=end
