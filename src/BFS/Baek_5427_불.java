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

            // 큐 선언
            Queue<Point> fire_queue = new ArrayDeque<>();
            Queue<Point> user_queue = new ArrayDeque<>();

            // 지도 초기화
            char[][] map = new char[h][w];
            for (int i = 0; i < h; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    map[i][j] = tmp[j];
                    // 시작 위치면
                    if (tmp[j] == '@') {
                        user_queue.offer(new Point(i, j));
                    } else if (tmp[j] == '*') {
                        fire_queue.offer(new Point(i, j));
                    }
                }
            }


        }
    }


}
