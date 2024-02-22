package Theory.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Test {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int V, cnt, w;
    static Edge[] edgeList;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        cnt = 0;
        w = 0;

        // V: 정점의 개수
        V = Integer.parseInt(st.nextToken());
        
        // E: 간선의 개수
        int E = Integer.parseInt(st.nextToken());
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            // from: 시작 정점 / to: 끝 정점 / weight: 가중치
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            // 간선 리스트 생성
            edgeList[i] = new Edge(from, to, weight);
        }

        // 전처리: 간선 리스트 오름차순 정렬
        Arrays.sort(edgeList);

        // 1. make-set
        // 자신의 부모나 루트를 저장 (경로 압축으로 인해)
        make();

        for (Edge e: edgeList) {
            // 두 정점이 다른 집합이면(싸이클이 발생하지 않으면)
            if(find_res(e.from) != find_res(e.to)){
                union(e.from, e.to);
                cnt += 1;
                w += e.weight;
                
                // 정점의 개수 - 1 개의 간선을 찾았으면(최소 신장 트리)
                if(cnt == V-1){
                    break;
                }
            }
        }

        System.out.println(w);

    }

    private static void make() {
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    static int find_res(int x){
        if(parents[x] != x){
            parents[x] = find_res(parents[x]);
        }
        return x;
    }

    static boolean union(int x, int y){
        int x_res = find_res(x);
        int y_res = find_res(y);

        if (x_res == y_res)
            return false;

        parents[y_res] = x_res;
        return true;
    }
}
