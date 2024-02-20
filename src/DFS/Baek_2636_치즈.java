package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2636 치즈(골드4) - DFS
https://www.acmicpc.net/problem/2636
 */
public class Baek_2636_치즈 {
    // 좌, 상, 우
    public static int[] di = {0, -1, 0, 1};
    public static int[] dj = {-1, 0, 1, 0};
    public static int N, M;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // time: 치즈가 녹은 시간 / ch: 외각 치즈의 개수 / last_ch: 바로 전 외각 치즈의 개수
        int time = 0, ch = 0, last_ch = 0;


        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 공기: -1 / 구멍: 0 / 치즈: 1 / 경계: 2
        updateAir(0, 0);

        // 외각 업데이트
        ch = updateOutside();
        last_ch = ch;

        // 외각이 있으면
        while(ch != 0) {
            // 외각을 공기로
            changeOutsideToAir();

            time += 1;

            // 배열을 돌면서
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 구멍이면
                    if(map[i][j] == 0){
                        for (int d = 0; d < 4; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];

                            // 공기와 구멍이 연결되었으면
                            if(0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == -1){
                                // 공기(구멍) 업데이트
                                updateAir(i, j);
                                break;
                            }
                        }
                    }
                }
            }

            // 외각 업데이트
            ch = updateOutside();
            // 외각이 있으면
            if(ch != 0)
                last_ch = ch;
        }

        System.out.println(time);
        System.out.println(last_ch);
    }

    // 외각을 공기로 바꿈
    private static void changeOutsideToAir() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 외각을 공기로 바꿔줌
                if(map[i][j] == 2)
                    map[i][j] = -1;
            }
        }
    }
    
    // 외각 업데이트
    private static int updateOutside() {
        int c = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 치즈이고
                if(map[i][j] == 1){
                    // 네변에 바로 옆이면 외각으로
                    if(j == 1 || j == M-2 || i == 1 || i == N-2) {
                        c += 1;
                        map[i][j] = 2;
                    }
                    else{
                        // 안에 있으면
                        for (int d = 0; d < 4; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            // 근처에 공기가 있으면 외각으로
                            if(0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == -1){
                                c += 1;
                                map[i][j] = 2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return c;
    }

    // 공기 업데이트
    public static void updateAir(int i, int j){
        map[i][j] = -1;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 0){
                map[i][j] = -1;
                updateAir(ni, nj);
            }
        }
    }
}
