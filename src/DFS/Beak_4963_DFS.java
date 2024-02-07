package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 4963 섬의 개수 (실버2) - DFS
https://www.acmicpc.net/problem/4963
 */
public class Beak_4963_DFS {
    // 섬 정보 저장 배열
    public static int[][] map;
    public static int w, h;
    public static int[] di = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int[] dj = {0, 0, 1, -1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];

            // 결과 저장 변수
            int result = 0;

            for(int i = 0; i < h; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 1){
                        result += 1;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void dfs(int i, int j){
        // 방문했다 표시
        map[i][j] = 2;

        // 8방향 동안
        for(int d = 0; d < 8; d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < h && 0 <= nj && nj < w && map[ni][nj] == 1){
                dfs(ni, nj);
            }
        }
    }
}
