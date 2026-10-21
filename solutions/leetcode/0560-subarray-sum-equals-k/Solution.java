import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 첫 원소부터 시작하는 구간을 세기 위한 초기 누적합
        map.put(0, 1);
        int sum = 0, result = 0;

        for (int num : nums) {
            sum += num;
            // 현재 위치에서 끝나며 합이 k인 구간의 개수
            result += map.getOrDefault(sum - k, 0);
            // 빈 구간을 세지 않도록 조회 후 현재 누적합을 저장
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
