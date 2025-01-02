import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // 다익스트라 알고리즘
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리 배열 초기화
        distance[1] = 0; // 시작 노드 거리 0
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0}); // {노드, 거리}
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distance[node]) continue; // 이미 처리된 노드 무시

            for (int neighbor : graph.get(node)) {
                int newDist = dist + 1; // 모든 간선의 가중치가 1
                if (newDist < distance[neighbor]) {
                    distance[neighbor] = newDist;
                    pq.add(new int[]{neighbor, newDist});
                }
            }
        }

        // 가장 먼 거리와 노드 개수 계산
        int maxDistance = Arrays.stream(distance, 1, n+1).max().getAsInt();
        
        System.out.println(maxDistance);
        
        int count = (int) Arrays.stream(distance, 1, n+1).filter(d -> d == maxDistance).count();

        return count;
    }
}
