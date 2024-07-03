package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_5427_불 {
    static int h, w;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static char[][] map;
    static Queue<Point> fire_queue, user_queue;

    static class Point{
        int i, j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void bfsFire(){
        int size = fire_queue.size();

        while (--size >= 0){
            Point cur = fire_queue.poll();

            for (int d = 0; d < 4; d++){
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni >= 0 && ni < h && nj >= 0 && nj < w){
                    // 다음 칸이 빈 공간이면 불이 퍼짐
                    if(map[ni][nj] == '.'){
                        fire_queue.add(new Point(ni, nj));
                        map[ni][nj] = '*';
                    }
                }
            }
        }
        //System.out.println("fire");
        //printMap(map);
    }

    public static boolean bfsUser(){
        int size = user_queue.size();

        while (--size >= 0){
            Point cur = user_queue.poll();

            for (int d = 0; d < 4; d++){
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                
                // 탈출하면
                if(ni < 0 || ni >= h || nj < 0 || nj >= w ){
                    //printMap(map);
                    return true;
                }else if(0 <= ni && ni < h && 0 <= nj && nj < w){
                    if(map[ni][nj] == '.'){
                        map[ni][nj] = '@';
                        user_queue.add(new Point(ni, nj));
                    }
                }
            }
        }
        //System.out.println("user");
       // printMap(map);
        return false;
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
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 큐 선언
            fire_queue = new ArrayDeque<>();
            user_queue = new ArrayDeque<>();

            // 지도 초기화
            map = new char[h][w];
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

            int result = 0;

            while (true){
                result += 1;
                if(user_queue.size() == 0){
                    System.out.println("IMPOSSIBLE");
                    break;
                }

                bfsFire();

                if(bfsUser()){
                    System.out.println(result);
                    break;
                }
                //System.out.println("-----------------------");
            }
        }
    }
}
