package Imple;

import java.util.*;
import java.io.*;

public class Baek_15683_감시 {
    static int[][] map;
    static List<Cctv> cctv;
    static int result, N, M;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctv = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) cctv.add(new Cctv(i, j, map[i][j]));
            }
        }

        result = Integer.MAX_VALUE;

        backTrack(0, map);

        System.out.println(result);
    }

    static void backTrack(int cnt, int[][] currentMap) {
        if(cnt == cctv.size()) {
            int temp = 0;

            for (int[] m : currentMap) {
                for (int n : m) {
                    if (n == 0) temp++;
                }
            }

            result = Math.min(result, temp);
            return;
        }

        Cctv cur = cctv.get(cnt);
        for (int d = 0; d < 4; d++) {
            int[][] nextMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                nextMap[i] = currentMap[i].clone();
            }

            if (cur.t == 1) {
                watch(nextMap, cur.i, cur.j, d);
            } else if (cur.t == 2) {
                if (d >= 2) continue; // 2번은 상하/좌우 두 가지만 확인
                watch(nextMap, cur.i, cur.j, d);
                watch(nextMap, cur.i, cur.j, d + 2);
            } else if (cur.t == 3) {
                watch(nextMap, cur.i, cur.j, d);
                watch(nextMap, cur.i, cur.j, (d + 3) % 4);
            } else if (cur.t == 4) {
                watch(nextMap, cur.i, cur.j, d);
                watch(nextMap, cur.i, cur.j, (d + 3) % 4);
                watch(nextMap, cur.i, cur.j, (d + 2) % 4);
            } else if (cur.t == 5) {
                if (d >= 1) continue;
                watch(nextMap, cur.i, cur.j, d);
                watch(nextMap, cur.i, cur.j, (d + 1) % 4);
                watch(nextMap, cur.i, cur.j, (d + 2) % 4);
                watch(nextMap, cur.i, cur.j, (d + 3) % 4);
            }

            backTrack(cnt + 1, nextMap);
        }
    }

    static void watch(int[][] tmpMap, int i, int j, int d) {
        int ni = i, nj = j;
        while (true) {
            ni += di[d];
            nj += dj[d];
            if (ni < 0 || ni >= N || nj < 0 || nj >= M || tmpMap[ni][nj] == 6) break;
            if (tmpMap[ni][nj] == 0) tmpMap[ni][nj] = 7; // 다른 CCTV(1~5)는 통과함
        }
    }
}

class Cctv {
    int i, j, t;

    public Cctv (int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}