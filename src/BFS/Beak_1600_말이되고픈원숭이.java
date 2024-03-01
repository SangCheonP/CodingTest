package BFS;
/*
백준 1600 말이 되고픈 원숭이(골드3)
https://www.acmicpc.net/problem/1600
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_1600_말이되고픈원숭이 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static int[] si = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] sj = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Point{
        // k: 스킬 사용 횟수 / moveCnt: 움직인 횟수ㄴ 
        int i, j, k, moveCnt;
        Point(int i, int j, int k, int moveCnt){
            this.i = i;
            this.j = j;
            this.k = k;
            this.moveCnt = moveCnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 끝에 도달 할 수 있는지
        boolean canMake = false;

        // K: 능력 횟수
        int K = Integer.parseInt(br.readLine());
        
        // W: 가로 / H: 세로
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 0: 평지 / 1: 장애물
        int[][] map = new int[H][W];
        // visited[x][y][k] -> (x, y) 지점에 능력을 k번 사용해서 왔다
        boolean[][][] visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Point> queue = new ArrayDeque<>();

        // 처음 위치 큐에 넣음
        visited[0][0][0] = true;
        queue.add(new Point(0, 0, 0, 0));

        // BFS
        while (!queue.isEmpty()){
            Point cur = queue.poll();

            // 목표 지점에 도착하면
            if(cur.i == H-1 && cur.j == W-1){
                canMake = true;
                System.out.println(cur.moveCnt);
                break;
            }

            // 스킬 사용X
            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                // 범위 안 + 방문X + 장애물이 아니면
                if(0 <= ni && ni < H && 0 <= nj && nj < W && !visited[ni][nj][cur.k] && map[ni][nj] != 1){
                    visited[ni][nj][cur.k] = true;
                    queue.add(new Point(ni, nj, cur.k, cur.moveCnt + 1));
                }
            }

            // 스킬 사용O
            for (int d = 0; d < 8; d++) {
                int ni = cur.i + si[d];
                int nj = cur.j + sj[d];

                // 범위 안 + 스킬 횟수 제한 넘지X + 방문X + 장애물X
                if(0 <= ni && ni < H && 0 <= nj && nj < W && cur.k + 1 <= K && !visited[ni][nj][cur.k+1] && map[ni][nj] != 1){
                    visited[ni][nj][cur.k + 1] = true;
                    queue.add(new Point(ni, nj, cur.k + 1, cur.moveCnt + 1));
                }
            }
        }
        
        // 목표 지점에 도달할 수 없으면
        if(!canMake){
            System.out.println(-1);
        }
        
    }
}
