package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 3109 빵집 (골드2)
https://www.acmicpc.net/problem/3109
 */
public class Baek_3109 {
    public static int R, C, result;
    public static char[][] map;
    public static int[] di = {-1, 0, 1};
    public static int[] dj = {1, 1, 1};
    // 마지막까지 가면
    public static boolean canFin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        // 최종 결과
        result = 0;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            canFin = false;
            dfs(i, 0);
        }

        System.out.println(result);
    }

    public static void dfs(int i, int j){
        // 해당 경로로 마지막까지 갔으면
        if (canFin)
            return;
        // 파이프 설치
        map[i][j] = 'o';

        for (int d = 0; d < 3; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < R && 0 <= nj && nj < C && map[ni][nj] == '.'){
                // 마지막에 도달하면
                if(nj == C - 1){
                    result += 1;
                    canFin = true;
                    map[ni][nj] = 'o';
                    return;
                }
                dfs(ni, nj);
            }
        }
    }
}

