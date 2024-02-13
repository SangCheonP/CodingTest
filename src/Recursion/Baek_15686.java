package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 15686 치킨 배달 (골드5)
https://www.acmicpc.net/problem/15686
 */
public class Baek_15686 {
    public static int N, M, result;
    public static int[][] map;
    public static List<Point> hmPoint, ckPoint;
    public static Point[] selectCk;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 배열 크기, M: 고를 치킨집의 수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 지도 배열
        map = new int[N][N];
        // 선택한 M개의 치킨집
        selectCk = new Point[M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 모든 집, 치킨의 위치 리스트
        hmPoint = new ArrayList<>();
        ckPoint = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이면
                if(map[i][j] == 1)
                    hmPoint.add(new Point(i, j));
                // 치킨집
                else if(map[i][j] == 2)
                    ckPoint.add(new Point(i, j));
            }
        }

        // 도시의 치킨 거리
        result = Integer.MAX_VALUE;

        comb(0, 0);

        System.out.println(result);
    }

    // 치킨집에서 M개 뽑는 함수
    public static void comb(int idx, int cnt){
        // 치킨 집을 뽑으면
        if(cnt == M){

            // 임시 저장할 도시 치킨 거리
            int sum = 0;

            // 모든 집에서부터
            for (int i = 0; i < hmPoint.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                // 선택한 치킨집까지
                for (int j = 0; j < selectCk.length; j++) {
                    // 치킨 거리 계산
                    // 최소 치킨 거리 선택
                    tmp = Math.min(tmp, (Math.abs(hmPoint.get(i).i - selectCk[j].i) + Math.abs(hmPoint.get(i).j- selectCk[j].j)));
                }
                sum += tmp;
            }

            result = Math.min(result, sum);

            return;
        }
        if(idx == ckPoint.size())
            return;

        // 해당 치킨집 선택
        selectCk[cnt] = ckPoint.get(idx);
        comb(idx+ 1, cnt+1);
        // 해당 치킨집 선택 X;
        comb(idx+ 1, cnt);
    }
}
