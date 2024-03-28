package BFS;

/**
 * 백준 3055 탈출(골드4)
 * https://www.acmicpc.net/problem/3055
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_3055_탈출 {
    public static int R, C;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static int result = 0;
    public static char[][] map;
    public static Queue<Point> wQue, sQue;
    public static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        wQue = new ArrayDeque<>();
        sQue = new ArrayDeque<>();

        map = new char[R][C];

        for(int i = 0; i < R; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                map[i][j] = tmp[j];
                if(tmp[j] == '*'){
                    wQue.add(new Point(i, j));
                }else if(tmp[j] == 'S'){
                    sQue.add(new Point(i, j));
                }
            }
        }

        bfs();

        if(result == 0){
            System.out.println("KAKTUS");
        }else{
            System.out.println(result);
        }
    }

    public static void bfs(){
        boolean canFin = false;
        int cnt = 0;

        while(true){
            // 물 채우기
            int size = wQue.size();

            while(--size >= 0){
                Point cur = wQue.poll();

                for(int d = 0; d < 4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if(0 <= ni && ni < R && 0 <= nj && nj < C && (map[ni][nj] == '.' || map[ni][nj] == 'S')){
                        map[ni][nj] = '#';
                        wQue.add(new Point(ni, nj));
                    }
                }
            }

            // 고슴도치 이동
            size = sQue.size();
            
            // 움직일 수 없으면
            if(size == 0){
                break;
            }
            
            out:
            while(--size >= 0){
                Point cur = sQue.poll();

                for(int d = 0; d < 4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if(0 <= ni && ni < R && 0 <= nj && nj < C) {
                        // 도착
                        if(map[ni][nj] == 'D'){
                            canFin = true;
                            result = cnt;
                            break out;
                        }
                        // 땅이면
                        if(map[ni][nj] == '.'){
                            map[ni][nj] = 'S';
                            sQue.add(new Point(ni, nj));
                        }
                    }
                }
            }

            cnt += 1;

            if(canFin){
                result = cnt;
                return;
            }
        }

    }
}
