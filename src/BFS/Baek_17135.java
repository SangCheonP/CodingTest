package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 17135 캐슬 디펜스 (골드3) - 조합, BFS
https://www.acmicpc.net/problem/17135
 */
public class Baek_17135 {
    public static int N, M, D, result;
    public static boolean[][] map;
    public static int[] di = {0, -1, 0};
    public static int[] dj = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 행 / M: 열 / D: 공격 거리 제한(D이하)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    map[i][j] = true;
            }
        }
        result = 0;
        comb(0, 0);
        System.out.println(result);
    }

    public static void comb(int idx, int cnt){
        if(cnt == 3){
            int tmp = 0;
            boolean[][] cp = new boolean[N+1][M];
            for (int i = 0; i < N+1; i++) {
                for (int j = 0; j < M; j++) {
                    cp[i][j] = map[i][j];
                }
            }

            // N번 이동
            for (int i = 0; i < N; i++) {
                // 공격
                tmp += att(cp);
                // 한칸 이동
                move(cp);
            }

            result = Math.max(result, tmp);
            return;
        }
        if(idx == M){
            return;
        }

        map[N][idx] = true;
        comb(idx+1, cnt+1);
        map[N][idx] = false;
        comb(idx+1, cnt);

    }

    public static class Point {
        int i;
        int j;
        // 궁수로부터 거리(공격 가능한 거리 안인지)
        int dis;
        // 적이 있는 지 없는지
        boolean stats;


        public Point(int i, int j, boolean stats, int dis){
            this.i = i;
            this.j = j;
            this.stats = stats;
            this.dis = dis;
        }
    }

    // 공격
    public static int att(boolean[][] cp){
        boolean[][] selectEm = new boolean[N][M];
        int dis = 0;
        Queue<Point> queue;
        int tmp = 0;
        // 궁수 3명이 한 턴에 잡을 수 있는 적의 수 리턴
        for (int j = 0; j < M; j++) {
            // 궁수가 서 있으면
            if(cp[N][j] == true){

                // 공격 거리 D까지 BFS 진행
                queue = new ArrayDeque<>();
                dis = 1;

                queue.offer(new Point(N-1, j, cp[N-1][j], dis));

                while (!queue.isEmpty()){
                    Point cur = queue.poll();

                    // 적이 있고, 공격 사거리 안이면
                    if(cur.stats && cur.dis <= D){
                        // 해당 적이 선택이 안 되었을 때
                        if(!selectEm[cur.i][cur.j]) {
                            // 해당 적 표시
                            selectEm[cur.i][cur.j] = true;
                            tmp += 1;
                        }
                        break;
                    }

                    // 3방향 동안
                    for (int d = 0; d < 3; d++) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];

                        if(0 <= ni && ni < N && 0 <= nj && nj < M && cur.dis+1 <= D){
                            queue.offer(new Point(ni, nj, cp[ni][nj], cur.dis+1));
                        }
                    }
                }
            }
        }

        // 선택한 적 cp에 업데이트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(selectEm[i][j])
                    cp[i][j] = false;
            }
        }
        return tmp;
    }

    // 적들 아래로 한 칸 이동
    public static void move(boolean[][] cp){
        for (int i = N-1; i >= 1 ; i--) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = cp[i-1][j];
            }
        }
        for (int j = 0; j < M; j++) {
            cp[0][j] = false;
        }
    }
}
