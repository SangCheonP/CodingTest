package SlidingWindow;

import java.util.*;
import java.io.*;

public class Baek_110033_최솟값찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            nums[i] = cur;

            while (!dq.isEmpty() && nums[dq.peekLast()] >= cur) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (dq.peekFirst() <= i - L) {
                dq.pollFirst();
            }

            sb.append(nums[dq.peekFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}