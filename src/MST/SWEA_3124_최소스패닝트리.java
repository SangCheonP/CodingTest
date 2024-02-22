package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
SWEA 3124 최소 스패닝 트리
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
 */
public class SWEA_3124_최소스패닝트리 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int c;
        Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.c, o.c);
        }
    }

    public static Edge[] edges;
    public static int[] parent;
    public static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            // V: 정점의 개수 / E: 간선의 개수
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edges = new Edge[V];

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                // A, B: 두 정점 / C: 가중치
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                edges[e] = new Edge(A, B, C);
            }

            // 1 ~ V까지 부모 저장 배열
            makeSet();

            Arrays.sort(edges);

            int cnt = 0, weight = 0;

            for (Edge e: edges) {
                // a와 b가 다른 집합이면
                if(find_res(e.a) != find_res(e.b)){
                    weight += e.c;
                    cnt += 1;
                    
                    // 두 집합 합침
                    union(e.a, e.b);
                    
                    if(cnt == V-1)
                        break;
                }
            }
            System.out.println("#" + tc + " " + weight);
        }
    }

    static void makeSet(){
        parent = new int[V+1];
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }
    }

    static int find_res(int x){
        if(x != parent[x]){
            return parent[x] = find_res(parent[x]);
        }
        return x;
    }

    static boolean union(int x, int y){
        int x_res = find_res(x);
        int y_res = find_res(y);

        // 같은 집합이면
        if(x_res == y_res)
            return false;

        parent[y_res] = x_res;

        return true;
    }
}
