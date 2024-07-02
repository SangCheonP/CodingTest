package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_5427_불 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static class Point{
        int i, j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        // . 빈공간
        // # 벽
        // @ 시작 위치
        // * 불
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 0; t < TC; t++) {
            // w : 너비, h : 높이
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 시작 위치 좌표
            Point idx = new Point(-1, -1);

            // 지도 초기화
            char[][] map = new char[h][w];
            char[][] idx_map = new char[h][w];
            for (int i = 0; i < h; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    // 시작 위치면
                    if (tmp[j] == '@') {
                        idx.i = i;
                        idx.j = j;
                        idx_map[i][j] = tmp[j];
                        map[i][j] = '.';
                    } else {
                        map[i][j] = tmp[j];
                    }
                }
            }

            // 불 처음 위치 넣기
            Queue<Point> queue = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') {
                        queue.offer(new Point(i, j));
                    }
                }
            }

            // 시작 위치 넣기
            Queue<Point> idx_queue = new ArrayDeque<>();
            idx_queue.offer(new Point(idx.i, idx.j));

            int time = 0;
            int size = -1;
            int idx_size = -1;
            boolean fin = false;
            // 불 BFS 돌리기
            out: while (!idx_queue.isEmpty()) {
                time += 1;
                size = queue.size();
                while (--size >= 0) {
                    Point cur = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];
                        // 범위 안이면
                        if (0 <= ni && ni < h && 0 <= nj && nj < w) {
                            // 빈 공간이면
                            if (map[ni][nj] == '.') {
                                map[ni][nj] = '*';
                                queue.offer(new Point(ni, nj));
                            }
                        }
                    }
                }

                // 이동하기
                idx_size = idx_queue.size();
                while (--idx_size >= 0){
                    Point cur = idx_queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];

                        if (0 <= ni && ni < h && 0 <= nj && nj < w) {
                            if(map[ni][nj] == '.'){
                                idx_map[ni][nj] = '@';
                                idx_queue.offer(new Point(ni, nj));
                            }
                        // 밖에 도달시
                        }else{
                            System.out.println(time);
                            fin = true;
                            break out;
                        }
                        if(map[cur.i][cur.j] == '*'){
                            idx_map[cur.i][cur.j] = '.';
                        }
                    }
                }
            }
            if(!fin) System.out.println("IMPOSSIBLE");
        }
    }
}
