package BackTracking;

import java.util.*;

class Programmers_양과늑대 {
    static int result = 0;
    
    public int solution(int[] info, int[][] edges) {
        // 그래프 만들기
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }
        
        // DFS 시작: 루트 노드(0번)에서 출발
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 1, 0, list, info, graph);
        
        return result;
    }
    
    static void dfs(int idx, int sheep, int wolf, List<Integer> nodes, int[] info, List<List<Integer>> graph) {
        if (sheep <= wolf) return; // 늑대 수가 양보다 많아지면 종료

        result = Math.max(result, sheep); // 최대 양 수 갱신

        // 현재 가능한 노드 리스트 복사 (새로운 리스트 생성)
        List<Integer> newList = new ArrayList<>(nodes);
        newList.remove(Integer.valueOf(idx)); // 현재 노드 제거

        // 현재 노드의 자식 노드 추가
        for (int child : graph.get(idx)) {
            newList.add(child);
        }

        // 이동할 수 있는 노드들 탐색
        for (int next : newList) {
            if (info[next] == 0) { // 양이면 증가
                dfs(next, sheep + 1, wolf, newList, info, graph);
            } else { // 늑대면 증가
                dfs(next, sheep, wolf + 1, newList, info, graph);
            }
        }
    }
}
