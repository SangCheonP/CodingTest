package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 16935 배열 돌리기 3 (골드5)
https://www.acmicpc.net/problem/16935
 */
public class Baek_16935 {
    public static int N, M, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 세로, M: 가로, R: 연산 수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 숫자 배열
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            int C = Integer.parseInt(st.nextToken());
            int tmp;
            switch (C){
                case 1:
                    map = calc1(map);
                    break;
                case 2:
                    map = calc2(map);
                    break;
                case 3:
                    tmp = N;
                    N = M;
                    M = tmp;
                    map = calc3(map);
                    break;
                case 4:
                    tmp = N;
                    N = M;
                    M = tmp;
                    map = calc4(map);
                    break;
                case 5:
                    map = calc5(map);
                    break;
                case 6:
                    map = calc6(map);
                    break;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 상하 반전
    public static int[][] calc1(int[][] map){
        int[][] cp = new int[N][M];

        for (int i = N - 1; i >= 0; i--) {
            cp[i] = map[N - i - 1];
        }

        return cp;
    }

    // 좌우 반전
    public static int[][] calc2(int[][] map){
        int[][] cp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = map[i][M - j - 1];
            }
        }

        return cp;
    }

    // 오른쪽으로 90도 회전
    public static int[][] calc3(int[][] map){
        int[][] cp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = map[M - j - 1][i];
            }
        }

        return cp;
    }

    // 왼쪽으로 90도 회전
    public static int[][] calc4(int[][] map){
        int[][] cp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = map[j][N - i - 1];
            }
        }

        return cp;
    }

    // 5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열
    // 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동
    public static int[][] calc5(int[][] map){
        int[][] cp = new int[N][M];
        // 대입할 값의 idx가 넣을 위치와 어떻게 다른지 
        int[] di = {1, 0, -1, 0};
        int[] dj = {0, -1, 0, 1};
        int d = 0;
        boolean rev = false;

        for (int outN = 0; outN < 2; outN++) {
            // 읽는 순서 변경하는지
            if (!rev){
                // 앞에서 부터
                for (int outM = 0; outM < 2; outM++) {
                    // 작은 사각형
                    for (int i = 0; i < N/2; i++) {
                        for (int j = 0; j < M/2; j++) {
                            cp[(outN * N/2) + i][(outM * M/2) + j] = map[(di[d] + outN) * N/2 + i][(dj[d] + outM) * M/2 + j];
                        }
                    }
                    d += 1;
                }
                rev = !rev;
            }
            else{
                // 뒤에서 부터
                for (int outM = 2 - 1; outM >= 0; outM--) {
                    // 작은 사각형
                    for (int i = 0; i < N/2; i++) {
                        for (int j = 0; j < M/2; j++) {
                            cp[(outN * N/2) + i][(outM * M/2) + j] = map[(di[d] + outN) * N/2 + i][(dj[d] + outM) * M/2 + j];
                        }
                    }
                    d += 1;
                }
            }
        }

        return cp;
    }

    // 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동
    public static int[][] calc6(int[][] map){
        int[][] cp = new int[N][M];
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int d = 0;
        boolean rev = false;

        for (int outN = 0; outN < 2; outN++) {
            if (!rev){
                for (int outM = 0; outM < 2; outM++) {
                    for (int i = 0; i < N/2; i++) {
                        for (int j = 0; j < M/2; j++) {
                            cp[(outN * N/2) + i][(outM * M/2) + j] = map[(di[d] + outN) * N/2 + i][(dj[d] + outM) * M/2 + j];
                        }
                    }
                    d += 1;
                }
                rev = !rev;
            }
            else{
                for (int outM = 2 - 1; outM >= 0; outM--) {
                    for (int i = 0; i < N/2; i++) {
                        for (int j = 0; j < M/2; j++) {
                            cp[(outN * N/2) + i][(outM * M/2) + j] = map[(di[d] + outN) * N/2 + i][(dj[d] + outM) * M/2 + j];
                        }
                    }
                    d += 1;
                }
            }
        }

        return cp;
    }
}
