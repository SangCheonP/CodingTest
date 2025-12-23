package PrefixSum;

class Programmers_파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];

        // 1. skill 배열을 기반으로 변화량(diff) 기록
        for (int[] s : skill) {
            int value = s[5];
            if (s[0] == 1) value = -value; // 공격이면 음수, 회복이면 양수

            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];

            diff[r1][c1] += value;
            diff[r2 + 1][c1] -= value;
            diff[r1][c2 + 1] -= value;
            diff[r2 + 1][c2 + 1] += value;
        }

        // 2. 누적 합 계산 (행 기준)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 3. 누적 합 계산 (열 기준)
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // 4. board 적용 후, 파괴되지 않은 건물 개수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j]; // 변경된 값 반영
                if (board[i][j] > 0) answer++; // 내구도가 1 이상이면 파괴되지 않음
            }
        }

        return answer;
    }
}
