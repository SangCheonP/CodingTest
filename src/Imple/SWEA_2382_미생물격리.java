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

            Collections.sort(micros);

            for (int i = 0; i < M; i++) {
                int ni, nj;
                // 이동
                for (int j = 0; j < micros.size(); j++) {
                    Point p = micros.get(j);

                    ni = p.i + di[p.dir];
                    nj = p.j + dj[p.dir];

                    // 위치 저장
                    p.i = ni;
                    p.j = nj;
                    p.num = p.i * N + p.j;

                    // 약 품에 닿으면
                    if(ni == 0 || ni == N-1 || nj == 0 || nj == N-1){
                        // 방향 반대로
                        p.dir = chDir(p.dir);
                        // 개체수 반절로
                        p.cnt /= 2;
                        // 개체수가 0이 되면
                        if(p.cnt == 0){
                            // 해당 미생물 제거
                            micros.remove(j);
                            j--;
                        }
                    }
                }
                
                // 미생물 정렬
                Collections.sort(micros);
                
                // 자기랑 다음 미생물을 모두 비교
                for (int j = 0; j < micros.size() - 1; j++) {
                    // 둘이 같은 위치에 있으면
                    if(micros.get(j).num == micros.get(j+1).num){
                        // 개체 수가 많은 곳에 함침
                        micros.get(j).cnt += micros.get(j+1).cnt;
                        // 작은 것은 제거
                        micros.remove(j+1);
                        j--;
                    }
                }
            }
            
            // 전체 미생물 수 구하기
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
