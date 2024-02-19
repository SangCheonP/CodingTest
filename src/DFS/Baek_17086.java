package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 17086 아기 상어 2 (실버2) - BFS
https://www.acmicpc.net/problem/17086
 */
public class Baek_17086 {
    public static int[] di = {-1, 1, 0, 0, -1, 1, 1, -1};
    public static int[] dj = {0, 0, -1, 1, 1, -1, 1, -1};
    public static int result;

    public static class Point{
        int i;
        int j;

        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> queue = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 아기 상어 = true
                if(st.nextToken().equals("1")){
                    map[i][j] = true;
                }
            }
        }

        result = 0;
        int tmp = 1, size = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안전 영역이면
                if(!map[i][j]){
                    visited = new boolean[N][M];
                    queue.offer(new Point(i, j));
                    // 방문
                    visited[i][j] = true;

                    tmp = 0;

                    while (!queue.isEmpty()){
                        tmp += 1;
                        size = queue.size();

                        while (--size >= 0){
                            Point cur = queue.poll();

                            for (int d = 0; d < 8; d++) {
                                int ni = cur.i + di[d];
                                int nj = cur.j + dj[d];

                                if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]){
                                    visited[ni][nj] = true;
                                    queue.offer(new Point(ni, nj));
                                    // 상어면
                                    if(map[ni][nj]){
                                        result = Math.max(result, tmp);
                                        size = -1;
                                        queue = new ArrayDeque<>();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        System.out.println(result);
    }
}
