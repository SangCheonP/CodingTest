# CodingTest

## 주로 출제되는 알고리즘.

### 맵
```
Map<String, Integer> map = new HashMap<>();
Map<String, Integer> map = new LinkedHashMap<>(); // 입력 순서 유지
Map<String, Integer> map = new TreeMap<>(); // 키 값이 정렬

map.put("apple", 3);
map.get("apple"); // 3
map.getOrDefault("apple", 0);
map.containsKey("apple");
map.containsValue(3);
map.remove("apple");
map.size();
map.isEmpty();
map.computeIfAbsent("apple", k -> value);

map.keySet(); // Set 반환
Set<String> keys = map.keySet();

map.values(); // Collection 반환
Collection<Integer> values = map.values();

map.entrySet();
for (Map.Entry<String, Integer> entry : map.entrySet()) {
     System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### 스택
```
Stack<Integer> stack = new Stack<>();

stack.push(10);
int top = stack.pop();
int top = stack.peek();
stack.isEmpty();
stack.size();
```

### 큐
```
Queue<Integer> queue = new LinkedList<>();
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(10);
int front = queue.poll();
int front = queue.peek();
queue.isEmpty();
queue.size();
```

### 덱(Deque)
```
Deque<Integer> deque = new ArrayDeque<>();

deque.offerFirst(10);
deque.offerLast(20);
int front = deque.pollFirst();
int back = deque.pollLast();
int front = deque.peekFirst();
int back = deque.peekLast();
deque.isEmpty();
deque.size();
```

### 힙
```
PriorityQueue<> pq = new PriorityQueue<>(); // 최소힙
PriorityQueue<> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
```

### 정렬
```
// 배열
Arrays.sort(arr);

// 리스트
Collections.sort(list); // 오름차순
Collections.sort(list, Collections.reverseOrder()); // 내림차순

// 배열 -> 리스트
List<String> list = new ArrayList<>(Arrays.asList(arr));

// 리스트 -> 배열
String[] arr = list.toArray(new String[0]);
```

### 완전탐색

### 탐욕법

### DP

### DFS/BFS

### 이분탐색
```
while (left <= right) {
    int mid = (left + right) / 2;
    
    if (조건 충족) {
        left = mid + 1;  // 더 큰 값을 탐색
    } else {
        right = mid - 1; // 더 작은 값을 탐색
    }
}
```

### 그래프
```
List<List<Integer>> list = new ArrayList<>();

for(int i = 0; i < n; i++){
    list.add(new ArrayList<>());
}
```
```
// 다익스트라 알고리즘에서 사용할 Node 클래스
static class Node implements Comparable<Node> {
    int index; // 현재 노드의 번호
    int cost;  // 현재까지의 비용

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    // 우선순위 큐에서 cost 기준으로 정렬 (작은 비용이 우선순위 높음)
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}

// 다익스트라 알고리즘 (우선순위 큐 사용)
public static int[] dijkstra(int n, List<List<Node>> graph, int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 (최소 힙)
    int[] dist = new int[n + 1]; // 최단 거리 저장 배열
    Arrays.fill(dist, Integer.MAX_VALUE); // 모든 거리 초기값을 무한대로 설정
    dist[start] = 0; // 시작 노드의 거리는 0
    pq.offer(new Node(start, 0)); // 시작 노드를 큐에 삽입

    while (!pq.isEmpty()) {
        Node current = pq.poll(); // 현재 최단 거리 노드 선택
        int now = current.index;
        int nowCost = current.cost;

        // 이미 처리된 노드는 건너뛴다 (더 짧은 경로를 이미 찾음)
        if (dist[now] < nowCost) continue;

        // 현재 노드와 연결된 인접 노드들을 확인
        for (Node next : graph.get(now)) {
            int nextIndex = next.index;
            int newCost = nowCost + next.cost; // 현재 노드를 거쳐 가는 거리 계산

            // 새로운 비용이 기존 저장된 거리보다 작다면 갱신
            if (newCost < dist[nextIndex]) {
                dist[nextIndex] = newCost;
                pq.offer(new Node(nextIndex, newCost)); // 갱신된 노드를 우선순위 큐에 삽입
            }
        }
    }

    return dist; // 최단 거리 배열 반환
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
