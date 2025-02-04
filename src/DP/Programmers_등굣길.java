class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] map = new int[n + 1][m + 1];

        // 웅덩이 초기화 (좌표 변환 주의!)
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        // 시작 위치 초기화
        map[1][1] = 1;

        // DP 수행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점이거나 웅덩이면 건너뛰기
                if ((i == 1 && j == 1) || map[i][j] == -1) continue;

                // 왼쪽에서 오는 경우
                if (map[i][j - 1] != -1) {
                    map[i][j] += map[i][j - 1];
                    map[i][j] %= MOD;
                }

                // 위에서 오는 경우
                if (map[i - 1][j] != -1) {
                    map[i][j] += map[i - 1][j];
                    map[i][j] %= MOD;
                }
            }
        }

        return map[n][m];
    }
}
