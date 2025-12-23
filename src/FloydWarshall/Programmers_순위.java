package FloydWarshall;

import java.util.*;

class Programmers_순위 {
    public int solution(int n, int[][] results) {
        // ⚡ 그래프 초기화 (승리 여부 저장)
        int[][] graph = new int[n + 1][n + 1];

        // ⚡ 승패 정보 입력
        for (int[] result : results) {
            int winner = result[0];  // 이긴 선수
            int loser = result[1];   // 진 선수
            graph[winner][loser] = 1;  // winner가 loser를 이김
            graph[loser][winner] = -1; // loser는 winner에게 패배
        }

        // 🏆 플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= n; k++) { // 중간 노드 (경유지)
            for (int i = 1; i <= n; i++) { // 출발 노드
                for (int j = 1; j <= n; j++) { // 도착 노드
                    // i가 k를 이기고, k가 j를 이기면 → i는 j를 이김
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;  // i → j 승리 확정
                        graph[j][i] = -1; // j → i 패배 확정
                    }
                }
            }
        }

        // 🏅 순위가 확정된 선수 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0; // 확정된 승패 관계 개수
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] != 0) count++; // 자기 자신 제외하고 승패 관계가 있는 경우 증가
            }
            if (count == n - 1) answer++; // 모든 선수와 승패 관계가 확정된 경우 순위 결정 가능
        }

        return answer; // 순위가 확정된 선수의 총 수 반환
    }
}
