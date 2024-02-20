package TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
백준 2252 줄 세우기(골드3)
https://www.acmicpc.net/problem/2252
 */
public class Baek_2252_줄세우기 {
    public static int N, M;
    public static int[] map;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        // N: 학생 수(1 ~ 32000) / M: 비교 수(1 ~ 100000)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // i: 1 ~ N까지 사용 / j: 0(앞), 1(뒤)
        map = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            map[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        for (int i = 1; i < N+1; i++) {
            if(!visited[i] && map[i] == 0){
                dfs(i);
            }
            sb2.append(sb.reverse());
            sb = new StringBuilder();
        }

        System.out.println(sb2.substring(1));
    }

    public static void dfs(int i){
        visited[i] = true;
        sb.append(i).append(" ");

        for (int j = 1; j < N+1; j++) {
            if(!visited[j] && map[j] == i){
                dfs(j);
            }
        }
    }
}
