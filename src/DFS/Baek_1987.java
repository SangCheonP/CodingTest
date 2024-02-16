package DFS;
/*
백준 1987 알파벳(골드4) - DFS, 가지치기, set
https://www.acmicpc.net/problem/1987
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_1987 {
    public static int R, C, result;
    public static char[][] map;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static Set<Character> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        // 지나온 알파벳 저장 집합
        set = new HashSet<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 시작점 추가
        set.add(map[0][0]);
        result = 0;
        dfs(0, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int i, int j, int cnt){
        result = Math.max(result, cnt);
        // 4방향
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            // 범위 안
            if (0 <= ni && ni < R && 0 <= nj && nj < C){
                // 새로운 알파벳이면
                if(!set.contains(map[ni][nj])){
                    // 집합에 넣고 dfs
                    set.add(map[ni][nj]);
                    dfs(ni, nj, cnt+1);
                }
            }
        }
        // 끝부분 도달시
        set.remove(map[i][j]);

    }
}
