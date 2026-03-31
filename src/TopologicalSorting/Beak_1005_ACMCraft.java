package TopologicalSorting;

import java.util.*;
import java.io.*;

public class Beak_1005_ACMCraft {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] times = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] remain = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                remain[to] += 1;
            }

            int W = Integer.parseInt(br.readLine());

            int[] dp = new int[N + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                if (remain[i] == 0) {
                    q.offer(i);
                    dp[i] = times[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : graph.get(cur)) {
                    dp[next] = Math.max(dp[next], dp[cur] + times[next]);

                    remain[next] -= 1;

                    if (remain[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            System.out.println(dp[W]);
        }
    }
}
