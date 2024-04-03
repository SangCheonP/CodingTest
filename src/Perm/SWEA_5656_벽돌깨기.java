package Perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5656_벽돌깨기 {
    public static int N, W, H, result;
    public static Stack<Integer> stack = new Stack<>();
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static class Point{
        int i, j, cnt;
        Point(int i, int j, int cnt){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;

            shoot(0, map);

            System.out.println("#" + tc + " " + result);
        }
    }

    public static boolean shoot(int cnt, int[][] map){
        // 다 깨졌는지 리턴
        int remainCnt = getRemain(map);
        if(remainCnt == 0){
            result = 0;
            return true;
        }

        if (cnt == N){
            result = Math.min(result, remainCnt);
            return false;
        }

        // 열을 선택
        int[][] newMap = new int[H][W];
        for (int j = 0; j < W; j++) {
            // 해당 열에서 블록을 만날 때 까지
            int i = 0;
            while(i < H && map[i][j] == 0){
                ++i;
            }
            
            // 맞은 벽돌이 없음
            if(i == H) continue;

            copy(map, newMap);

            // 해당 블록 수
            int brick = newMap[i][j];

            // 연쇄 작용
            boom(i, j, newMap);

            if(brick > 1) {
                // 중력처리
                down(newMap);
            }

            // 다음 공 던지기
            if(shoot(cnt+1, newMap)){
                return true;
            }
        }
        return false;
    }
    
    public static void boom(int i, int j, int[][] map){
        Queue<Point> queue = new ArrayDeque<>();

        if(map[i][j] > 1) {
            queue.offer(new Point(i, j, map[i][j]));
        }
        // 방문 처리
        map[i][j] = 0;

        while (!queue.isEmpty()){
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = cur.i;
                int nj = cur.j;
                for (int k = 1; k < cur.cnt; k++) {
                    ni += di[d];
                    nj += dj[d];
                    if(0 <= ni && ni < H && 0 <= nj && nj < W && map[ni][nj] > 0) {
                        if(map[ni][nj] > 1){
                            queue.offer(new Point(ni, nj, map[ni][nj]));
                        }
                        map[ni][nj] = 0;
                    }
                }
            }
        }
    }
    public static void down(int[][] map){
        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                if(map[i][j] == 0) continue;
                stack.push(map[i][j]);
                map[i][j] = 0;
            }
            int i = H - 1;
            while(!stack.isEmpty()){
                map[i--][j] = stack.pop();
            }
        }
    }

    public static int getRemain(int[][] map){
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] > 0) cnt+=1;
            }
        }

        return cnt;
    }

    public static void copy(int[][] map, int[][] newMap){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }
}



