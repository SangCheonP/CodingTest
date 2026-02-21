package MST;

import java.util.*;
import java.io.*;

public class Baek_1197_최소스패닝트리 {
    static int[] rank, parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s, e, w));
        }

        setMst(V);

        int cnt = 0, result = 0;
        while (cnt < V - 1) {
            Edge cur = pq.poll();

            if (union(cur.x, cur.y)) {
                cnt++;
                result += cur.w;
            }
        }

        System.out.println(result);
    }

    static void setMst(int N) {
        rank = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    static int find(int n) {
        if (parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX] += 1;
        }

        return true;
    }
}

class Edge implements Comparable<Edge> {
    int x, y, w;

    public Edge(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}