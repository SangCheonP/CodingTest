package BFS;

import java.io.*;
import java.util.*;

public class Baek_2638_치즈 {
    static int N, M, chesses;
    static List<Point> outChesses;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] map;

    static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception{
        
        // 0: 공기
        // 1: 치즈
        // 4: 밖 공기
        // 9: 외각 치즈

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    chesses += 1;
            }
        }

        int time = 0;

        // 치즈가 없으면 종료
        while(chesses > 0){
            // 밖 공기 채우기
            checkOutAir();

            // 외각 치즈 체크
            boolean[][] visited = new boolean[N][M];
            outChesses = new LinkedList<>();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        checkOutChesses(i, j, visited);
                    }
                }
            }

            // 외각 치즈 제거
            chesses -= removeOutChesses();

            // 시간 증가
            time += 1;
        }

        System.out.println(time);
    }

    static void checkOutAir(){
        // BFS로 밖 공기 모두 체크
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        // 첫 시작 지점 넣어줌
        map[0][0] = 4;
        visited[0][0] = true;
        queue.offer(new Point(0, 0));

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int d = 0; d < 4; d++){
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj] && (map[ni][nj] == 0 || map[ni][nj] == 4)){
                    visited[ni][nj] = true;
                    map[ni][nj] = 4;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
    }

    static void checkOutChesses(int i, int j, boolean[][] visited){
        // 방문처리
        visited[i][j] = true;

        // 외각인지 체크
        int outCnt = 0;
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            // 주변이 외각 공기면
            if(map[ni][nj] == 4)
                outCnt += 1;
            // 주변 2곳 이상이 외각 공기랑 맞닿아있으면
            if(outCnt >= 2) {
                // 해당 치즈 외각 치즈로
                map[i][j] = 9;
                outChesses.add(new Point(i, j));
                break;
            }
        }

        // dfs
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            // 방문 안 한 치즈면 방문
            if(map[ni][nj] == 1 && !visited[ni][nj]){
                checkOutChesses(ni, nj, visited);
            }
        }
    }

    // 외각 치즈 제거
    static int removeOutChesses(){
        // 외각 치즈 밖 공기로 변경
        for(Point p : outChesses){
            map[p.i][p.j] = 4;
        }
        return outChesses.size();
    }
}