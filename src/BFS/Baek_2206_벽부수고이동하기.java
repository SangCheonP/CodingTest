package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2206 골드3
 * https://www.acmicpc.net/problem/2206
 */
public class Baek_2206_벽부수고이동하기 {

    static int N, M, result = Integer.MAX_VALUE;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][][] visited;

    static class Point{
        int i, j;
        boolean crushed;

        Point(int i, int j, boolean crushed){
            this.i = i;
            this.j = j;
            this.crushed = crushed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 0: 이동 가능, 1: 벽
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        
        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();
            for(int j = 1; j < M+1; j++){
                map[i][j] = Integer.parseInt(String.valueOf(tmp[j-1]));
            }
        }

        Queue<Point> queue = new ArrayDeque<>();

        visited[1][1][0] = true;
        queue.offer(new Point(1, 1, false));

        int size = queue.size();
        int time = 1;
        boolean fin = false;

        while(!queue.isEmpty()){
            // 모든 곳을 돌아도 빠져나올 수 없을 때
            if(time > N*M){
                break;
            }

            while(--size >= 0){
                Point cur = queue.poll();
//                System.out.println("i: " + cur.i + ", j: " + cur.j + ", crushed: " + cur.crushed);

                // 목표지점에 도착하면
                if(cur.i == N && cur.j == M){
                    fin = true;
                    result = Math.min(result, time);
                }

                for(int d = 0; d < 4; d++) {
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    // 범위 안이면
                    if(0 < ni && ni < N+1 && 0 < nj && nj < M+1){
                        // 벽을 한번도 부수지 않았을 때
                        if(!cur.crushed){
                            // 다음 이동할 곳이 벽이 아니고 방문X
                            if(map[ni][nj] == 0 && !visited[ni][nj][0]){
                                // 벽이 아니므로 그냥 진행
                                visited[ni][nj][0] = true;
                                visited[ni][nj][1] = true;
                                queue.offer(new Point(ni, nj, false));
//                                System.out.println("ni: " + ni + ", nj: " + nj + ", crushed: " + cur.crushed);
                            } else if(map[ni][nj] == 1 && !visited[ni][nj][1]) { // 다음 이동할 곳이 벽이면
                                // 해당 벽을 부수고 진행
                                visited[ni][nj][1] = true;
                                queue.offer(new Point(ni, nj, true));
//                                System.out.println("ni: " + ni + ", nj: " + nj + ", crushed: " + cur.crushed);
                            }
                        }else{ // 벽을 부쉈을 때
                            if(map[ni][nj] == 0 && !visited[ni][nj][1]){
                                // 벽을 부수지 않고 진행
                                visited[ni][nj][1] = true;
                                queue.offer(new Point(ni, nj, true));
                                //System.out.println("ni: " + ni + ", nj: " + nj + ", crushed: " + cur.crushed);
                            }
                        }
                    }
                }
            }

            size = queue.size();
            time += 1;

//            System.out.println("size: " + size + ", time: " + time);
//            System.out.println("---------------");
        }

        if(fin){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }
}
