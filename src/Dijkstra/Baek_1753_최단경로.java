package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1753_최단경로 {
    static class Node{
        int to, w;
        Node next;

        Node(int to, int w, Node next){
            this.to = to;
            this.w = w;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int INF = Integer.MAX_VALUE;

        // 정점: 1 ~ V
        // V: 정점의 개수 / E: 간선의 개수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 인접리스트
        Node[] adjList = new Node[V+1];
        // 해당 정점까지의 최단 거리
        int[] minDis = new int[V+1];
        boolean[] visited = new boolean[V+1];

        int str = Integer.parseInt(br.readLine());

        Arrays.fill(minDis, INF);

        // 시작 정점 초기화
        minDis[str] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, w, adjList[from]);
        }

        int cnt;
        for (cnt = 0; cnt < V; cnt++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            // 방문X + 가중치가 가장 작은 정점 선택
            for (int i = 1; i < V+1; i++) {
                if(!visited[i] && minDis[i] < min){
                    min = minDis[i];
                    minVertex = i;
                }
            }

            // 없으면
            if(minVertex == -1) break;
            visited[minVertex] = true;

            // 해당 정점을 경유지로 하는 다른 정점의 가중치들을 업데이트
            for (Node tmp = adjList[minVertex]; tmp != null; tmp = tmp.next) {
                if(!visited[tmp.to] && minDis[tmp.to] > + min + tmp.w){
                    minDis[tmp.to] = min + tmp.w;
                }
            }
        }

        for (int i = 1; i < V+1; i++) {
            if(minDis[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(minDis[i]);
            }
        }
    }
}
