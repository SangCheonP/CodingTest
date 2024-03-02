package Theory.Dijkstra;
/*
6 11
0 5
0 1 3
0 2 5
1 2 2
1 3 6
2 1 1
2 3 4
2 4 6
3 4 2
3 5 3
4 0 3
4 5 6

output==> 12
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 인접 리스트 버전
public class DijkstraTest {
    static class Node{
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next){
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        // V: 정점 개수 / E: 간선 개수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());

        // start: 시작점 인덱스 / ed: 도착점 인덱스
        int start = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        final int INF = Integer.MAX_VALUE;

        Node[] adjList = new Node[V];
        int[] minDistance = new int[V];
        boolean[] visited = new boolean[V];

        // 인접리스트 생성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, weight, adjList[from]);
        }

        // 가장 큰 값으로 초기화
        Arrays.fill(minDistance, INF);
        
        // 출발지도 하나의 경유처럼 처리
        // 출발지에서 출바지로의 비용 0으로 초기화
        minDistance[start] = 0;

        // 최솟값, 해당 idx 저장 변수
        int min = 0, stopOver = 0;
        // 모든 정점이 다 처리될때까지 반복
        for (int i = 0; i < V; i++) {
            
            // step1: 미방문 정점 중 출발지에서 가장 가까운 정점 선택
            min = INF;
            stopOver = -1;

            for (int j = 0; j < V; j++) {
                if(!visited[j] && min > minDistance[j]){
                    min = minDistance[j];
                    stopOver = j;
                }
            }

            if(stopOver == -1) break;
            visited[stopOver] = true;

            // step2: 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소 비용을 비교해서 업데이트
            for (Node tmp = adjList[stopOver]; tmp != null; tmp = tmp.next){
                if(!visited[tmp.vertex] && minDistance[tmp.vertex] > min + tmp.weight){
                    minDistance[tmp.vertex] = min + tmp.weight;
                }
            }
        }

        System.out.println(Arrays.toString(minDistance));
        System.out.println(minDistance[ed] != -1 ? minDistance[ed] : -1);
    }
}

