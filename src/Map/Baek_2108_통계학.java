package Map;

import java.io.*;
import java.util.*;

/**
 * 시간 : 문제없음
 * 공간 : 문제없음
 * 예외 :
 */

public class Baek_2108_통계학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            nums[i] = n;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int maxK = 0, maxV = 0;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (maxV < e.getValue()) {
                maxK = e.getKey();
                maxV = e.getValue();
                list.clear();
                list.add(maxK);
            } else if (maxV == e.getValue()) {
                list.add(e.getKey());
            }
        }

        Arrays.sort(nums);
        Collections.sort(list);

        if(list.size() > 1) {
            maxK = list.get(1);
        } else {
            maxK = list.get(0);
        }

        long sum = 0;
        for (int n : nums) sum += n;

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double)sum / N)).append("\n")
          .append(nums[N/2]).append("\n")
          .append(maxK).append("\n")
          .append(nums[N - 1] - nums[0]).append("\n");

        System.out.println(sb);
    }
}