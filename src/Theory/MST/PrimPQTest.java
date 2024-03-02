package Theory.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimPQTest {

    static class Vertex implements Comparable<Vertex>{
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        // 인접 행렬
        int[][] adjMatrix = new int[V][V];
        // 트리에 속한 정점인지 여부
        boolean[] visited = new boolean[V];
        // 비트리정점 기준으로 트리정점들과 연결했을 경우 최소 간선 비용
        int[] minEdge = new int[V];

        StringTokenizer st;

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>(); //-----------------------------------

        // 최소값 갱신을 위해 max로 초기화
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        // 임의의 시작점 0을 위해 처리
        minEdge[0] = 0;
        // 정점의 번호와 해당 정점으로 오는 가중치의 최솟값
        pq.offer(new Vertex(0, minEdge[0]));


        // MST 비용
        int result = 0;
        int c = 0;
        while (!pq.isEmpty()) {
            
            // step 1: 비트리 정점 중 최소간선비용 정점 찾기
            Vertex minVertex = pq.poll();

            if(visited[minVertex.no]) continue; // 이미 트리에 들어간 상태

            result += minVertex.weight; // 간선비용 누적
            visited[minVertex.no] = true; // 트리 정점에 포함
            if(++c == V) break;


            // step 2: 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려 최적 업데이트
            for (int i = 0; i < V; i++) {
                // 비트리 정점 + minVertex랑 인접 + 
                if(!visited[i] && adjMatrix[minVertex.no][i] != 0
                    && adjMatrix[minVertex.no][i] < minEdge[i]){
                    // 갱신
                    minEdge[i] = adjMatrix[minVertex.no][i];
                    pq.offer(new Vertex(i, minEdge[i]));
                }
            }
        }

        System.out.println(c == V ? result : -1);

    }


}
