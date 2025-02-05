import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 인접 리스트를 사용하여 그래프 표현
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n]; // 방문 여부 체크 배열
        
        // 그래프 초기화 (노드 개수만큼 리스트 생성)
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        // 인접 행렬을 인접 리스트로 변환
        for (int i = 0; i < computers.length; i++){
            for (int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 1 && i != j){ // 자기 자신과의 연결은 제외
                    graph.get(i).add(j); // i 노드에서 j 노드로 연결
                }
            }
        }
        
        int result = 0; // 네트워크 개수 저장 변수
        
        // 모든 노드를 순회하면서 방문하지 않은 노드에서 DFS 실행
        for (int i = 0; i < n; i++){
            if(visited[i]) continue; // 이미 방문한 노드는 건너뜀
            
            result++; // 새로운 네트워크 발견 시 카운트 증가
            dfs(graph, visited, i); // DFS 실행
        }
        
        return result; // 최종 네트워크 개수 반환
    }
    
    // 깊이 우선 탐색 (DFS) 메서드
    static void dfs(List<List<Integer>> graph, boolean[] visited, int start){
        visited[start] = true; // 현재 노드 방문 처리
        
        // 현재 노드의 인접 노드를 순회하며 DFS 재귀 호출
        for(int neighbor : graph.get(start)){
            if(visited[neighbor]) continue; // 이미 방문한 노드는 건너뜀
            dfs(graph, visited, neighbor); // 재귀적으로 방문
        }
    }
}
