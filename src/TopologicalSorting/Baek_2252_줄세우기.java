package TopologicalSorting;

import java.util.*;
import java.io.*;

public class Baek_2252_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] remain = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            remain[e] += 1;
        }

        for (int i = 1; i <= N; i++) {
            if (remain[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int n : graph.get(cur)) {
                remain[n] -= 1;

                if (remain[n] == 0) queue.offer(n);
            }
        }

        System.out.println(sb);
    }
}
