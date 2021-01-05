package com.inori.everyday;

/**
 * $999_NumRookCaptures[Easy]
 * <p>
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/26
 */
public class $999_NumRookCaptures {

    /**
     * 先遍历一遍数组找到车的位置，时间O(n^2),然后从车的位置向四个方向搜索直到到达棋盘边缘或遇到小卒和大象时间O(2n)
     * @param board 棋盘
     * @return 车能吃几个卒
     */
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 'R') {
                    return find(board, i, j);
                }
            }
        }
        return 0;
    }

    public int find(char[][] board, int i, int j) {
        int count = 0;
        for (int u = i; u > 0; u--) {
            if (board[u][j] == 'B') break;
            else if (board[u][j] == 'p') {
                count++;
                break;
            }
        }
        for (int d = i; d < board.length; d++) {
            if (board[d][j] == 'B') break;
            else if (board[d][j] == 'p') {
                count++;
                break;
            }
        }
        for (int l = j; l > 0; l--) {
            if (board[i][l] == 'B') break;
            else if (board[i][l] == 'p') {
                count++;
                break;
            }
        }
        for (int r = i; r < board[i].length; r++) {
            if (board[i][r] == 'B') break;
            else if (board[i][r] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }

}
