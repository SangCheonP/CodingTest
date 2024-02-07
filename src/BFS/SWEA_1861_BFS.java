package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
SWEA 1861 정사각형 방 (D4) - BFS
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
 */
public class SWEA_1861_BFS {
    public static class idx{
        int i;
        int j;

        public idx(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    // 방 번호 배열, 각 위치에서 이동할 수 있는 거리를 저장한 배열
    public static int[][] map, dp;
    public static int N;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            Queue<idx> queue = new ArrayDeque<>();
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dp = new int[N][N];

            for(int i = 0; i < N; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 방 번호를 저장할 배열
            int roomNum = Integer.MAX_VALUE;
            int result = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    queue.clear();

                    // 현재 이동 거리
                    dp[i][j] = 1;
                    queue.offer(new idx(i, j));

                    // 다음 좌표와 비교위한 변수
                    int r = i, c = j;

                    while (!queue.isEmpty()) {
                        idx curIdx = queue.poll();

                        // 4방향으로
                        for (int d = 0; d < 4; d++) {
                            int ni = curIdx.i + di[d];
                            int nj = curIdx.j + dj[d];

                            if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == map[r][c] + 1) {
                                // 현재 이동 거리 1증가
                                dp[i][j] += 1;
                                //System.out.println("r: " + r + ", c: " + c + ", ni: " + ni + ", nj: " + nj + ", dp[i][j]: " + dp[i][j] + ", d: " + d );
                                queue.offer(new idx(ni, nj));
                                
                                // 비교 시작지점 다시 설정
                                r = ni;
                                c = nj;
                                // break 안 걸면 왜 틀림?
                                // 자신 보다 +1인 것은 하나이기 때문에 for 탈출
                                break;
                            }
                        }
                    }

                    if(dp[i][j] > result){
                        result = dp[i][j];
                        roomNum = map[i][j];
                    }else if(dp[i][j] == result && roomNum > map[i][j]){
                            roomNum = map[i][j];
                    }

                }
            }
            System.out.println("#" + tc + " " + roomNum + " " + result);
        }
    }
}