package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_1916_최소비용구하기 {
    // Node 클래스 정의: 간선(edge)과 가중치(weight)를 포함하며, 우선순위 큐에서 사용하기 위해 Comparable 인터페이스를 구현합니다.
    static class Node implements Comparable<Node> {
        int edge, weight;

        Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }

        // 우선순위 큐에서 가중치 기준으로 정렬하기 위한 compareTo 메서드 오버라이딩
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 개수(N)와 버스의 개수(M) 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화 (각 도시를 노드로 표현)
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 버스 정보 입력 및 인접 리스트에 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 도시
            int end = Integer.parseInt(st.nextToken());   // 도착 도시
            int cost = Integer.parseInt(st.nextToken());  // 비용

            adj.get(start).add(new Node(end, cost));
        }

        // 출발 도시와 도착 도시 입력
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘을 위한 우선순위 큐와 거리 배열 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 모든 거리를 무한대로 초기화

        // 시작 도시 설정
        dist[startCity] = 0;
        pq.add(new Node(startCity, 0));

        // 다익스트라 알고리즘 실행
        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 노드 꺼내기

            // 이미 처리된 노드라면 무시
            if (dist[cur.edge] < cur.weight) {
                continue;
            }

            // 현재 노드와 연결된 모든 노드 탐색
            for (Node n : adj.get(cur.edge)) {
                int nextCost = cur.weight + n.weight; // 다음 노드까지의 비용 계산
                int nextEdge = n.edge;

                // 만약 계산된 비용이 기존 저장된 비용보다 적다면 갱신
                if (dist[nextEdge] > nextCost) {
                    dist[nextEdge] = nextCost;
                    pq.add(new Node(nextEdge, nextCost)); // 우선순위 큐에 추가
                }
            }
        }

        // 도착 도시까지의 최소 비용 출력
        System.out.println(dist[endCity]);
    }
}
