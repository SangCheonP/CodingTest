package DFS;

import java.util.*;

class Programmers_전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> list = new ArrayList<>();
        
        // 각 노드에 대한 리스트를 생성
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        // 전선 정보를 인접 리스트에 반영
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        int result = Integer.MAX_VALUE;

        // 전선을 하나씩 제거하고 그룹 크기 비교
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            // 전선 제거 (remove(Object o) 사용)
            list.get(u).remove(Integer.valueOf(v));
            list.get(v).remove(Integer.valueOf(u));

            // DFS 실행하여 한 쪽 그룹 크기 계산
            boolean[] visited = new boolean[n + 1];
            int groupSize = dfs(list, u, visited);

            // 두 그룹 차이 계산
            int diff = Math.abs((n - groupSize) - groupSize);
            result = Math.min(result, diff);

            // 전선 복구
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        return result;
    }

    static int dfs(List<List<Integer>> list, int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int size = 1;
        
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int neighbor : list.get(cur)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                    size++;
                }
            }
        }
        return size;
    }
}
