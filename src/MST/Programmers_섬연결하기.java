package MST;

import java.util.*;

class Programmers_섬연결하기 {
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost; // 비용 기준 오름차순 정렬
        }
    }
    
    static int[] parent;
    static int[] rank;
    
    public int solution(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        for(int[] cost : costs){
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        Collections.sort(edges); // 비용 기준 정렬
        
        parent = new int[n];
        rank = new int[n];
        
        // 유니온 파인드 초기화
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        int mstCost = 0;
        int edgesUsed = 0;
        
        for (Edge edge : edges){
            if(union(edge.from, edge.to)){
                mstCost += edge.cost;
                edgesUsed++;
                
                if (edgesUsed == n - 1) break; // 모든 노드가 연결되면 종료
            }
        }
        
        return mstCost;
    }
    
    // 루트 노드 찾기 (경로 압축)
    static int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }
    
    // 두 노드를 같은 집합으로 합치기 (랭크 기반)
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB){
            // 랭크가 높은 트리에 낮은 트리를 합친다.
            if(rank[rootA] > rank[rootB]){
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]){
                parent[rootA] = rootB;
            } else { // 랭크가 같으면 하나를 루트로 만들고 랭크를 증가
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true; // 연결 성공
        }
        return false; // 이미 같은 집합이면 연결하지 않음
    }
}
