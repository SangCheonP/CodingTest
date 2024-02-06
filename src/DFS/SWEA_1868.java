package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
SWEA 1868 파핑파핑 지뢰찾기 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc
 */
public class SWEA_1868 {
    public static int N, result;
    public static String[][] map;
    public static int[] di = {1, 1, 1, 0, 0, -1, -1, -1};
    public static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // 1 ~ 300
            N = Integer.parseInt(br.readLine());
            result = 0;

            map = new String[N][N];


            for(int i = 0; i < N; i++){
                map[i] = br.readLine().split("");
            }

            // O(N^2)
            // * 주위 1로
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j].equals("*")){
                        for(int d = 0; d < 8; d++){
                            int ni = i + di[d];
                            int nj = j + dj[d];

                            // 범위 안이면
                            if(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj].equals(".")){
                                map[ni][nj] = "1";
                            }
                        }
                    }
                }
            }


            // O(N^2)
            // .부분을 찾아 bfs
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j].equals(".")){
                        result += 1;
                        dfs(i, j);
                    }
                }
            }

            // O(N^2)
            // 남은 1인 것들을 셈
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j].equals("1")){
                        result += 1;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    // O(N)
    public static void dfs(int i, int j){
        // 방문했다 표시
        map[i][j] = "2";

        // 모든 방향
        for(int d = 0; d < 8; d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            // 범위 안이면
            if(0 <= ni && ni < N && 0 <= nj && nj < N){
                // 해당 위치로 이동해서 다시 bfs
                if(map[ni][nj].equals(".")){
                    dfs(ni, nj);
                    
                // 방문했다는 표시로 2설정
                } else if (map[ni][nj].equals("1")) {
                    map[ni][nj] = "2";
                }
            }
        }
    }
}
