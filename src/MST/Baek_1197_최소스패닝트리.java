package MST;

import java.util.*;
import java.io.*;

public class Baek_1197_최소스패닝트리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(A, B, C));
        }

        int result = 0, cnt = 0;
        Mst mst = new Mst(V);
        while (!pq.isEmpty()) {
            if (cnt == V - 1) break;

            Edge cur = pq.poll();

            if (mst.union(cur.A, cur.B)) {
                result += cur.C;
            }
        }

        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {
    int A, B, C;

    public Edge(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public int compareTo(Edge o) {
        return this.C - o.C;
    }
}

class Mst {
    int[] rank, parent;

    public Mst (int N) {
        rank = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find (int n) {
        if(parent[n] == n) return n;

        parent[n] = find(parent[n]);
        return parent[n];
    }

    boolean union (int x, int y) {
        int xP = find(x);
        int yP = find(y);

        if (xP == yP) return false;

        if (rank[xP] > rank[yP]) {
            parent[yP] = xP;
        } else if (rank[yP] > rank[xP]) {
            parent[xP] = yP;
        } else {
            parent[yP] = xP;
            rank[xP]++;
        }

        return true;
    }
}