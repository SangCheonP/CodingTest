package Dijkstra;

import java.util.*;

class Programmers_부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1]; 
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        // 최단 거리를 저장할 배열 생성
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // 우선순위 큐 (거리 기준 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        // 도착점을 출발점으로 생각 (역방향 다익스트라)
        distance[destination] = 0;
        pq.offer(new int[]{0, destination});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dist = curr[0];
            int node = curr[1];
            
            // 이미 처리된 노드라면 스킵
            if (dist > distance[node]) continue;

            for (int neighbor : graph.get(node)) {
                int nextWeight = dist + 1; // 모든 도로의 길이는 1
                
                if (nextWeight < distance[neighbor]) {
                    distance[neighbor] = nextWeight;
                    pq.offer(new int[]{nextWeight, neighbor});
                }
            }
        }
        
        // 결과 반환
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (distance[sources[i]] == Integer.MAX_VALUE) ? -1 : distance[sources[i]];
        }
        
        return answer;
    }
}
