package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
SWEA 2117 홀방범서비스
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
 */
public class SWEA_2117_홀방범서비스 {
    public static int N, M, result;
    public static boolean[][] map, visited;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> queue;

        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= TC; tc++) {
            result = 0;

            // N: 도시의 크기 / M: 하나의 집이 지불할 수 있는 비용
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    char c = st.nextToken().charAt(0);
                    if(c == '1') {
                        map[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];

                    // size: 큐 사이즈 / K: 영역의 면적 / home: 집의 수 / benefit: 이익
                    int size = 1, K = 0, home = 0, benefit = 0;
                    queue = new ArrayDeque<>();
                    visited[i][j] = true;

                    // 해당 위치에 집이 있으면
                    if(map[i][j])
                        home = 1;
                    queue.offer(new Point(i, j));

                    while (!queue.isEmpty()){
                        // 영역 늘림
                        K += 1;
                        // 이익 계산
                        benefit = (M*home) - ((K*K) + ((K-1)*(K-1)));
                        // 손해를 안 보면 result 초기화
                        if(benefit >= 0)
                            result = Math.max(result, home);

                        // bfs
                        while (--size >= 0){
                            Point cur = queue.poll();

                            for (int d = 0; d < 4; d++) {
                                int ni = cur.i + di[d];
                                int nj = cur.j + dj[d];

                                // 범위 안이고, 방문하지 않았으면
                                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                                    // 집이면
                                    if(map[ni][nj])
                                        home += 1;
                                    visited[ni][nj] = true;
                                    queue.add(new Point(ni, nj));
                                }
                            }
                        }
                        size = queue.size();
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
