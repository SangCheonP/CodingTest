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
        long a;
        long b;
        long c;
        Edge(long a, long b, long c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.c, o.c);
        }
    }

    public static Edge[] edges;
    public static long[] parent;
    public static long V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            // V: 정점의 개수 / E: 간선의 개수
            V = Long.parseLong(st.nextToken());
            E = Long.parseLong(st.nextToken());

            edges = new Edge[(int)E];

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                // A, B: 두 정점 / C: 가중치
                long A = Long.parseLong(st.nextToken());
                long B = Long.parseLong(st.nextToken());
                long C = Long.parseLong(st.nextToken());

                edges[e] = new Edge(A, B, C);
            }

            // 1 ~ V까지 부모 저장 배열
            makeSet();

            Arrays.sort(edges);

            long cnt = 0, weight = 0;

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
        parent = new long[(int)(V+1)];
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }
    }

    static long find_res(long x){
        if(x != parent[(int)x]){
            return parent[(int)x] = find_res(parent[(int)x]);
        }
        return x;
    }

    static boolean union(long x, long y){
        long x_res = find_res(x);
        long y_res = find_res(y);

        // 같은 집합이면
        if(x_res == y_res)
            return false;

        parent[(int)y_res] = x_res;

        return true;
    }
}
