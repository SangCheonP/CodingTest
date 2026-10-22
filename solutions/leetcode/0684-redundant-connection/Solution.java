class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            // 이미 연결된 두 정점을 잇는 간선은 순환을 완성한다.
            if (!uf.merge(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[]{-1, -1};
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int n) {
            if (parent[n] == n) return n;
            // 경로 압축으로 대표에 직접 연결한다.
            return parent[n] = find(parent[n]);
        }

        public boolean merge(int x, int y) {
            int xP = find(x);
            int yP = find(y);

            if (xP == yP) return false;
            // 원소 자체가 아닌 각 집합의 루트를 연결한다.
            if (rank[xP] > rank[yP]) {
                parent[yP] = xP;
            } else if (rank[xP] < rank[yP]) {
                parent[xP] = yP;
            } else {
                rank[xP]++;
                parent[yP] = xP;
            }

            return true;
        }
    }
}
