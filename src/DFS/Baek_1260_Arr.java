package DFS;
/*
백준 1260 (실버2) - 리스트로 구현
https://www.acmicpc.net/status?user_id=pswlove77&problem_id=1260&from_mine=1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1260_Arr {
    public static int N, M, V;
    public static int[][] vs;
    public static boolean[] isSelected;
    public static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 정점의 개수 / M: 간선의 개수 / V: 탐색 시작할 정점 번호
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        vs = new int[N+1][N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            vs[str][ed] = 1;
            vs[ed][str] = 1;
        }

        isSelected = new boolean[N + 1];
        dfs(V);
        System.out.println();

        isSelected = new boolean[N + 1];
        queue = new ArrayDeque<>();
        bfs(V);
        System.out.println();

    }

    public static void dfs(int v){
        if(isSelected[v])
            return;
        System.out.print(v + " ");
        isSelected[v] = true;
        for (int i = 1; i < N + 1; i++) {
            if(vs[v][i] == 1){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        // 해당 idx 방문했으면
        if(isSelected[v])
            return;
        queue.offer(V);
        // 방문표시
        isSelected[V] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int i = 0; i < vs[cur].length; i++) {
                if(vs[cur][i] == 1){
                    if(!isSelected[i]){
                        isSelected[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
