package BFS;

import java.util.*;
import java.io.*;

/**
 * 시간 : 방문 처리를 하므로 최대 N * M번이라 충분
 * 공간 : N * M 크기 2차원 배열 2개라서 문제없음
 * 예외 :
 */

public class Baek_2178_미로탐색 {
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] nums = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = nums[j] - '0';
            }
        }

        int result = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cur.i == N - 1 && cur.j == M - 1) {
                result = cur.w;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 0 || visited[ni][nj]) continue;

                pq.offer(new Point(ni, nj, cur.w + 1));
                visited[ni][nj] = true;
            }
        }

        System.out.println(result);
    }
}

class Point implements Comparable<Point> {
    int i, j, w;

    public Point(int i, int j, int w) {
        this.i = i;
        this.j = j;
        this.w = w;
    }

    @Override
    public int compareTo(Point o) {
        return this.w - o.w;
    }
}
