package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 7569 토마토 (골드5)
https://www.acmicpc.net/problem/7569
 */
public class Baek_7569 {
    public static int M, N, H;
    public static int[][][] map;
    public static int[] di = {0, 0, 0, 0, 1, -1};
    public static int[] dj = {1, -1, 0, 0, 0, 0};
    public static int[] dk = {0, 0, 1, -1, 0, 0};
    public static Queue<Point> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // M: 가로, N: 세로, H: 높이
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = bfs();

        System.out.println(result);
    }

    public static class Point{
        int i;
        int j;
        int k;

        public Point(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public static int bfs(){
        queue = new ArrayDeque<>();
        int day = 0, size = 0;
        boolean firstCheck = false;

        // 초기 익은 토마토 위치 넣기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] == 1) {
                        queue.offer(new Point(i, j, k));
                    }
                    // 익지 않은 토마토가 있으면 한번만 체크
                    if(firstCheck == false && map[i][j][k] == 0) {
                        firstCheck = !firstCheck;
                    }
                }
            }
        }

        // 모두 익은 상태로 입력이 들어오면
        if(!firstCheck)
            return 0;

        // bfs 진행
        while (!queue.isEmpty()){
            size = queue.size();

            while (--size >= 0){
                Point curPoint = queue.poll();

                for(int d = 0; d < 6; d++){
                    int ni = curPoint.i + di[d];
                    int nj = curPoint.j + dj[d];
                    int nk = curPoint.k + dk[d];

                    if(0 <= ni && ni < H && 0 <= nj && nj < N && 0 <= nk && nk < M && map[ni][nj][nk] == 0){
                        map[ni][nj][nk] = 1;
                        queue.offer(new Point(ni, nj, nk));
                    }
                }
            }
            // 큐가 비었으면 == 가능한 모든 토마토가 익음
            if(queue.isEmpty())
                break;
            day += 1;
        }

        // 토마토가 모두 익지 못하는 상황
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return day;
    }
}
