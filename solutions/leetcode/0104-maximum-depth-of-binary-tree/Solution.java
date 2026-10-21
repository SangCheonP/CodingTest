// TreeNode는 LeetCode에서 제공하는 정의를 사용합니다.
class Solution {
    public int maxDepth(TreeNode root) {
        // 빈 트리의 깊이는 0
        if (root == null) return 0;

        // 현재 노드 1개 + 더 깊은 자식 트리의 깊이
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
