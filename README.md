# CodingTest

## 주로 출제되는 알고리즘

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
