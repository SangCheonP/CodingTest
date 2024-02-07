package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
백준 2667 단지번호붙이기 (실버1) - DFS 버전
https://www.acmicpc.net/problem/2667
 */
public class Baek_2667_DFS {
    // 결과, 각 단지의 수를 잠시 저장할 변수
    public static int result, tmp, N;
    public static List<Integer> arr;
    public static int[][] map;
    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = 0; // 단지의 가지 수
        arr = new ArrayList<>(); // 각 단지의 개수를 저장할 리스트

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 방문하지 않은 단지가 있으면
                if(map[i][j] == 1){
                    ++result;
                    tmp = 0;
                    dfs(i, j);
                    arr.add(tmp);
                }
            }
        }

        System.out.println(result);
        Collections.sort(arr);
        for(int n : arr)
            System.out.println(n);
    }

    public static void dfs(int i, int j){
        // 방문표시
        map[i][j] = 2;
        // 해당 단지의 개수 증가
        tmp += 1;

        // 4방향 검사
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == 1){
                dfs(ni, nj);
            }
        }
    }
}
