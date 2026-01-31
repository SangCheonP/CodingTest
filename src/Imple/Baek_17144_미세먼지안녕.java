package Imple;

import java.util.*;
import java.io.*;

public class Baek_17144_미세먼지안녕 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        int result = 0;

        List<Integer[]> air = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n == -1) {
                    air.add(new Integer[]{i, j});
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int[][] tempMap = new int[R][C];
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] == -1) tempMap[i][j] = -1;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        int amount = map[i][j] / 5;
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + di[d], nj = j + dj[d];
                            if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
                                tempMap[ni][nj] += amount;
                                count++;
                            }
                        }
                        tempMap[i][j] += (map[i][j] - (amount * count));
                    }
                }
            }
            map = tempMap;

            int top = air.get(0)[0];
            for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0]; // 왼쪽 벽 (내려오기)
            for (int j = 0; j < C - 1; j++) map[0][j] = map[0][j + 1];    // 위쪽 벽 (왼쪽으로)
            for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1]; // 오른쪽 벽 (올라가기)
            for (int j = C - 1; j > 1; j--) map[top][j] = map[top][j - 1];  // 아래쪽 벽 (오른쪽으로)
            map[top][1] = 0; // 공기청정기에서 나가는 바람은 깨끗함

            int bottom = air.get(1)[0];
            for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0]; // 왼쪽 (올라오기)
            for (int j = 0; j < C - 1; j++) map[R - 1][j] = map[R - 1][j + 1];    // 아래 (왼쪽으로)
            for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1]; // 오른쪽 (내려가기)
            for (int j = C - 1; j > 1; j--) map[bottom][j] = map[bottom][j - 1];   // 위쪽 (오른쪽으로)
            map[bottom][1] = 0;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) result += map[i][j];
            }
        }

        System.out.println(result);
    }
}

class Dust {
    int i, j, w;

    public Dust(int i, int j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }
}
