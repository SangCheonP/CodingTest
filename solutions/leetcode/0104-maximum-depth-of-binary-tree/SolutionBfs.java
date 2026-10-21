import java.util.ArrayDeque;
import java.util.Queue;

// TreeNode는 LeetCode에서 제공하는 정의를 사용합니다.
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int deep = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 현재 레벨의 노드 수를 고정하여 다음 레벨과 구분
            int size = queue.size();
            deep++;

            for (int s = 0; s < size; s++) {
                TreeNode cur = queue.poll();

                // 존재하는 자식만 다음 레벨 후보로 등록
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }

        return deep;
    }
}
