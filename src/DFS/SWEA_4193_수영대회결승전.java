package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_4193_수영대회결승전 {
    public static int N, result;
    public static Point start, end;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static int[][] map;
    public static boolean[][] visited;
    public static Queue<Point> queue;

    public static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            result = -1;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1)
                        visited[i][j] = true;
                }
            }

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(start.i, start.j);

            // 골인지점 도착
            if(visited[end.i][end.j]){
                System.out.println("#"+tc + " " + result);
            // 골인지점 도착 못함
            }else{
                System.out.println("#"+tc + " " + (-1));
            }
        }
    }

    public static void bfs(int i, int j){
        queue = new ArrayDeque<>();

        queue.add(new Point(i, j));
        visited[i][j] = true;
        int size = queue.size();
        int time = 0;

        out:while (!queue.isEmpty()){
            while (--size >= 0){
                Point cur = queue.poll();

                // 골인지점이면
                if(cur.i == end.i && cur.j == end.j){
                    result = time;
                    break out;
                }

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                        // 바다
                        if(map[ni][nj] == 0){
                            visited[ni][nj] = true;
                            queue.add(new Point(ni, nj));
                        // 소용돌이
                        }else{
                            // 소용돌이가 없어지는 시간이면 소용돌이로 이동
                            if(time%3 == 2){
                                visited[ni][nj] = true;
                                queue.add(new Point(ni, nj));
                            // 그 자리에서 대기
                            }else{
                                queue.add(new Point(cur.i, cur.j));
                            }
                        }
                    }
                }
            }
            size = queue.size();
            time++;
        }
    }
}
