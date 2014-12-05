import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2014/11/13.
 *
 * LeetCode: Surrounded Regions
 * Link: https://oj.leetcode.com/problems/surrounded-regions/
 * Description:
 * -----------------------------
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * -----------------------------
 *
 * Tag: BFS
 */
public class SurroundedRegions {
    BitSet vis;
    int rowCnt, columnCnt;
    public int toIndex(int x, int y) {
        return x * columnCnt + y;
    }
    public void solve(char[][] board) {
        if(board == null || board.length <= 0) {
            return ;
        }
        rowCnt = board.length;
        columnCnt = board[0].length;
        vis = new BitSet(rowCnt * columnCnt);
        // I don't traversal the 'X's, instead I traversal the 'O's
        // I find all 'O's from four sides and flag them to true.
        for(int i=0;i<rowCnt;i++) {
            if(board[i][0] == 'O') {
                bfs(i, 0, board);
            }
            if(board[i][columnCnt-1] == 'O') {
                bfs(i, columnCnt - 1, board);
            }
        }
        for(int i=0;i<columnCnt;i++) {
            if(board[0][i] == 'O') {
                bfs(0, i, board);
            }
            if(board[rowCnt-1][i] == 'O') {
                bfs(rowCnt - 1, i, board);
            }
        }
        // Then I set all chars in board to 'X' except those with true flag
        for(int i=0;i<rowCnt;i++) {
            for(int j=0;j<columnCnt;j++) {
                if(vis.get(toIndex(i, j))) continue;
                board[i][j] = 'X';
            }
        }
    }

    class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(int x, int y, char[][] board) {
        if(vis.get(toIndex(x, y))) return;
        final int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        vis.set(toIndex(x, y));
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i=0;i<4;i++) {
                int tx = point.x + directions[i][0];
                int ty = point.y + directions[i][1];
                if(inTheRegions(tx, ty) && board[tx][ty] == 'O' && !vis.get(toIndex(tx, ty))) {
                    vis.set(toIndex(tx, ty));
                    queue.offer(new Point(tx, ty));
                }
            }
        }
    }

    private boolean inTheRegions(int x, int y) {
        if(x < 0 || x >= rowCnt || y < 0 || y >= columnCnt){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = new char[256][256];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                board[i][j] = 'O';
            }
        }
        new SurroundedRegions().solve(board);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // dfs : StackOverflow
    /*private void dfs(int x, int y, char[][] board) {
        int idx = toIndex(x,y);
        if(vis.get(idx)) return;
        vis.set(idx);
        final int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<4;i++) {
            int tx = x + directions[i][0];
            int ty = y + directions[i][1];
            if(inTheRegions(tx, ty) && board[tx][ty] == 'O' && !vis.get(toIndex(tx, ty))) {
                dfs(tx, ty, board);
            }
        }
    }*/
}