package Dijkstra;

import java.util.*;
import java.io.*;

public class Beak_1916_최소비용구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Integer[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Integer[]{e, w});
        }

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new Integer[]{S, 0});
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Integer[] cur = pq.poll();

            int n = cur[0];
            int w = cur[1];

            if (w > dist[n]) continue;

            for (Integer[] next : graph.get(n)) {
                int nextN = next[0];
                int nextW = next[1];

                if (w + nextW < dist[nextN]) {
                    dist[nextN] = w + nextW;
                    pq.offer(new Integer[]{nextN, w + nextW});
                }
            }
        }

        System.out.println(dist[E]);
    }
}
