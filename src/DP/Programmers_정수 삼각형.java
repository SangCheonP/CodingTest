import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        // DP 배열을 직접 triangle 배열에 적용하여 업데이트
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    // 왼쪽 가장자리
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    // 오른쪽 가장자리
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    // 가운데 값 처리
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        // 마지막 줄에서 최댓값 찾기
        return Arrays.stream(triangle[n - 1]).max().getAsInt();
    }
}
