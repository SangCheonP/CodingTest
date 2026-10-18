class Solution {
    private static final int[] DI = {1, -1, 0, 0};
    private static final int[] DJ = {0, 0, 1, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];

        // 같은 색이면 변경할 필요가 없고, 색으로 방문 여부도 구분할 수 없음
        if (target == color) {
            return image;
        }

        dfs(image, sr, sc, target, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int target, int color) {
        // 배열 범위를 벗어나면 종료
        if (i < 0 || i >= image.length
                || j < 0 || j >= image[0].length) {
            return;
        }

        // 다른 색이거나 이미 색을 변경한 칸이면 종료
        if (image[i][j] != target) {
            return;
        }

        // 색 변경이 방문 표시 역할을 함
        image[i][j] = color;

        for (int d = 0; d < 4; d++) {
            dfs(image, i + DI[d], j + DJ[d], target, color);
        }
    }
}
