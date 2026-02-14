package Dijkstra;

import java.util.*;
import java.io.*;

public class Baek_1238_파티 {
    static int N, M, X;
    static int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int v, w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node other){
            return this.w - other.w;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> revGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 집 가는 길
            revGraph.add(new ArrayList<>()); // 파티 가는 길 => 기본은 모든 점에 대해서 각각 구해 X값 들을 구하는 방식이지만, 그래프를 뒤집에 X에서 시작하면 다른 곳으로 가는 값을 구하는 데 이는 곧, 파티 가는 길이다
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
            revGraph.get(e).add(new Node(s, w));
        }

        int[] goP = Dijk(revGraph);
        int[] goH = Dijk(graph);

        int result = 0;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, goP[i] + goH[i]);
        }

        System.out.println(result);
    }

    static int[] Dijk (List<List<Node>> graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;

            if (w > dist[v]) continue;

            for (Node next : graph.get(v)) {
                int nV = next.v;
                int nW = next.w;

                if (dist[v] + nW < dist[nV]) {
                    dist[nV] = dist[v] + nW;
                    pq.offer(new Node(nV, dist[v] + nW));
                }
            }
        }

        return dist;
    }
}
