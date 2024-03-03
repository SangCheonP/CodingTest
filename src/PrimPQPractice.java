import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
프림 - PQ 버전
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

public class PrimPQPractice {
    static class Point implements Comparable<Point>{
        int to, w;
        Point(int to, int w){
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Point o){
            return Integer.compare(this.w, o.w);
        }
    }
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


        // 해당 정점까지 가중치 최대 값으로 초기화
        for (int i = 0; i < V; i++) {
            minDis[i] = Integer.MAX_VALUE;
        }

        // 시작 정점 0으로 설정
        minDis[0] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        int cnt = 0, result = 0;

        // 정점 0번, 가중치 0
        pq.offer(new Point(0, 0));

        while (!pq.isEmpty()){
            Point cur = pq.poll();

            // 이미 트리에 들어간 정점이면
            if(visited[cur.to])
                continue;

            // 방문처리
            visited[cur.to] = true;
            result += cur.w;
            if(++cnt == V){
                break;
            }

            // 새로 추가된 트리 정점을 기준으로 비트리 정점들과의 간선비용비교하며 더 작은 것이 있으면 업데이트
            for (int i = 0; i < V; i++) {
                if(!visited[i] && adjMap[cur.to][i] != 0 && adjMap[cur.to][i] < minDis[i]){
                    minDis[i] = adjMap[cur.to][i];
                    pq.offer(new Point(i, minDis[i]));
                }
            }
        }

        System.out.println(cnt == V ? result : -1);
    }
}
