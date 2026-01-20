package Imple;

import java.util.*;
import java.io.*;

public class Baek_14502_연구소 {
    static int result, N, M, totalBlanks;
    static int[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        List<Point> blanks = new ArrayList<>();
        List<Point> virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 0: 빈 칸, 1: 벽, 2: 바이러스
                if (map[i][j] == 0) {
                    blanks.add(new Point(i, j));
                    totalBlanks++;
                } else if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        result = Integer.MIN_VALUE;

        comb(blanks, virus, new ArrayList<>(), 0);

        System.out.println(result);
    }

    static void comb(List<Point> blanks, List<Point> virus, List<Point> complete, int start) {
        if (complete.size() == 3) {
            int[][] map2 = new int[N][M];
            for (int i = 0; i < N; i++) map2[i] = map[i].clone();

            int currentSafe = totalBlanks - 3;

            for (Point p : complete) {
                map2[p.i][p.j] = 1;
            }

            Queue<Point> queue = new LinkedList<>(virus);

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= M || map2[ni][nj] == 1 || map2[ni][nj] == 2) continue;

                    queue.offer(new Point(ni, nj));
                    map2[ni][nj] = 2;
                    currentSafe--;

                    if (currentSafe == 0) break;
                }
            }

            result = Math.max(result, currentSafe);

            return;
        }

        for (int i = start; i < blanks.size(); i++) {
            complete.add(blanks.get(i));
            comb(blanks, virus, complete, i + 1);
            complete.remove(complete.size() - 1);
        }
    }
}

class Point {
    int i, j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
