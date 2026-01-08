package DFS;

import java.util.*;
import java.io.*;

/**
 * 시간 : 방문 체크하므로 최대 100 이므로 문제없음
 * 공간 : 2중 리스트 쓰지만 쌍의 최대 개수는 명시가 안되어 있지만 128MB는 안 넘을 듯
 * 예외 :
 */

public class Baek_2606_바이러스 {
    static boolean[] visited;
    static List<List<Integer>> graph;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 방향이 없어서 둘 다 넣어줘야함
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        result = 0;
        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(result);
    }

    static void dfs(int start) {
        visited[start] = true;

        for(int n : graph.get(start)) {
            if(visited[n]) continue;
            result += 1;
            dfs(n);
        }
    }
}

