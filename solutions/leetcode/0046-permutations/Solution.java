import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, result, visited, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> result,
                   boolean[] visited, List<Integer> cur) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            backtrack(nums, result, visited, cur);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}
