package Theory.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

output: 10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 */
public class PrimTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        // 인접 행렬 가중치 저장 배열
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

        // 최소값 갱신을 위해 max로 초기화
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        // 임의의 시작점 0을 위해 처리
        minEdge[0] = 0;


        // MST 비용
        int result = 0;
        int c;

        for (c = 0; c < V; c++) {
            
            // step 1: 비트리 정점 중 최소간선비용 정점 찾기
            // 확장 포인트
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for (int i = 0; i < V; i++) {
                // 비트리 정점 + 최소 간선 비용
                if(!visited[i] && minEdge[i] < min){
                    min = minEdge[i];
                    minVertex = i;
                }
            }
            
            if(minVertex == -1) break; // 찾지 못했으면
            
            result += min; // 간선비용 누적
            visited[minVertex] = true; // 트리 정점에 포함


            // step 2: 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 업데이트
            for (int i = 0; i < V; i++) {
                // 비트리 정점 + minVertex(확장된 정점)과 인접(자기자신X) + 기존 정점에서 가는 가중치보다 작으면
                if(!visited[i] && adjMatrix[minVertex][i] != 0
                    && adjMatrix[minVertex][i] < minEdge[i]){
                    // 갱신
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }

        System.out.println(c == V ? result : -1);

    }


}
