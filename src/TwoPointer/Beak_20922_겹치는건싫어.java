package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak_20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;

        while (right < N) {
            int current = nums[right];
            map.put(current, map.getOrDefault(current, 0) + 1);

            // 현재 수의 개수가 K를 초과하면 left를 이동시켜 중복을 없앰
            while (map.get(current) > K) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            // 최대 길이 갱신
            result = Math.max(result, right - left + 1);
            right++;
        }

        System.out.println(result);
    }
}
