package BFS;

import java.util.*;
import java.io.*;

public class Baek_2573_빙산 {
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, result = 0;
    static Queue<Node> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) queue.offer(new Node(i, j, map[i][j]));
            }
        }

        while (true) {
            int[][] copy = new int[N][M];
            int size = queue.size();
            while (--size >= 0) {
                Node cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 0) {
                        cur.w--;
                    }
                }

                if (cur.w > 0) {
                    copy[cur.i][cur.j] = cur.w;
                    queue.offer(new Node(cur.i, cur.j, cur.w));
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = copy[i][j];
                }
            }

            result++;
            visited = new boolean[N][M];

            if (queue.isEmpty()) {
                System.out.println(0);
                break;
            } else if (queue.size() != dfs(queue.peek().i, queue.peek().j, visited)) {
                System.out.println(result);
                break;
            }
        }
    }

    static int dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int total = 1;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && map[ni][nj] > 0) {
                total += dfs(ni, nj, visited);
            }
        }

        return total;
    }
}

class Node {
    int i, j, w;

    public Node(int i, int j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }
}
