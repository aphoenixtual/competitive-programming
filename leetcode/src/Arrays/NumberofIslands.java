package Arrays;

public class NumberofIslands {

    /*
    Runtime: 2 ms, faster than 100.00% of Java online submissions for Number of Islands.
    Memory Usage: 50.6 MB, less than 95.08% of Java online submissions for Number of Islands.
     */
    void dfs(char[][] grid,int i,int j){
        grid[i][j]='0';
        if(j-1!=-1 && grid[i][j-1]=='1')
            dfs(grid,i,j-1);
        if(j+1!=grid[0].length && grid[i][j+1]=='1')
            dfs(grid,i,j+1);
        if(i-1!=-1 && grid[i-1][j]=='1')
            dfs(grid,i-1,j);
        if(i+1!=grid.length && grid[i+1][j]=='1')
            dfs(grid,i+1,j);
    }

    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    /*
     public int numIslands(char[][] grid) {
        int islandCount = 0;

        for(int i=0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    // increase the island count
                    ++islandCount;
                    // change any land connected to it to zero
                    changeToWater(grid,i,j);
                }
            }
        }
        return islandCount;
    }

    public void changeToWater(char[][] grid, int i, int j){
        /*Base Cases
            1. row less than 0
            2. row greater than or equal to grid.length.
            3. column less than 0
            4. column greater than or equal to grid[0].length
            5. If position is a 0

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') return;

    grid[i][j] = '0';
    changeToWater(grid,i-1,j); //bottom
    changeToWater(grid,i+1,j); //up
    changeToWater(grid,i,j-1); //left
    changeToWater(grid,i,j+1); //right
}
     */

    /*
    public int numIslands(char[][] grid) {
        // First way: DFS
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // check if this is an island
                // if it is then start searching from here
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    result ++;
                }
                // is water, so continue to next grid
            }
        }
        return result;
    }

    public void DFS(char[][] grid, int x, int y){

        // base case 1:
        // out of bound
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }

        // base case 2:
        // this is water, so finish this searching and return to parent
        if (grid[x][y] == '0') {
            return;
        }

        // This is island, so continue
        // Search in all directions for extending this island
        // We need to prevent children from searching back to parent,
        // so make the current one invalid (water, so that it returns as base case 2).
        grid[x][y] = '0';
        DFS(grid, x-1, y);
        DFS(grid, x, y-1);
        DFS(grid, x+1, y);
        DFS(grid, x, y+1);

        // Don't have to make the current grid from 0 back to 1
        // Because we want to deminish this whole island so that
        // further iterations in numIslands will see this whole area as water and skip
    }
     */
}
