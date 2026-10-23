import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        List<List<Point>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] t : times) {
            graph.get(t[0]).add(new Point(t[1], t[2]));
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[k] = 0;
        pq.offer(new Point(k, 0));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true; // 최소 거리로 꺼낸 시점에 확정

            for (Point next : graph.get(cur.to)) {
                if (dist[next.to] > dist[cur.to] + next.w) {
                    dist[next.to] = dist[cur.to] + next.w;
                    pq.offer(new Point(next.to, dist[next.to]));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1; // 도달 불가능한 정점
            result = Math.max(result, dist[i]);
        }
        return result;
    }

    static class Point implements Comparable<Point> {
        int to, w;
        Point(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
