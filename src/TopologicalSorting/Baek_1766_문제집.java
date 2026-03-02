package TopologicalSorting;

import java.util.*;
import java.io.*;

public class Baek_1766_문제집 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            degree[e] += 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++){
            if (degree[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int n : graph.get(cur)) {
                degree[n] -= 1;
                if (degree[n] == 0) pq.offer(n);
            }
        }

        System.out.println(sb);
    }
}