package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 16234 인구 이동(골드4) - BFS
https://www.acmicpc.net/problem/16234
 */
public class Baek_16234_인구이동 {
    static int N, L, R, day = 0;
    static int[][] pMap;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Queue<Point> queue;
    static List<Point> unionCityes;
    static boolean[][] visited;
    static boolean canMove = false;

    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        pMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            pMap[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        move();

        System.out.println(day);

    }

    static void move(){
        // 이동이 가능하면
        while (true){
            // 이동이 시작 전에 모두 초기화
            canMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문 안 했으면
                    if(!visited[i][j]){
                        bfs(i, j);
                    }
                }
            }

            // 이동이 없으면 종료
            if(!canMove)
                break;
            else day+=1;
        }
    }

    static void bfs(int i, int j){
        unionCityes = new ArrayList<>();
        queue = new ArrayDeque<>();

        // 방문처리
        visited[i][j] = true;
        queue.add(new Point(i, j));
        unionCityes.add(new Point(i, j));

        while (!queue.isEmpty()){
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                // 범위 안 + 방문X
                if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                    int diff = Math.abs(pMap[cur.i][cur.j] - pMap[ni][nj]);
                    // L <= diff <= R이면
                    if(L <= diff && diff <= R){
                        // 이동할 수 있다 표시하고, 방문 처리
                        canMove = true;
                        visited[ni][nj] = true;
                        queue.add(new Point(ni, nj));
                        unionCityes.add(new Point(ni, nj));
                    }
                }

            }
        }

        // 자기를 말고 다른 연합이 있으면 bfs 결과 pMap에 적용
        if(unionCityes.size() > 1){
            int sumP = 0;
            for (Point p: unionCityes){
                sumP += pMap[p.i][p.j];
            }

            for (Point p: unionCityes){
                pMap[p.i][p.j] = sumP/unionCityes.size();
            }
        }
    }
}
