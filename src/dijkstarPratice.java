import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dijkstarPratice {
    static class Node{
        int vertex, weight;
        Node next;
        Node(int vertex, int weight, Node next){
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = Integer.MAX_VALUE;

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] minDis = new int[V];
        boolean[] visited = new boolean[V];
        Node[] adjList = new Node[V];

        Arrays.fill(minDis, INF);

        st = new StringTokenizer(br.readLine());
        int str = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        minDis[str] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, weight, adjList[from]);
        }

        int min = Integer.MAX_VALUE, stopOver = -1;

        int cnt;

        for (cnt = 0; cnt < V; cnt++) {
            min = INF;
            stopOver = -1;

            for (int i = 0; i < V; i++) {
                if(!visited[i] && minDis[i] < min){
                    min = minDis[i];
                    stopOver = i;
                }
            }

            if(stopOver == -1) break;
            visited[stopOver] = true;

            for (Node tmp = adjList[stopOver]; tmp != null; tmp = tmp.next) {
                if(!visited[tmp.vertex] && minDis[tmp.vertex] > min + tmp.weight){
                    minDis[tmp.vertex] = min + tmp.weight;
                }
            }
        }

        System.out.println(Arrays.toString(minDis));
        System.out.println(minDis[ed] != INF ? minDis[ed] : -1);

    }
}
