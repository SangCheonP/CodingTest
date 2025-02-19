import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        // 🔹 3배 크기의 확장된 자물쇠 배열 생성
        int[][] newLock = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[n + i][n + j] = lock[i][j]; // 중앙에 기존 자물쇠 위치시킴
            }
        }

        // 🔹 열쇠를 4번 회전하며 모든 위치에서 탐색
        for (int d = 0; d < 4; d++) {
            key = rotateKey(key); // 열쇠 회전
            
            // 🔹 열쇠를 이동하며 확인
            for (int x = 1; x < 2 * n; x++) {
                for (int y = 1; y < 2 * n; y++) {
                    // 🔹 자물쇠에 열쇠 적용
                    if (check(newLock, key, x, y, n, m)) {
                        return true; // 성공하면 즉시 true 반환
                    }
                }
            }
        }
        return false; // 가능한 경우가 없으면 false 반환
    }

    // 🔄 열쇠를 90도 회전시키는 함수
    private int[][] rotateKey(int[][] key) {
        int len = key.length;
        int[][] rotatedKey = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rotatedKey[j][len - 1 - i] = key[i][j]; // 90도 회전
            }
        }
        return rotatedKey;
    }

    // 🔎 특정 위치에서 열쇠가 자물쇠를 정확히 채울 수 있는지 확인하는 함수
    private boolean check(int[][] newLock, int[][] key, int x, int y, int n, int m) {
        // 🔹 자물쇠에 열쇠를 삽입
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newLock[x + i][y + j] += key[i][j];
            }
        }

        // 🔹 자물쇠가 모두 1이 되었는지 확인 (자물쇠 홈이 열쇠로 정확히 채워졌는지)
        boolean isValid = true;
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if (newLock[i][j] != 1) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) break;
        }

        // 🔹 열쇠를 다시 제거 (복구)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newLock[x + i][y + j] -= key[i][j];
            }
        }

        return isValid;
    }
}
