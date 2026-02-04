package TopologicalSorting;

import java.util.*;
import java.io.*;

public class Baek_2252_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] remain = new int[N];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            list.get(A).add(B);
            remain[B] += 1;
        }

        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (remain[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur + 1).append(" ");

            for (Integer n : list.get(cur)) {
                remain[n] -= 1;
                if (remain[n] == 0) pq.offer(n);
            }
        }

        System.out.println(sb);
    }
}
