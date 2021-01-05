package com.inori.everyday;

/**
 * $289_GameOfLife [Medium]
 * <p>
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/4/2
 */
public class $289_GameOfLife {

    /**
     * 从0到1 则为2
     * 从1到0 则为-1
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;
                for (int i1 = -1; i1 <= 1; i1++) {
                    for (int j1 = -1; j1 <= 1; j1++) {
                        if (i1 == 0 && j1 == 0) continue;
                        if (i + i1 >= 0 && i + i1 < board.length && j + j1 >= 0 && j + j1 < board[i].length && (Math.abs(board[i + i1][j + j1]) == 1))
                            live++;
                    }
                }
                //从活到死
                if ((live < 2 || live > 3) && board[i][j] == 1) {
                    board[i][j] = -1;
                    //从死到活
                } else if (live == 3 && board[i][j] == 0) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        $289_GameOfLife games = new $289_GameOfLife();
        int[][] board = {
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };
        while (true) {
            print(board);
            Thread.sleep(100);
            games.gameOfLife(board);
        }
    }

    private static void print(int[][] board) {
        System.out.print("\u001b[1000A");
        System.out.print("\u001b[1000D");
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt == 1 ? "🍚" : "  ");
            }
            System.out.println();
        }
    }
}
