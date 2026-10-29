import java.util.ArrayList;
import java.util.List;

class Solution {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int cnt = n * m;
        boolean[][] visited = new boolean[n][m];
        int i = 0, j = 0, d = 0;

        List<Integer> result = new ArrayList<>();
        result.add(matrix[i][j]);
        visited[i][j] = true;
        cnt--;

        while (cnt > 0) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (!isValid(ni, nj, n, m, visited)) {
                d = (d + 1) % 4;
                ni = i + di[d];
                nj = j + dj[d];
            }
            result.add(matrix[ni][nj]);
            visited[ni][nj] = true;
            cnt--;
            i = ni;
            j = nj;
        }
        return result;
    }

    boolean isValid(int i, int j, int n, int m, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= m) return false;
        if (visited[i][j]) return false;
        return true;
    }
}
