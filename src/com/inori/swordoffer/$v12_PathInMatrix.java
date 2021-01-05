package com.inori.swordoffer;

/**
 * $v12_PathInMatrix
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author inori
 * @date 2020/3/31
 */
public class $v12_PathInMatrix {
    public static void main(String[] args) {
        System.out.println(new $v12_PathInMatrix().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (bfs(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(char[][] board, int i, int j, String words) {
        if (words.length() == 0) return true;
        char c = words.charAt(0);
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != c) return false;
        String substring = words.substring(1);
        board[i][j] = '$';
        boolean exist = bfs(board, i - 1, j, substring) //向左搜索
                || bfs(board, i + 1, j, substring) //向右搜索
                || bfs(board, i, j - 1, substring) // 向下搜索
                || bfs(board, i, j + 1, substring);// 向上搜索
        board[i][j] = c;
        return exist;
    }


//    public boolean exist(char[][] board, String word) {
//        char c = word.charAt(0);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (c == board[i][j]) {
//                    if (exist(board, i, j, word)) return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean exist(char[][] board, int i, int j, String words) {
//        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
//        if (words.charAt(0) != board[i][j]) return false;
//        if (words.length() == 1) return true;
//        char tmp = board[i][j];
//        board[i][j] = '$';
//        String subWord = words.substring(1);
//        boolean b = exist(board, i - 1, j, subWord) || exist(board, i + 1, j, subWord) || exist(board, i, j - 1, subWord) || exist(board, i, j + 1, subWord);
//        board[i][j] = tmp;
//        return b;
//    }

}
