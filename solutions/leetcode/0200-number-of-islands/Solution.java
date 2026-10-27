class Solution {
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j, grid);
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '2';
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length) continue;
            if (grid[ni][nj] == '1') dfs(ni, nj, grid);
        }
    }
}
