import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, cur, result);
        return result;
    }

    private void backtrack(int[] nums, int idx,
                           List<Integer> cur,
                           List<List<Integer>> result) {
        // 현재 부분집합을 복사하여 저장
        result.add(new ArrayList<>(cur));

        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]); // 이번 반복에서 선택한 원소 추가

            // 선택한 위치 다음부터 탐색하여 중복 선택 방지
            backtrack(nums, i + 1, cur, result);

            // 선택을 취소하고 다음 후보를 시도
            cur.remove(cur.size() - 1);
        }
    }
}
