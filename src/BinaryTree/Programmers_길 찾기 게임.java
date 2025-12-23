package BinaryTree;

import java.util.*;

class Programmers_길찾기게임 {
    static class Node {
        int idx, x, y; // 노드 번호, x 좌표, y 좌표
        Node left, right; // 왼쪽 및 오른쪽 자식 노드

        Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }

        // 트리에 노드 삽입 (이진 탐색 트리 규칙 적용)
        void insert(Node child) {
            if (child.x < this.x) { // 현재 노드보다 x 값이 작으면 왼쪽 자식
                if (this.left == null) {
                    this.left = child;
                } else {
                    this.left.insert(child);
                }
            } else { // x 값이 크면 오른쪽 자식
                if (this.right == null) {
                    this.right = child;
                } else {
                    this.right.insert(child);
                }
            }
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        // 노드 리스트 생성 (각 노드 번호 포함)
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0]; // x 좌표
            int y = nodeinfo[i][1]; // y 좌표
            nodes.add(new Node(i + 1, x, y)); // 노드 번호는 1부터 시작
        }

        // 1️⃣ y 값 기준 내림차순 정렬 (y가 클수록 루트에 가까움)
        Collections.sort(nodes, (a, b) -> b.y - a.y);

        // 2️⃣ 트리 구성: 첫 번째 노드가 루트가 됨
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            root.insert(nodes.get(i)); // 트리에 삽입
        }

        // 3️⃣ 전위 순회 (preorder)
        List<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        int[] preOrderResult = preOrderList.stream().mapToInt(i -> i).toArray();

        // 4️⃣ 후위 순회 (postorder)
        List<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        int[] postOrderResult = postOrderList.stream().mapToInt(i -> i).toArray();

        // 최종 결과 반환
        return new int[][]{preOrderResult, postOrderResult};
    }

    // 🔹 전위 순회 (Preorder): 루트 → 왼쪽 → 오른쪽
    static void preOrder(Node node, List<Integer> result) {
        if (node == null) return; // 종료 조건: null이면 종료
        result.add(node.idx); // 루트 방문
        preOrder(node.left, result); // 왼쪽 방문
        preOrder(node.right, result); // 오른쪽 방문
    }

    // 🔹 후위 순회 (Postorder): 왼쪽 → 오른쪽 → 루트
    static void postOrder(Node node, List<Integer> result) {
        if (node == null) return; // 종료 조건: null이면 종료
        postOrder(node.left, result); // 왼쪽 방문
        postOrder(node.right, result); // 오른쪽 방문
        result.add(node.idx); // 루트 방문
    }
}
