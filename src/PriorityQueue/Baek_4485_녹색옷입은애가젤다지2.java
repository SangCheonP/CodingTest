package PriorityQueue;

import java.io.*;
import java.util.*;
public class Baek_4485_녹색옷입은애가젤다지2 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static class Point implements Comparable<Point>{
        int i, j, k;
        public Point(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public int compareTo(Point o){
            return Integer.compare(this.k, o.k);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        final int INF = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int time = 1;

        while(N != 0){
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dist[i], INF);
            }

            dist[0][0] = map[0][0];

            PriorityQueue<Point> pq = new PriorityQueue<>();

            pq.offer(new Point(0, 0, map[0][0]));

            while(!pq.isEmpty()){
                Point cur = pq.poll();

                for(int d = 0; d < 4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    // 현재까지 비용 + 다음 비용 < 다음 위치까지의 비용
                    if(0 <= ni && ni < N && 0 <= nj && nj < N && (map[ni][nj] + dist[cur.i][cur.j] < dist[ni][nj])){
                        dist[ni][nj] = map[ni][nj] + dist[cur.i][cur.j];
                        pq.offer(new Point(ni, nj, map[ni][nj]));
                    }
                }
            }


            System.out.println("Problem " + time++ + ": " + dist[N-1][N-1]);

            N = Integer.parseInt(br.readLine());
        }
    }
}
