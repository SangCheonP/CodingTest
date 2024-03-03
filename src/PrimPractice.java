import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
프림
MST 정점 중심
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

output==>10

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
public class PrimPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        int[][] adjMap = new int[V][V];
        int[] minDis = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            adjMap[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 해당 정점까지의 가는 가중치를 최대로 초기화
        for (int i = 0; i < V; i++) {
            minDis[i] = Integer.MAX_VALUE;
        }

        // 0을 시작 정점으로 설정
        minDis[0] = 0;

        int result = 0, cnt;

        for (cnt = 0; cnt < V; cnt++) {
            // 최솟값 찾음
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for (int i = 0; i < V; i++) {
                if(!visited[i] && minDis[i] < min){
                    min = minDis[i];
                    minVertex = i;
                }
            }
            
            // 찾을 수 없으면
            if(minVertex == -1) break;
            // 트리 정점에 추가
            visited[minVertex] = true;
            result += min;

            // 비트리 정점 + 인접 + 추가된 트리 정점에서 i까지 가중치가 기존 i까지 가중치보다 작으면
            for (int i = 0; i < V; i++) {
                if(!visited[i] && adjMap[minVertex][i] != 0 && adjMap[minVertex][i] < minDis[i]){
                    minDis[i] = adjMap[minVertex][i];
                }
            }
        }

        // MST의 가중치
        System.out.print(cnt == V ? result : -1);
    }
}
