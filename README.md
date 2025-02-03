# CodingTest

## 주로 출제되는 알고리즘

### 해시

### 스택/큐

### 힙
```
PriorityQueue<> pq = new PriorityQueue<>();
```
 
  - 최대
  - 최소

### 정렬
```
Collections.sort(?, Collections.reverseOrder());
```

### 완전탐색

### 탐욕법

### DP

### DFS/BFS

### 이분탐색

### 그래프
```
List<List<Integer>> list = new ArrayList<>();

for(int i = 0; i < n; i++){
    list.add(new ArrayList<>());
}
```

### 순열
```
static void permute(String current, char[] nums, boolean[] visited) {
    if (!current.isEmpty()) {
        set.add(Integer.parseInt(current)); // 숫자로 변환하여 Set에 추가
    }
        
    for (int i = 0; i < nums.length; i++) {
        if (!visited[i]) {
            visited[i] = true;
            permute(current + nums[i], nums, visited);
            visited[i] = false;
        }
    }
}
```

### MST(최소 신장 트리)
```
static class Edge implements Comparable<Edge>{
    int from, to, cost;

    Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost; // 비용 기준 오름차순 정렬
    }
}

// 루트 노드 찾기 (경로 압축)
static int find(int x){
    if(parent[x] != x){
        parent[x] = find(parent[x]);
    }

    return parent[x];
}

// 두 노드를 같은 집합으로 합치기 (랭크 기반)
static boolean union(int a, int b){
    int rootA = parent[a];
    int rootB = parent[b];

    if(rootA != rootB){
        // 랭크가 높은 트리에 낮은 트리를 합친다.
        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        } else { // 랭크가 같으면 하나를 루트로 만들고 랭크를 증가
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true; // 연결 성공
    }
    return false; // 이미 같은 집합이면 연결하지 않음
}
```
