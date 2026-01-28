package Comb;

import java.util.*;
import java.io.*;

public class Baek_14889_스타트와링크 {
    static int N, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        comb(visited, 2, 1);

        System.out.println(result);
    }

    static void comb(boolean[] visited, int start, int cnt) {
        if (cnt == N / 2) {
            result = Math.min(result, calc(visited));
            return;
        }

        for (int i = start; i <= N; i++) {
            visited[i] = true;
            comb(visited, i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    static int calc(boolean[] visited) {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) { // j를 i+1부터 시작하여 중복 방지
                if (visited[i] && visited[j]) {
                    startTeamScore += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeamScore += map[i][j] + map[j][i];
                }
            }
        }
        return Math.abs(startTeamScore - linkTeamScore);
    }
}
