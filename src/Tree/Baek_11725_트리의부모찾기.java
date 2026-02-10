package Tree;

import java.util.*;
import java.io.*;

public class Baek_11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        dfs(1, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int p, boolean[] visited) {
        for (int n : graph.get(p)) {
            if (!visited[n]) {
                parent[n] = p;
                visited[n] = true;
                dfs(n, visited);
            }
        }
    }
}
