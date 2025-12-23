package PriorityQueue;

import java.util.*;

class Programmers_합승택시요금 {
    // 다익스트라 알고리즘에서 사용할 Node 클래스 (우선순위 큐 활용)
    static class Node implements Comparable<Node> {
        int idx, w; // idx: 노드 번호, w: 가중치(비용)
        
        Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.w - o.w; // 최소 힙(오름차순 정렬)
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 그래프를 인접 리스트(List<List<Node>>) 형태로 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 주어진 요금(fares) 정보를 그래프에 추가 (양방향 그래프)
        for (int[] fare : fares) {
            int i = fare[0]; // 출발 노드
            int j = fare[1]; // 도착 노드
            int w = fare[2]; // 이동 비용
            
            graph.get(i).add(new Node(j, w));
            graph.get(j).add(new Node(i, w));
        }
        
        // 다익스트라 실행하여 s, a, b에서 각각 모든 노드까지의 최단 거리 구하기
        int[] distS = dijkstra(s, graph, n); // 출발지 s에서 모든 노드까지 최단 거리
        int[] distA = dijkstra(a, graph, n); // 목적지 a에서 모든 노드까지 최단 거리
        int[] distB = dijkstra(b, graph, n); // 목적지 b에서 모든 노드까지 최단 거리
        
        // 최소 비용 계산
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) { // 모든 노드(i)를 합승 종료 지점으로 고려
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]); 
        }

        return answer;
    }
    
    // 다익스트라 알고리즘: 시작 노드에서 모든 노드까지 최단 거리 계산
    static int[] dijkstra(int start, List<List<Node>> graph, int n) {
        int[] dist = new int[n + 1]; // 최단 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 초기값을 무한대(INF)로 설정
        
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 최소 힙(우선순위 큐)
        pq.offer(new Node(start, 0)); // 시작 노드를 큐에 삽입 (가중치 0)
        dist[start] = 0; // 시작 노드의 최단 거리는 0
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 노드
            int curIdx = cur.idx;
            int curWeight = cur.w;
            
            // 현재 노드의 거리가 기존 기록된 거리보다 크다면 무시 (이미 처리된 노드)
            if (dist[curIdx] < curWeight) continue;
            
            // 현재 노드의 모든 인접 노드 탐색
            for (Node neighbor : graph.get(curIdx)) {
                int nextIdx = neighbor.idx;
                int nextWeight = curWeight + neighbor.w; // 누적 비용 계산
                
                // 더 짧은 거리라면 업데이트 및 큐에 추가
                if (nextWeight < dist[nextIdx]) {
                    dist[nextIdx] = nextWeight;
                    pq.offer(new Node(nextIdx, nextWeight));
                }
            }
        }
        
        return dist; // 최단 거리 배열 반환
    }
}
