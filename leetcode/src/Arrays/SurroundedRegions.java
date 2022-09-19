package Arrays;
/*
Question :

When I tried this question, explanation was not clear to me, so here is an easy explanation for all those who also did't get the question.

We have to flip O to X
We don't have to touch the boundary
We also don't have to touch those O's that are any how related to the boundary's Os.

Conecpt used :

First traverse all the four boundaries and check only for Os.
As soon as you find an O call a function that will traverse in all four directions and find all surrounded Os.
When you find an O that is any how related to boundary's O, just reserve it with any other character Ex:'@'
This is done to make sure that when you later traverse the board internally you don't touch these Os.
After traversing all the boundaries, traverse internally and leave all the '@' and 'X' untouched and flip all 'O' into 'X'.
Just before ending traverse the board again and flip all the reserved block '@' back to 'O'.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int i = 0;
        int j = 0;
        int[][] visited = new int[board.length][board[0].length];
        while (i < board.length){
            while (j < board[i].length){
                dfs(i, j, visited, board);
                if (i == 0 || i == board.length - 1){
                    j++;
                }
                else {
                    if (j == 0)
                        j = board[i].length - 1;
                    else
                        j++;
                }
            }
            i++;
            j = 0;
        }
        for (i = 0; i < board.length; i++)
            for (j = 0; j < board[i].length; j++)
                if (board[i][j] == 'O' && visited[i][j] == 0)
                    board[i][j] = 'X';
    }

    public void dfs(int r, int c, int[][] visited, char[][] board){
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || visited[r][c] == 1 || board[r][c] == 'X')
            return;
        visited[r][c] = 1;
        dfs(r+1,c, visited, board);
        dfs(r-1,c, visited, board);
        dfs(r,c+1, visited, board);
        dfs(r,c-1, visited, board);
    }
}
