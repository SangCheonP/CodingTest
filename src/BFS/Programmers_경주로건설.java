package BFS;

import java.util.*;

class Programmers_경주로건설 {
    // 방향 벡터 (상, 하, 좌, 우)
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static class Node {
        int i, j, cost, dir;

        Node(int i, int j, int cost, int dir) {
            this.i = i;
            this.j = j;
            this.cost = cost;
            this.dir = dir;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        // 차가 바라보는 방향(어디서 왔는지)에 따라 최소 비용이 달라질 수 있기 때문에 3차원 배열 사용
        int[][][] cost = new int[n][n][4]; // [i][j][차가 바라보는 방향]

        // 비용 배열 초기화
        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        // 우선순위 큐 (최소 비용 우선 탐색)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        // 시작점 (0,0) 에서 4가지 방향으로 출발 가능
        for (int d = 0; d < 4; d++) {
            pq.offer(new Node(0, 0, 0, d));
            cost[0][0][d] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 🚀 **도착점 도달 시 최소 비용 반환**
            if (cur.i == n - 1 && cur.j == n - 1) {
                return cur.cost;
            }

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni < 0 || nj < 0 || ni >= n || nj >= n || board[ni][nj] == 1) {
                    continue;
                }

                // 🔥 정반대 방향(되돌아가기) 방지
                if ((cur.dir == 0 && d == 1) || (cur.dir == 1 && d == 0) || 
                    (cur.dir == 2 && d == 3) || (cur.dir == 3 && d == 2)) {
                    continue;
                }
                
                // 비용 계산 (직선 도로 or 코너)
                int newCost = cur.cost + (cur.dir == d ? 100 : 600);

                if (newCost < cost[ni][nj][d]) {
                    cost[ni][nj][d] = newCost;
                    pq.offer(new Node(ni, nj, newCost, d));
                }
            }
        }

        return -1;
    }
}
