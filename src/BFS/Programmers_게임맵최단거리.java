package BFS; /**
* 1. 큐 생성하여 처음 위치를 넣음
* 2. 큐에서 하나씩 빼서 동서남북 진행하여 이동할 수 있는 것은 다음 칸 좌표 큐에 넣음
* 3. (n-1, m-1)에 도착하면 이동거리를 결과에 넣고 반환
* 3-1. 도착하지 못하면(큐가 비면) -1 리턴 
**/

import java.util.*;

class Programmers_게임맵최단거리 {
    static class Point {
        int i, j;
        
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    // 상, 하, 좌, 우 이동 방향 배열
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0)); // 시작점 추가
        visited[0][0] = true; // 시작점 방문 처리
        
        int result = 0; // 이동 거리 초기화
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++; // BFS의 각 레벨(깊이) 단위마다 거리 증가
            
            for (int s = 0; s < size; s++) { // 현재 레벨에 있는 노드 탐색
                Point cur = queue.poll();
                int i = cur.i;
                int j = cur.j;
                
                // 도착 지점에 도달하면 이동 거리 반환
                if (i == n - 1 && j == m - 1) {
                    return result;
                }
                
                // 네 방향 탐색 (상, 하, 좌, 우)
                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    
                    // 범위 내에 있고, 방문하지 않았으며, 이동 가능한 경우
                    if (0 <= ni && ni < n && 0 <= nj && nj < m 
                        && !visited[ni][nj] && maps[ni][nj] == 1) {
                        queue.offer(new Point(ni, nj));
                        visited[ni][nj] = true; // 방문 체크
                    }
                }
            }
        }
        
        return -1; // 도착 불가능한 경우
    }
}
