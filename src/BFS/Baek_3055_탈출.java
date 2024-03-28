package BFS;

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

        while(!canFin){
            // 물 찰곳 표시
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
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------");

            // 고슴도치 이동
            size = sQue.size();
            out:
            while(--size >= 0){
                Point cur = sQue.poll();

                for(int d = 0; d < 4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if(0 <= ni && ni < R && 0 <= nj && nj < C) {
                        if(map[ni][nj] == 'D'){
                            canFin = true;
                            result = cnt;
                            break out;
                        }
                        if(map[ni][nj] == '.'){
                            map[ni][nj] = 'S';
                            sQue.add(new Point(ni, nj));
                        }
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------");
            
            // 물 채우기
            size = wQue.size();

            while(--size >= 0){
                Point cur = wQue.poll();
                map[cur.i][cur.j] = '*';
                wQue.add(new Point(cur.i, cur.j));
            }



            cnt += 1;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------");
        }

    }
}
