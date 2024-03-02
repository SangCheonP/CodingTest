import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class primpractice{
    static class Point implements Comparable<Point>{
        int no, weight;
        Point(int no, int weight){
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V];
        int[] minDis = new int[V];
        int[][] adjMap = new int[V][V];

        for (int i = 0; i < V; i++) {
            minDis[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();

        // 시작 정점
        minDis[0] = 0;
        pq.offer(new Point(0, minDis[0]));

        for (int i = 0; i < V; i++) {
            adjMap[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // mst 결과, 정점의 개수
        int result = 0, cnt = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if(visited[cur.no]) continue;

            result += cur.weight;
            visited[cur.no] = true;
            if(++cnt == V) break;

            for (int i = 0; i < V; i++) {
                if(!visited[i] && adjMap[cur.no][i] != 0 && adjMap[cur.no][i] < minDis[i]){
                    minDis[i] = adjMap[cur.no][i];
                    pq.offer(new Point(i, minDis[i]));
                }
            }
        }

        if(cnt == V){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }
}
