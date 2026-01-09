package BFS;

import java.util.*;
import java.io.*;

/**
 * 시간 : N * M = 1,000,000 충분
 * 공간 : 2차원 배열과 큐 충분
 * 예외 :
 */

public class Baek_7576_토마토 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int total = 0, fin = 0, result = -1;

        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if (n == -1) continue;
                if (n == 1) {
                    queue.offer(new Tomato(i, j, 0));
                    fin++;
                }
                total++;
            }
        }

        if(fin == total) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()) {
            Tomato cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == -1 || map[ni][nj] == 1) continue;

                queue.offer(new Tomato(ni, nj, cur.d + 1));
                map[ni][nj] = 1;
                fin++;

                if (fin == total) {
                    result = cur.d + 1;
                    queue.clear();
                    break;
                }
            }
        }

        System.out.println(result);
    }
}

class Tomato {
    int i, j, d;

    public Tomato(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }
}
