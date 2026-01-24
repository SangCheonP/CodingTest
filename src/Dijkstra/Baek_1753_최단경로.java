package Dijkstra;

import java.util.*;
import java.io.*;

public class Baek_1753_최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        int[] distance = new int[V + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);

        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > distance[cur.n]) continue;

            for (Node next : graph.get(cur.n)) {
                if (distance[next.n] > cur.w + next.w) {
                    distance[next.n] = cur.w + next.w;
                    pq.offer(new Node(next.n, cur.w + next.w));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node>{
    int n, w;

    public Node (int n, int w) {
        this.n = n;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}