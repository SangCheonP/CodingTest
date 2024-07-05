package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11779
 * 골드3
 * 다익스트라
 */

public class Baek_11779_최소비용구하기2 {
    static int INF = Integer.MAX_VALUE;

    static class Point implements Comparable<Point>{
        int idx, w;
        Point(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // n : 도시의 개수
        // m : 버스의 개수
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 인접 행렬
        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 방문 관리 배열
        boolean[] visited = new boolean[n+1];
        visited[0] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 정답 배열
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 가중치 최소값을 구하기 위한 큐
        Queue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(start, 0));


        // while 돌기
        // 가중치가 가장 낮은 것을 찾음
        // min(가중치 낮은 것 + 그것부터 목적지까지, 지금까지~목적지)
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(visited[cur.idx]){
                continue;
            }

            visited[cur.idx] = true;

            // 도착점
            for(int next = 1; next <= n; next++){
                if(graph[cur.idx][next] != INF){
                    int newDist = cur.w + graph[cur.idx][next];
                    if(newDist < dist[next]){
                        dist[next] = newDist;
                        queue.offer(new Point(next, dist[next]));
                    }
                }
            }
        }
        System.out.print(dist[end]);
    }
}
