package Imple;

import java.util.*;
import java.io.*;

public class Beak_14503_로봇청소기 {
    // 0: 북(-1, 0), 1: 동(0, 1), 2: 남(1, 0), 3: 서(0, -1)
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // i
        M = Integer.parseInt(st.nextToken()); // j

        int[][] map = new int[N][M];
        int[] robot = new int[3];

        st = new StringTokenizer(br.readLine());
        robot[0] = Integer.parseInt(st.nextToken()); // i
        robot[1] = Integer.parseInt(st.nextToken()); // j
        robot[2] = Integer.parseInt(st.nextToken()); // d

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 0: 청소X, 1: 벽, 2: 청소O
            }
        }

        int result = 0;

        while (true) {
            int i = robot[0];
            int j = robot[1];
            int d = robot[2];

            if (map[i][j] == 0) {
                map[i][j] = 2;
                result++;
            }

            if (!canClean(i, j, map)) {
                int ni = i + (di[d] * (-1));
                int nj = j + (dj[d] * (-1));

                if (map[ni][nj] == 1) break;
                robot[0] = ni;
                robot[1] = nj;
            } else {
                robot[2] = (d + (4 - 1)) % 4;
                d = robot[2];

                int ni = i + di[d];
                int nj = j + dj[d];

                if (map[ni][nj] == 0) {
                    robot[0] = ni;
                    robot[1] = nj;
                }
            }
        }

        System.out.println(result);
    }

    static boolean canClean(int i, int j, int[][] map) {
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 1 || map[ni][nj] == 2) continue;
            return true;
        }

        return false;
    }
}
