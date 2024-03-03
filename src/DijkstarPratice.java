import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
다익스트라
그래프에서 최단 경로(양의 가중치)
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


6 11
5 4
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


output==> -1


10 17
0 9
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==>21
 */
public class DijkstarPratice {
    static final int INF = Integer.MAX_VALUE;
    static class Node{
        int to, w;
        Node next;

        Node(int to, int w, Node next){
            this.to = to;
            this.w = w;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", w=" + w +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // V: 정점의 개수 / E: 간선의 개수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Node[] adjMap = new Node[V];
        int[] minDis = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(minDis, INF);

        // str: 시작 정점 / ed: 도착 정점
        st = new StringTokenizer(br.readLine());
        int str = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        minDis[str] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjMap[from] = new Node(to, w, adjMap[from]);
        }

        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 0; j < V; j++) {
                if(!visited[j] &&  minDis[j] < min ){
                    min = minDis[j];
                    minVertex = j;
                }
            }

            if(minVertex == -1) break;
            visited[minVertex] = true;

            for (Node tmp = adjMap[minVertex]; tmp != null; tmp = tmp.next) {
                if(!visited[tmp.to] && min + tmp.w < minDis[tmp.to] ){
                    minDis[tmp.to] = min + tmp.w;
                }
            }
        }

        System.out.println(Arrays.toString(minDis));
        System.out.println(minDis[ed] != -1 ? minDis[ed] : -1);
    }

}
