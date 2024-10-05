package DP;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2N개 스티커
 * 2행 N열
 * 가치가 최대가 되도록
 *
 * 스티커를 첫 줄에서 2가지 모두 해봄
 * 보통 대각선의 이동하는데 3칸 뒤 대각선 < 1칸 + 2칸 + 3칸 뒤 대각선
 * 그래서 1칸 뒤, 2칸 뒤 대각선만 신경씀
 */
public class Baek_9465_스티커 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 구할 것 앞에 2칸을 고려해야하기 때문에 0추가
            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for(int j = 2; j <= N; j++){
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + map[0][j]; // 2칸, 1칸 전 아래에서 대각선으로 올라올때
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + map[1][j]; // 2칸, 1칸 전 위에서 대각선으로 내려갈때
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
