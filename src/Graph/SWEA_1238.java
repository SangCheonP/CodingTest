package Graph;
/*
SWEA 1238 Contact (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
    public static boolean[][] map;
    public static boolean[] visited;
    public static Queue<Integer> queue;
    public static int len, str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 1 ; tc++) {
            // len: 데이터의 길이 / str: 시작점
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            str = Integer.parseInt(st.nextToken());

            // 1~100 사용
            map = new boolean[101][101];
            visited = new boolean[101];

            st = new StringTokenizer(br.readLine());
            for (int l = 0; l < len/2; l++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = true;
            }

            queue = new ArrayDeque<>();
            bfs(str);

        }

    }

    public static class Point{
        int str;
        int ed;

        public Point(int str, int ed){
            this.str = str;
            this.ed = ed;
        }
    }

    public static void bfs(int str){
        if(visited[str]){
            return;
        }

        // 방문
        queue.offer(str);
        visited[str] = true;

        for (int i = 1; i <= 100 ; i++) {
            // str -> i로 갈 수 있으면
            if(map[str][i]){
                visited[i] = true;
                queue.offer(i);
            }
        }
    }
}
