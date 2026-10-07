import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        // 중복을 제거하고 숫자의 존재 여부를 빠르게 확인
        for (int num : nums) {
            set.add(num);
        }

        for (int n : set) {
            int cnt = 0;
            int cur = n;
            // 바로 앞 숫자가 없는 경우에만 연속 구간 탐색
            if (!set.contains(n - 1)) {
                while (set.contains(cur)) {
                    cur++;
                    cnt++;
                }

                result = Math.max(result, cnt);
            }
        }

        return result;
    }
}
