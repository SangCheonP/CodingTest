package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 17144 미세먼지 안녕!(골드4)
 * https://www.acmicpc.net/problem/17144
 */
public class Baek_17144_미세먼지안녕 {
    public static int R, C;
    public static List<Point> airList;
    // 시계 방향(상, 우, 하, 좌)
    public static int[] di = {-1, 0, 1, 0};
    public static int[] dj = {0, 1, 0, -1};
    public static int[][] map, newMap;

    public static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airList = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    airList.add(new Point(i, j));
                }
            }
        }

        newMap = new int[R][C];
        for (int i = 0; i < T; i++) {
            for (int p = 0; p < newMap.length; p++) {
                Arrays.fill(newMap[p], 0);
            }
            // 먼지 확산
            sprade(newMap);
            // 공기 청정기 작동
            clear1(airList.get(0));
            clear2(airList.get(1));
        }

        System.out.println(getResult());
    }

    public static void clear1(Point p){
        // 배열 밀기
        int d = 0;

        int ni = p.i - 1;
        int nj = p.j;
        int bi = ni;
        int bj = nj;

        while (true){
            ni += di[d];
            nj += dj[d];

            if(ni == p.i && nj == p.j) {
                map[bi][bj] = 0;
                break;
            }
            // 모서리에 도착
            if(ni < 0 || ni > p.i || nj < 0 || nj >= C){
                // 되돌리기
                ni -= di[d];
                nj -= dj[d];

                d = (d + 1) % 4;

                // 다시 진행
                ni += di[d];
                nj += dj[d];
            }
            map[bi][bj] = map[ni][nj];
            bi = ni;
            bj = nj;
        }
    }

    public static void clear2(Point p){
        // 배열 밀기
        int d = 2;

        int ni = p.i + 1;
        int nj = p.j;
        int bi = ni;
        int bj = nj;

        while (true){
            ni += di[d];
            nj += dj[d];

            if(ni == p.i && nj == p.j) {
                map[bi][bj] = 0;
                break;
            }
            // 모서리에 도착
            if(ni < p.i || ni >= R || nj < 0 || nj >= C){
                // 되돌리기
                ni -= di[d];
                nj -= dj[d];

                d -= 1;
                if(d < 0){
                    d = 3;
                }

                // 다시 진행
                ni += di[d];
                nj += dj[d];
            }
            map[bi][bj] = map[ni][nj];
            bi = ni;
            bj = nj;
        }
    }

    public static void sprade(int[][] newMap){
        // 공기 청정기 놓기
        for (Point p : airList) {
            newMap[p.i][p.j] = -1;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 0 || map[i][j] == -1) continue;
                // 확산되는 양
                int spCnt = map[i][j]/5;
                // 확산된 칸 수
                int allCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    // 범위 안 + 공기 청정기X
                    if(0 <= ni && ni < R && 0 <= nj && nj < C && newMap[ni][nj] != -1){
                        newMap[ni][nj] += spCnt;
                        allCnt += 1;
                    }
                }
                newMap[i][j] += map[i][j] - (spCnt)*allCnt;
            }
        }

        copy(newMap, map);
    }

    public static int getResult(){
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) cnt += map[i][j];
            }
        }
        return cnt;
    }

    public static void copy(int[][] map, int[][] newMap){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }
}
