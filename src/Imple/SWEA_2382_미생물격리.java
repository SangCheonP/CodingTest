package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_2382_미생물격리 {
    public static int N, M, K;
    public static List<Point> micros;
    // 없음, 상, 하, 좌, 우
    public static int[] di = {0, -1, 1, 0, 0};
    public static int[] dj = {0, 0, 0, -1, 1};
    public static class Point implements Comparable<Point>{
        int i, j, cnt, dir, num;
        public Point(int i, int j, int cnt, int dir){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", cnt=" + cnt +
                    ", dir=" + dir +
                    ", num=" + num +
                    '}';
        }

        @Override
        public int compareTo(Point o){
            if(this.num == o.num){
                // 같은 위치면 개체수 내림차순
                return o.cnt - this.cnt;
            }
            return this.num - o.num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            // N: 셀의 크기 / M: 격리 시간 / K: 군집의 개수
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            micros = new ArrayList<>();


            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                Point p = new Point(i, j, cnt, d);
                p.num = i*N + j;

                micros.add(p);
            }

            for (int i = 0; i < M; i++) {
                Collections.sort(micros);
                int ni, nj;
                // 이동
                for (int j = 0; j < micros.size(); j++) {
                    Point p = micros.get(j);

                    ni = p.i + di[p.dir];
                    nj = p.j + dj[p.dir];

                    p.i = ni;
                    p.j = nj;
                    p.num = p.i * N + p.j;

                    // 약 품에 닿으면
                    if(ni == 0 || ni == N || nj == 0 || nj == N){
                        p.dir = chDir(p.dir);
                        p.cnt /= 2;
                        // 개체수가 0이 되면
                        if(p.cnt == 0){
                            micros.remove(j);
                            j--;
                        }
                    }
                }
                

                for (int j = 0; j < micros.size() - 1; j++) {
                    // 같은 칸에 있으면
                    if(micros.get(j).num == micros.get(j+1).num){
                        micros.get(j).cnt += micros.get(j+1).cnt;
                        micros.remove(j+1);
                        j--;
                    }
                }

                for (Point p : micros){
                    System.out.println(p);
                }
                System.out.println("-------------------------");
            }

            int result = 0;

            for (Point p : micros){
                result += p.cnt;
            }

            System.out.println("#"+tc + " " +result);
        }
    }

    public static int chDir(int dir){
        // 1: 상 / 2: 하 / 3: 좌 / 4: 우
        switch (dir){
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return 0;
    }
}
