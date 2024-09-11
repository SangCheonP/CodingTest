package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_5972_택배배송 {
    static class Node implements Comparable<Node>{
        int targetNode, cost;
        public Node(int targetNode, int cost){
            this.targetNode = targetNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost; // 비용이 적은 순서로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 헛간의 개수
        // M: 길의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int INF = Integer.MAX_VALUE;

        // 1 ~ N까지 사용
        ArrayList<Node>[] graph = new ArrayList[N+1];
        int[] dist = new int[N+1]; // 최소 비용을 저장할 배열

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF; // 초기 비용은 무한대로 설정
        }
        
        // 연결된 경로 표시
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 다익스트라 알고리즘 수행
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0; // 시작점 1번 헛간 비용은 0
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            int currentNode = cur.targetNode;
            int currentCost = cur.cost;
            
            // 현재 비용이 이미 기록된 최소 비용보다 크면 스킵
            if(dist[currentNode] < currentCost) continue;

            // 인접 노드 확인
            for(Node next : graph[currentNode]){
                int nextNode = next.targetNode;
                int newCost = currentCost + next.cost; // 현재 노드까지의 비용을 더함
                
                // 더 적은 비용으로 도달할 수 있는 경우 업데이트
                if(dist[nextNode] > newCost){
                    dist[nextNode] = newCost;
                    pq.offer(new Node(nextNode, newCost));
                }
            }
        }

        // 최종 목적지 N번 헛간까지의 최소 비용 출력
        System.out.println(dist[N]);
    }
}
