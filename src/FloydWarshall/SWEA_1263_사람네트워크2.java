package FloydWarshall;
/**
 * SWEA 1263 사람 네트워크2(D6)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        final int INF = 1050;

        for(int tc = 1; tc <= TC; tc++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            // 0 ~ N-1번 노드 까지 있음
            int[][] node = new int[N][N];

            // 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    node[i][j] = Integer.parseInt(st.nextToken());
                    // 연결되어 있지 않으면
                    if(node[i][j] == 0 && i != j){
                        node[i][j] = INF;
                    }
                }
            }

            // 거쳐가는 중간 노드
            for (int k = 0; k < N; k++) {
                // 시작 정점
                for (int i = 0; i < N; i++) {
                    // 끝 정점
                    for (int j = 0; j < N; j++) {
                        node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                    }
                }
            }

            // 최솟값 구함
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                for (int j = 0; j < N; j++) {
                    tmp += node[i][j];
                }
                result = Math.min(result, tmp);
            }

            System.out.println("#"+tc + " " + result);
        }
    }
}
