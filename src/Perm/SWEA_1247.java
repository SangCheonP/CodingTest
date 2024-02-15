package Perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 1247 최적 경로 (D5)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
 */
public class SWEA_1247 {
    public static Point[] map, result;
    public static boolean[] isSelected;
    public static int N, strI, strJ, edI, edJ, dis;

    public static class Point {
        int i;
        int j;

        public Point(int x, int y) {
            this.i = y;
            this.j = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // N: 고객의 수
            N = Integer.parseInt(br.readLine());

            map = new Point[N];
            result = new Point[N];

            st = new StringTokenizer(br.readLine());
            // 시작 지점
            strJ = Integer.parseInt(st.nextToken());
            strI = Integer.parseInt(st.nextToken());
            // 도착 지점
            edJ = Integer.parseInt(st.nextToken());
            edI = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                map[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            dis = Integer.MAX_VALUE;
            isSelected = new boolean[N];
            perm(0);

            System.out.println("#" + tc + " " + dis);
        }
    }

    public static void perm(int idx){
        if(idx == N){
            // 시작과 첫 고객 간의 거리
            int tmp = Math.abs(result[0].i - strI) + Math.abs(result[0].j - strJ);
            // 고객들 간의 거리
            for (int k = 0; k < N-1; k++) {
                tmp += Math.abs(result[k].i - result[k+1].i) + Math.abs(result[k].j - result[k+1].j);
            }
            // 마지막 고객과 집 간의 거리
            tmp += Math.abs(result[N-1].i - edI) + Math.abs(result[N-1].j - edJ);
            dis = Math.min(dis, tmp);
            return;
        }

        // 순열 생성
        for (int i = 0; i < N; i++) {
            if(isSelected[i])
                continue;
            isSelected[i] = true;
            result[idx] = map[i];
            perm(idx + 1);
            isSelected[i] = false;
        }
    }
}
