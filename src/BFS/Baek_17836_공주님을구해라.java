package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 17836 공주님을 구해라!(골드5)
https://www.acmicpc.net/problem/17836
 */
public class Baek_17836_공주님을구해라 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static class Point{
        int i, j;
        boolean haveSword;
        Point(int i, int j, boolean haveSword){
            this.i = i;
            this.j = j;
            this.haveSword = haveSword;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 세로 / M: 가로 / T: 제한 시간
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        // 마지막[] 0 -> 검 없을 때 방문 / 1 -> 검 가질 때 방문 체크
        boolean[][][] visited = new boolean[N][M][2];

        // 0: 빈 공간 / 1: 벽 / 2: 그람
        // 0,0 시작 위치 / N-1, M-1 공주 위치
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Point> queue = new ArrayDeque<>();

        visited[0][0][0] = true;
        queue.add(new Point(0, 0, false));

        int time = 0, size;
        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            size = queue.size();
            while (--size >= 0){
                Point cur = queue.poll();

                if(cur.i == N-1 && cur.j == M-1){
                    result = time;
                    queue.clear();
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    // 범위 안
                    if(0 <= ni && ni < N && 0 <= nj && nj < M){
                        // 검을 가지고 있으면
                        if(cur.haveSword){
                            // 방문 X
                            if(!visited[ni][nj][1]){
                                visited[ni][nj][1] = true;
                                queue.add(new Point(ni, nj, true));
                            }
                        }else {
                            // 방문 X + 벽 X
                            if(!visited[ni][nj][0] && map[ni][nj] != 1){
                                // 다음 칸이 검이면
                                if(map[ni][nj] == 2){
                                    visited[ni][nj][1] = true;
                                    queue.add(new Point(ni, nj, true));
                                }else{
                                    visited[ni][nj][0] = true;
                                    queue.add(new Point(ni, nj, false));
                                }
                            }
                        }
                    }
                }
            }
            time += 1;
        }

        if (result <= T){
            System.out.println(result);
        }else {
            System.out.println("Fail");
        }
        
    }
}

