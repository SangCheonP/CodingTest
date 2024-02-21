package TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 2252 줄 세우기(골드3)
https://www.acmicpc.net/problem/2252
 */
public class Baek_2252_줄세우기 {
    public static int N, M;
    // 진입차수 배열
    public static int[] degree;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer>[] list;
        Queue<Integer> queue = new ArrayDeque<>();

        // N: 학생 수(1 ~ 32000) / M: 비교 수(1 ~ 100000)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 진입차수 배열
        degree = new int[N+1];
        visited = new boolean[N+1];
        // 인접 정점 리스트
        list = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // s의 인접 정점 e추가
            list[s].add(e);

            // 진입차수 1증가
            degree[e] += 1;
        }

        // 진입차수가 0이고, 방문하지 않은 것 큐에 넣음
        for (int i = 1; i <= N ; i++) {
            if(degree[i] == 0 && !visited[i]){
                visited[i] = true;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int i = list[cur].size() - 1; i >= 0; i--) {
                int node = list[cur].get(i);
                // 방문하지 않은 인접한 노드
                if(!visited[node]){
                    // degree 1 감소
                    degree[node] -= 1;
                    // degree가 0이면
                    if(degree[node] == 0) {
                        visited[node] = true;
                        queue.add(node);
                    }
                }
            }
        }

        System.out.println(sb);

    }
}
