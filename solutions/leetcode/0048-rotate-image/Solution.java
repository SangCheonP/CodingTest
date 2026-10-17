class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) { // 마지막 모서리까지 처리하면 중복 교환
                int temp = matrix[i][n - j - 1];

                // 상 <- 좌
                matrix[i][n - j - 1] = matrix[j][i];
                // 좌 <- 하
                matrix[j][i] = matrix[n - i - 1][j];
                // 하 <- 우
                matrix[n - i - 1][j] = matrix[n - j - 1][n - i - 1];
                // 우 <- 상
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }
}
