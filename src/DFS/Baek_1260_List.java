package DFS;
/*
백준 1260 (실버2) - 리스트로 구현
https://www.acmicpc.net/status?user_id=pswlove77&problem_id=1260&from_mine=1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1260_List {
    public static int N, M, V;
    public static List[] vs;
    public static boolean[] isSelected;
    public static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 정점의 개수 / M: 간선의 개수 / V: 탐색 시작할 정점 번호
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 시작점 리스트
        vs = new LinkedList[N+1];

        // 리스트 초기화
        for (int i = 1; i < N + 1; i++) {
            vs[i] = new LinkedList();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            vs[str].add(ed);
            vs[ed].add(str);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(vs[i]);
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
        isSelected[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < vs[v].size(); i++) {
            dfs((int)vs[v].get(i));
        }
    }

    public static void bfs(int v){
        isSelected[v] = true;
        queue.offer(v);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int i = 0; i < vs[cur].size(); i++) {
                if(!isSelected[(int) vs[cur].get(i)]){
                    isSelected[(int) vs[cur].get(i)] = true;
                    queue.offer((int) vs[cur].get(i));
                }
            }
        }
    }
}
