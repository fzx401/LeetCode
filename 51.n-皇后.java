/*
 * @Author: FaizalFeng fzx401@gmail.com
 * @Date: 2024-04-18 22:39:43
 * @LastEditors: FaizalFeng fzx401@gmail.com
 * @LastEditTime: 2024-04-18 23:12:13
 * Copyright (c) 2024 by FaizalFeng, All Rights Reserved.
 */
/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 *
 * https://leetcode.cn/problems/n-queens/description/
 *
 * algorithms
 * Hard (73.90%)
 * Likes:    2063
 * Dislikes: 0
 * Total Accepted:    390.5K
 * Total Submissions: 528.3K
 * Testcase Example:  '4'
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * 
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 
 * 
 * 
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[["Q"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    // private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(result, board, 0, n);
        return result;
    }

    public void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        // 在指定了一行后，对这一行每一列进行检查
        if (row == n) {
            result.add(convertBoardToStringList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }

    }

    public boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> convertBoardToStringList(char[][] board) {
        List<String> boardStrings = new ArrayList<>();
        for (char[] row : board) {
            boardStrings.add(new String(row)); // 将数组转化为字符串
        }
        return boardStrings;
    }
}
// @lc code=end
