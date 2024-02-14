package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 14502 연구소 (골드4)
 */
public class Baek_14502 {
    public static int N, M, result;
    public static int[][] map;
    public static Queue<Point> queue;
    public static int[] di = {1, -1, 0 , 0};
    public static int[] dj = {0 , 0, 1, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // N: 세로, M: 가로
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        result = 0;

        // 벽 세우기 (3개 뽑는 조합)
        comb(0, 0);


        System.out.println(result);

    }

    public static void comb(int idx, int cnt){
        // 벽 3개를 세우면 bfs
        if(cnt == 3){
            // 해당 지도에 대해서 bfs 진행
            int tmp = bfs();

            result = Math.max(tmp, result);

            return;
        }

        for(int nm = idx; nm < N*M; nm++){
            int i = nm / M;
            int j = nm % M;

            if(0 <= i && i < N && 0 <= j && j < M && map[i][j] == 0){
                map[i][j] = 1;
                comb(nm + 1, cnt + 1);
                map[i][j] = 0;
            }
        }

    }

    public static class Point{
        int i;
        int j;

        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    // 안전영역 크기 반환
    public static int bfs(){
        queue = new ArrayDeque<>();
        int[][] cpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cpMap[i][j] = map[i][j];
            }
        }

        // 바이러스 시작 지점 넣음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(cpMap[i][j] == 2){
                    queue.offer(new Point(i, j));
                }
            }
        }

        // bfs 진행
        while (!queue.isEmpty()){
            Point nowPoint = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = nowPoint.i + di[d];
                int nj = nowPoint.j + dj[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < M && cpMap[ni][nj] == 0){
                    // 바이러스 표시
                    cpMap[ni][nj] = 2;
                    queue.offer(new Point(ni, nj));
                }
            }
        }

        // 안전영역 구함
        int tmp = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(cpMap[i][j] == 0){
                    tmp += 1;
                }
            }
        }

        return tmp;
    }
}
