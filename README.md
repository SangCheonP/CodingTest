# CodingTest

## 주로 출제되는 알고리즘

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());

String A = st.nextToken();

String[] input = br.readLine().split(" ");

char[] charArr = s1.toCharArray();
```


### **int[] <-> List<Integer> 변환**

#### **int[] -> List<Integer> 변환**
```java
int[] arr = {1, 2, 3, 4, 5};
List<Integer> list = new ArrayList<>();

// for문을 이용한 변환
for (int num : arr) {
    list.add(num);
}
```

#### **List<Integer> -> int[] 변환**
```java
int[] arr = list.stream()
                .mapToInt(i -> i) // .mapToInt(Integer::intValue) 가능
                .toArray();
```

---
<br>

### **정렬 (Sorting)**
```java
// 배열 정렬
Arrays.sort(arr);

// 리스트 정렬
Collections.sort(list); // 오름차순
Collections.sort(list, Collections.reverseOrder()); // 내림차순

// 배열 -> 리스트 변환
List<String> list = new ArrayList<>(Arrays.asList(arr));

// 리스트 -> 배열 변환
String[] arr = list.toArray(new String[0]);
```

---
<br>

### **맵 (Map) - 자주 사용하는 메서드**
```java
Map<String, Integer> map = new HashMap<>(); // 기본 해시맵
Map<String, Integer> map = new LinkedHashMap<>(); // 입력 순서 유지
Map<String, Integer> map = new TreeMap<>(); // 키 기준 정렬
```
- **값 조회 및 기본값 설정**
```java
map.get("apple"); // 해당 키의 값 반환 (없으면 null)
map.getOrDefault("apple", 0); // 키가 없으면 기본값 반환
```
- **키/값 존재 여부 확인**
```java
map.containsKey("apple"); // 키 존재 여부 확인
map.containsValue(3); // 값 존재 여부 확인
```
- **값 추가 및 삭제**
```java
map.put("banana", 5); // 키-값 추가
map.remove("apple"); // 키 삭제
```
- **반복문 활용**
```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
     System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---
<br>

### **스택 (Stack) - 후입선출 (LIFO)**
```java
Stack<Integer> stack = new Stack<>();

stack.push(10); // 값 추가
int top = stack.pop(); // 최상단 값 제거 및 반환
int peek = stack.peek(); // 최상단 값 조회 (제거 X)
stack.isEmpty(); // 스택이 비어있는지 확인
stack.size(); // 스택 크기 조회
```

---
<br>

### **큐 (Queue) - 선입선출 (FIFO)**
```java
Queue<Integer> queue = new LinkedList<>();
Queue<Integer> queue = new ArrayDeque<>();

queue.offer(10); // 값 추가
int front = queue.poll(); // 값 제거 및 반환
int peek = queue.peek(); // 첫 번째 요소 조회 (제거 X)
queue.isEmpty();
queue.size();
```

---
<br>

### **우선순위 큐 (PriorityQueue) - 정렬 기준 및 자주 사용하는 메서드**
```java
// 기본: 최소 힙
PriorityQueue<Integer> pq = new PriorityQueue<>();

// 최대 힙 (내림차순 정렬)
PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

// 사용자 정의 정렬 (예: 비용 기준 오름차순)
PriorityQueue<Node> nodePq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

// 특정 클래스를 기반으로 정렬 (예: Comparable 인터페이스 사용)
static class Node implements Comparable<Node> {
    int index, cost;
    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost); // 비용 기준 오름차순 정렬
    }
}
PriorityQueue<Node> pq = new PriorityQueue<>(); // Node의 compareTo 기준 정렬
```

---
<br>

### **덱 (Deque) - 양방향 큐**
```java
Deque<Integer> deque = new ArrayDeque<>();

deque.offerFirst(10); // 앞에 추가
deque.offerLast(20); // 뒤에 추가
int front = deque.pollFirst(); // 앞에서 제거
int back = deque.pollLast(); // 뒤에서 제거
int peekFront = deque.peekFirst(); // 앞 요소 조회
int peekBack = deque.peekLast(); // 뒤 요소 조회
deque.isEmpty();
deque.size();
```

---
<br>

### **순열 (Permutation) & 조합 (Combination)**
```java
for (int i = 0; i < arr.length; i++) {
    if (!visited[i]) {      // 방문하지 않았다면
        visited[i] = true;  // 방문 처리
        temp.add(arr[i]);

        permutation(arr, visited, temp); // 다음 원소를 위한 재귀 호출

        visited[i] = false; // 원상복구 (백트래킹)
        temp.remove(temp.size() - 1);
    }
}
```

```java
for (int i = start; i < arr.length; i++) {
    temp.add(arr[i]);

    combination(arr, temp, i + 1, r - 1); // i+1로 다음 숫자부터 선택 (중복 방지)

    temp.remove(temp.size() - 1); // 원상복구 (백트래킹)
}
```



```java
void permute(String current, char[] nums, boolean[] visited) {
    if (!current.isEmpty()) {
        set.add(Integer.parseInt(current)); // 현재까지 만든 문자열을 정수로 변환하여 Set에 추가 (중복 방지)
    }
    for (int i = 0; i < nums.length; i++) { // 모든 문자를 순회
        if (!visited[i]) { // 방문하지 않은 문자라면
            visited[i] = true; // 방문 표시
            permute(current + nums[i], nums, visited); // 현재 문자 추가 후 재귀 호출
            visited[i] = false; // 백트래킹 (방문 해제)
        }
    }
}
```

---
<br>

### **이분 탐색 (Binary Search)**
```java
int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1; // 탐색할 범위 설정 (배열의 처음과 끝)
    while (left <= right) { // 탐색 범위가 유효한 동안 반복
        int mid = left + (right - left) / 2; // 중간 인덱스 계산 (오버플로우 방지)
        if (arr[mid] == target) return mid; // 목표 값을 찾으면 해당 인덱스 반환
        if (arr[mid] < target) left = mid + 1; // 중간 값보다 크면 오른쪽 탐색
        else right = mid - 1; // 중간 값보다 작으면 왼쪽 탐색
    }
    return -1; // 값을 찾지 못한 경우 -1 반환
}
```

---
<br>

### **깊이 우선 탐색 (DFS)**
```java
void dfs(int node) {
    visited[node] = true; // 현재 노드를 방문 처리
    for (int next : graph.get(node)) { // 현재 노드와 연결된 모든 노드 순회
        if (!visited[next]) { // 방문하지 않은 노드라면
            dfs(next); // 재귀 호출을 통해 해당 노드 방문
        }
    }
}
```

---
<br>

### **너비 우선 탐색 (BFS) - 우선순위 큐 기반 & 레벨별 탐색**
```java
void bfs(int start) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐 기반 BFS
    pq.offer(start); // 시작 노드를 큐에 추가
    visited[start] = true; // 시작 노드 방문 처리
    int depth = 0; // 깊이 변수 초기화

    while (!pq.isEmpty()) { // 큐가 빌 때까지 반복
        int size = pq.size(); // 현재 레벨에서 처리할 노드 수 저장

        for (int i = 0; i < size; i++) { // 현재 레벨의 모든 노드를 처리
            int cur = pq.poll(); // 현재 노드 꺼내기
            System.out.println("현재 노드: " + cur + ", 깊이: " + depth); // 현재 노드의 깊이 출력

            for (int next : graph.get(cur)) { // 인접 노드 탐색
                if (!visited[next]) { // 방문하지 않은 노드라면
                    visited[next] = true; // 방문 처리
                    pq.offer(next); // 큐에 삽입
                }
            }
        }
        
        depth++; // 현재 레벨이 끝나면 깊이 증가
    }
}
```

---
<br>

### **다익스트라 알고리즘 (Dijkstra)**
```java
List<List<Integer>> list = new ArrayList<>();

for(int i = 0; i < n; i++){
    list.add(new ArrayList<>());
}
```

```java
int[] dijkstra(int n, List<List<Node>> graph, int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>(); // 최소 힙(우선순위 큐) 사용
    int[] dist = new int[n + 1]; // 최단 거리 배열
    Arrays.fill(dist, Integer.MAX_VALUE); // 모든 거리를 무한대로 초기화
    dist[start] = 0; // 시작 노드의 최단 거리는 0
    pq.offer(new Node(start, 0)); // 시작 노드를 큐에 추가

    while (!pq.isEmpty()) { // 큐가 빌 때까지 반복
        Node current = pq.poll(); // 현재 최단 거리 노드를 꺼냄
        int now = current.index; // 현재 노드의 인덱스
        int nowCost = current.cost; // 현재 노드까지의 비용

        if (dist[now] < nowCost) continue; // 이미 더 작은 비용으로 방문한 경우 스킵

        for (Node next : graph.get(now)) { // 현재 노드와 연결된 모든 인접 노드 탐색
            int nextIndex = next.index; // 인접 노드의 인덱스
            int newCost = nowCost + next.cost; // 현재 노드를 거쳐 가는 비용 계산

            if (newCost < dist[nextIndex]) { // 더 작은 비용으로 갱신 가능하면
                dist[nextIndex] = newCost; // 최단 거리 배열 업데이트
                pq.offer(new Node(nextIndex, newCost)); // 큐에 새로운 정보 추가
            }
        }
    }
    return dist; // 최단 거리 결과 반환
}
```

---
<br>

### **플로이드-워셜 (Floyd-Warshall) - 모든 정점 간 최단 거리**
```java
int[][] dist = new int[n][n]; // 최단 거리 저장 배열

// 모든 거리 값을 무한대(INF)로 초기화
for (int[] row : dist) {
    Arrays.fill(row, INF);
}

// 자기 자신으로 가는 거리는 0으로 초기화
for (int i = 0; i < n; i++) {
    dist[i][i] = 0;
}

// 플로이드-워셜 알고리즘 수행
for (int k = 0; k < n; k++) { // 경유할 노드 선택
    for (int i = 0; i < n; i++) { // 출발 노드 선택
        for (int j = 0; j < n; j++) { // 도착 노드 선택
            // k를 거쳐가는 경우가 기존 경로보다 짧다면 갱신
            if (dist[i][k] != INF && dist[k][j] != INF) {
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
}
```

---
<br>

### **최소 신장 트리 (MST, Kruskal 알고리즘 - Rank 기반 최적화)**
```java
// 간선 클래스 (비용 기준 정렬을 위해 Comparable 구현)
class Edge implements Comparable<Edge> {
    int from, to, cost; // 시작 정점, 끝 정점, 간선 비용

    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost); // 비용 기준 오름차순 정렬
    }
}

// 유니온-파인드 자료구조 (경로 압축 & 랭크 기반 최적화)
int[] parent, rank;

// 루트 노드 찾기 (경로 압축 기법 사용)
int find(int x) {
    if (parent[x] != x) {
        parent[x] = find(parent[x]); // 부모를 루트로 갱신하여 경로 압축
    }
    return parent[x];
}

// 두 집합을 합치는 함수 (랭크 기반 최적화 적용)
boolean union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);

    if (rootA != rootB) { // 두 노드가 서로 다른 집합에 속해 있다면 합침
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA; // 랭크가 더 높은 쪽에 병합
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA; // 랭크가 같다면 rootA를 rootB의 부모로 하고 rank 증가
            rank[rootA]++;
        }
        return true; // 합집합 수행됨
    }
    return false; // 이미 같은 집합이라 합칠 필요 없음
}
```

---
<br>

### 동적 계획법 (Dynamic Programming, DP)
```java
int knapsack(int W, int[] weights, int[] values, int n) {
    int[][] dp = new int[n + 1][W + 1]; // dp[i][w]: i번째 물건까지 고려했을 때 무게 w에서의 최대 가치 저장

    for (int i = 1; i <= n; i++) { // i번째 물건까지 고려
        for (int w = 0; w <= W; w++) { // 현재 배낭 무게 w까지 탐색
            if (weights[i - 1] <= w) // 현재 물건을 배낭에 담을 수 있는 경우
                dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]); // 담는 경우와 안 담는 경우 비교
            else
                dp[i][w] = dp[i - 1][w]; // 현재 물건을 담을 수 없는 경우 이전 값을 그대로 유지
        }
    }
    return dp[n][W]; // 배낭 용량 W에서 얻을 수 있는 최대 가치 반환
}
```

---
<br>

### **이중 연결 리스트 (Doubly Linked List)**
```java
class Node {
    int data; // 노드에 저장될 데이터
    Node prev, next; // 이전 노드와 다음 노드를 가리키는 포인터

    Node(int data) { // 생성자
        this.data = data;
        this.prev = null; // 초기값: 이전 노드는 없음
        this.next = null; // 초기값: 다음 노드는 없음
    }
}

class DoublyLinkedList {
    Node head, tail; // 리스트의 첫 번째 노드와 마지막 노드

    // 꼬리에 노드 삽입
    void insert(int data) {
        Node newNode = new Node(data); // 새로운 노드 생성
        if (tail == null) { // 리스트가 비어있다면
            head = tail = newNode; // head와 tail을 새로운 노드로 설정
        } else {
            tail.next = newNode; // 기존 마지막 노드(tail)의 next를 새 노드로 연결
            newNode.prev = tail; // 새 노드의 prev를 기존 tail로 설정
            tail = newNode; // tail을 새 노드로 업데이트
        }
    }

    // 특정 노드 삭제
    void delete(Node node) {
        if (node.prev != null) node.prev.next = node.next; // 이전 노드의 next를 현재 노드의 next로 변경
        if (node.next != null) node.next.prev = node.prev; // 다음 노드의 prev를 현재 노드의 prev로 변경
        if (node == head) head = node.next; // 삭제한 노드가 head라면 head를 다음 노드로 변경
        if (node == tail) tail = node.prev; // 삭제한 노드가 tail이라면 tail을 이전 노드로 변경
    }

    // 리스트 출력
    void printList() {
        Node current = head; // head부터 시작
        while (current != null) { // 리스트를 순회하면서 출력
            System.out.print(current.data + " "); // 노드 데이터 출력
            current = current.next; // 다음 노드로 이동
        }
        System.out.println(); // 개행
    }
}
```

---
<br>

### **이진 트리(Binary Tree)**
```java
class BinaryTree {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        // 🔹 이진 탐색 트리 삽입 (x 값 기준)
        void insert(Node child) {
            if (child.value < this.value) { // 왼쪽 서브트리
                if (this.left == null) this.left = child;
                else this.left.insert(child);
            } else { // 오른쪽 서브트리
                if (this.right == null) this.right = child;
                else this.right.insert(child);
            }
        }
    }
}
```

## 📌 **추가 기능 및 알고리즘**
- 완전 탐색 (Brute Force)
