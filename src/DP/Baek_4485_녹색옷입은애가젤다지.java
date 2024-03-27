package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baek_4485_녹색옷입은애가젤다지 {
    public static class Node implements Comparable<Node>{
        int w, i, j;

        public Node(int w, int i, int j){
            this.w = w;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while(N != 0){
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<Node> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 첫 값 저장
            pq.add(new Node(map[0][0], 0, 0));
            dist[0][0] = map[0][0];
            visited[0][0] = true;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                        int nw = cur.w + map[ni][nj];
                        // 다음 위치에 갈 수 있는 경우 중에 작은 값 저장
                        if (dist[ni][nj] > nw) {
                            dist[ni][nj] = nw;
                            pq.add(new Node(nw, ni, nj));
                        }
                    }
                }
            }

            System.out.println("Problem " + cnt++ + ": " + dist[N-1][N-1]);
            N = Integer.parseInt(br.readLine());
        }
    }
}
