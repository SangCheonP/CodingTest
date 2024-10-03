package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N개의 숫자로 구분된 마을에 한 명씩
 * N명이 X번 마을에 모여 파티
 * M개의 단반향 도로
 * i번째 길을 지나는데 Ti
 *
 * 오고 가는데 최단
 * 단방향이기 때문에 오고 가는 길이 다를 수 O
 * N명의 학생 중에사 가장 오래걸린 학생은?
 *
 * 1 <= N <= 1,000
 * 1 <= M <= 10,000
 * 1 <= X <= N
 * 1 <= Ti <= 100
 */
public class Baek_1238_파티 {
    static int N, M, X;

    static class Node implements Comparable<Node>{
        int v, w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node other){
            return this.w - other.w;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1 ~ N번의 마을
        M = Integer.parseInt(st.nextToken()); // M개의 단방향 도로
        X = Integer.parseInt(st.nextToken()); // 모이는 마을

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();

        // 그래프와 역방향 그래프 초기화
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // 시작
            int end = Integer.parseInt(st.nextToken()); // 도착
            int weight = Integer.parseInt(st.nextToken()); // 가중치

            graph.get(start).add(new Node(end, weight));
            reverseGraph.get(end).add(new Node(start, weight)); // 도로 방향을 뒤집어 추가
        }

        // X번 마을에서 모든 마을로의 최단 거리 계산
        int[] distFromX = dijkstra(X, graph);

        // 모든 마을에서 X번 마을로의 최단 거리 계산 (반대 그래프 사용)
        int[] distToX = dijkstra(X, reverseGraph);

        int maxTime = 0;
        for(int i = 1; i <= N; i++){
            if(distFromX[i] == Integer.MAX_VALUE || distToX[i] == Integer.MAX_VALUE) continue;
            maxTime = Math.max(maxTime, distFromX[i] + distToX[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(int start, List<List<Node>> graph){
        int[] distance = new int[N + 1];

        // 모든 경로를 최대값으로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 시작점은 0으로 초기화
        distance[start] = 0;

        // 우선 큐를 만들고, 시작점 넣음
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            int curV = cur.v;
            int curW = cur.w;
            
            // 현재 노드의 가중치가 현재 노드의 최단 거리보다 크면 패스
            if(curW > distance[cur.v]) continue;

            for(Node neighbor : graph.get(curV)){
                int nextV = neighbor.v;
                int nextW = neighbor.w + curW;

                if(nextW < distance[nextV]){
                    distance[nextV] = nextW;
                    pq.offer(new Node(nextV, nextW));
                }
            }
        }

        return distance;
    }
}
