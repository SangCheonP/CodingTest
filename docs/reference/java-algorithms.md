# Java 코딩테스트 함수·자료구조·알고리즘 참고

[학습 홈](../../README.md) · [문제집](../leetcode/problemset.md)

Java 17 기준. 예제는 각각 독립적인 조각이며 메서드·내부 클래스는 Solution 또는 Main 안에 넣는다. 공통 import는 java.util.*, 입출력은 java.io.*다. n은 원소 수, V는 정점 수, E는 간선 수다. 해시 연산은 평균, 배열 확장 연산은 분할 상환 기준이다.

## 목차
- [정렬과 배열](#정렬과-배열)
- [문자열과 수치](#문자열과-수치)
- [자료구조 API](#자료구조-api)
- [입출력과 변환](#입출력과-변환)
- [알고리즘 선택](#알고리즘-선택)
- [탐색과 구간](#탐색과-구간)
- [그래프](#그래프)
- [완전탐색과 DP](#완전탐색과-dp)
- [연결 리스트와 트리](#연결-리스트와-트리)
- [제출 전 점검](#제출-전-점검)

## 정렬과 배열

### Arrays.sort와 Comparator
정렬은 원본을 변경하며 반환값은 void다. 원래 인덱스가 필요하면 정렬 전에 함께 저장한다. int[]에는 Comparator를 전달할 수 없고, Integer[] 또는 int[][] 등 객체 배열에는 가능하다.

```java
int[] a = {3, 1, 2};
Arrays.sort(a);                 // 오름차순
Arrays.sort(a, 0, 2);           // [0, 2)만 정렬, 끝 인덱스 제외

Integer[] boxed = {3, 1, 2};
Arrays.sort(boxed, Comparator.reverseOrder()); // 내림차순

int[][] pairs = {{2, 5}, {1, 4}, {2, 3}};
Arrays.sort(pairs, (x, y) -> {
    int cmp = Integer.compare(x[0], y[0]); // 첫 값 오름차순
    return cmp != 0 ? cmp : Integer.compare(y[1], x[1]); // 같으면 둘째 값 내림차순
});

List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2));
list.sort(Integer::compare);                  // Collections.sort(list)도 가능
list.sort(Comparator.reverseOrder());
```

비교 결과가 음수면 앞, 0이면 동순위, 양수면 뒤다. x - y는 오버플로 위험이 있어 Integer.compare 또는 Long.compare를 쓴다. Comparable.compareTo는 클래스 기본 순서, Comparator는 사용 지점의 순서다. 객체 정렬은 안정 정렬이다. 일반 비교 정렬 비용은 O(n log n)으로 계획하되 정확한 구현 특성은 자료형과 JDK에 따른다.

### 배열 함수
| 호출 | 동작·반환값 | 주의 |
|---|---|---|
| Arrays.fill(a, v) | 모든 칸을 v로, void | 2차원 기본형 배열은 행마다 호출 |
| Arrays.copyOf(a, len) | 길이 len인 새 배열 | 부족한 int 칸은 0 |
| Arrays.copyOfRange(a, l, r) | [l, r) 복사 | 끝 제외 |
| Arrays.equals(a, b) | 1차원 내용 비교, boolean | 2차원 내용은 deepEquals |
| Arrays.toString(a) | 1차원 출력 문자열 | 2차원은 deepToString |
| Arrays.binarySearch(a, x) | 있으면 인덱스 | 정렬 필수, 중복의 첫 위치 보장 없음 |

binarySearch가 실패하면 -(삽입 위치) - 1을 반환한다. 반환값이 pos < 0이면 삽입 위치는 -pos - 1이다. 검색은 O(log n), 복사·채우기·내용 비교는 처리 길이에 비례한다.

```java
int[][] matrix = {{1, 2}, {3, 4}};
int[][] copy = new int[matrix.length][];
for (int i = 0; i < matrix.length; i++) {
    copy[i] = matrix[i].clone(); // 각 행을 따로 복사
}
// matrix.clone()만 하면 내부 행은 공유된다.
```

## 문자열과 수치

| API | 의미·주의 |
|---|---|
| s.length(), s.charAt(i) | 길이, i번째 char. 인덱스 범위 확인 |
| s.substring(l, r) | [l, r) 문자열, 복사 비용 고려 |
| s.indexOf(x) | 첫 위치, 없으면 -1 |
| s.equals(t) | 내용 비교. ==는 참조 비교 |
| s.toCharArray() | 새 char 배열 |
| s.split(regex) | 정규식 분리. 기본 동작은 끝의 빈 토큰 제거 |
| Integer.parseInt(s), Long.parseLong(s) | 숫자 파싱, 범위 밖이면 예외 |
| String.valueOf(x) | 문자열 변환 |
| Character.isDigit(c) | 숫자 문자 판정, ASCII 이외 숫자도 포함 |
| sb.append(x), sb.toString() | 뒤에 추가, 결과 문자열 |
| sb.setCharAt(i, c), sb.deleteCharAt(i) | 교체, 제거 |
| sb.setLength(len), sb.reverse() | 길이 변경, 뒤집기 |

StringBuilder 뒤에 추가는 일반적으로 추가 문자 수에 비례하며 확장 비용은 분할 상환한다. 중간 삭제·삽입은 뒤 원소 이동 때문에 O(n), toString은 복사 비용 O(n)이다.

```java
int digit = '7' - '0'; // ASCII 숫자인 것이 보장될 때
int index = 'c' - 'a'; // 영어 소문자인 것이 보장될 때
long product = 1L * 100_000 * 100_000; // 계산 전에 long으로 승격
long absolute = Math.abs((long) Integer.MIN_VALUE); // int 상태의 abs는 넘칠 수 있음
StringBuilder sb = new StringBuilder();
sb.append("ab").append(3); // 반복적인 문자열 덧붙이기
```

- int: 약 ±21억, long: 약 ±9×10^18. 정수 나눗셈은 소수부를 버린다.
- 음수 나머지를 0 이상으로 정규화할 때 Math.floorMod(x, m), m > 0.
- Math.pow는 double 반환. 정확한 정수 거듭제곱은 범위 확인 후 정수 연산.
- char는 UTF-16 코드 단위다. 문제의 문자 범위가 영어인지 일반 유니코드인지 확인한다.
- 비트 마스크는 (1L << i), 비트 수는 Long.bitCount(mask). long의 이동 거리는 64로 나눈 나머지가 적용되므로 i < 64 조건을 확인한다.

```java
// 음수가 아닌 정수의 최대공약수, gcd(0, b) = b
static long gcd(long a, long b) {
    while (b != 0) {
        long t = a % b;
        a = b;
        b = t;
    }
    return a;
}
// 최소공배수: a == 0 || b == 0이면 0, 아니면 a / gcd(a, b) * b.
// 곱셈 결과가 long 범위 안인지 별도로 확인한다.
```

## 자료구조 API

### 빠른 선택
| 목적 | 기본 선택 | 대표 비용 |
|---|---|---|
| 인덱스 접근·뒤 추가 | ArrayList | get/set O(1), 뒤 add 분할 상환 O(1) |
| 중복 제거·존재 검사 | HashSet | add/contains/remove 평균 O(1) |
| 키별 값·빈도 | HashMap | get/put/remove 평균 O(1) |
| 삽입 순서 유지 | LinkedHashMap, LinkedHashSet | 해시 연산 평균 O(1) |
| 정렬된 키·이웃 찾기 | TreeMap, TreeSet | 기본 검색·삽입·삭제 O(log n) |
| 스택·FIFO 큐·덱 | ArrayDeque | 양 끝 연산 분할 상환 O(1) |
| 최솟값·최댓값 반복 추출 | PriorityQueue | offer/poll O(log n), peek O(1) |

### List
| 호출 | 반환값·동작 |
|---|---|
| add(x) | 끝에 추가, boolean |
| add(i, x) | i에 삽입, void, O(n) |
| get(i) | 해당 원소 |
| set(i, x) | 교체 전 원소 반환 |
| remove(i) | 인덱스 원소 제거 후 그 원소 반환, O(n) |
| remove(Object x) | 처음 일치하는 값 제거 여부, boolean |
| contains(x), indexOf(x) | 존재 여부, 첫 위치 또는 -1; O(n) |
| size(), isEmpty(), clear() | 크기, 비었는지, 전체 삭제 |

```java
List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.remove(Integer.valueOf(10)); // 값 10 삭제
list.remove(0);                   // 인덱스 0 삭제
// new ArrayList<>(100)은 용량만 예약한다. size는 여전히 0이다.
```

LinkedList의 인덱스 접근은 O(n)이므로 인덱스 반복에는 ArrayList를 우선한다. enhanced for 도중 구조를 바꾸려면 Iterator.remove 등 적절한 방법을 사용한다.

### Map과 Set
| 호출 | 반환값·주의 |
|---|---|
| map.put(k, v) | 이전 값, 없었으면 null |
| map.get(k) | 값, 없으면 null |
| map.getOrDefault(k, d) | 키가 없으면 d; 저장된 null은 그대로 null |
| map.putIfAbsent(k, v) | 기존 값이 없거나 null이면 저장 |
| map.remove(k) | 삭제 전 값 또는 null |
| map.containsKey(k) | 키 존재 여부 |
| map.containsValue(v) | 값 존재 여부, 일반 HashMap에서 O(n) |
| map.keySet()/values()/entrySet() | 맵과 연결된 뷰, 독립 복사 아님 |
| set.add(x) | 새로 추가됐으면 true, 중복이면 false |
| set.contains(x), set.remove(x) | 존재 여부, 실제 삭제 여부 |

```java
Map<String, Integer> count = new HashMap<>();
count.put("apple", count.getOrDefault("apple", 0) + 1); // 빈도 증가
count.merge("pear", 1, Integer::sum); // 같은 목적의 대안

Map<String, List<String>> groups = new HashMap<>();
groups.computeIfAbsent("fruit", k -> new ArrayList<>()).add("apple");
// 키가 없거나 값이 null이면 새 리스트를 저장하고 반환

for (Map.Entry<String, Integer> e : count.entrySet()) {
    System.out.println(e.getKey() + " " + e.getValue());
}
Set<Integer> seen = new HashSet<>();
boolean first = seen.add(7); // 중복 검사와 추가를 함께 수행
```

배열을 HashMap 키로 쓰면 기본적으로 내용이 아닌 객체 식별 기준으로 비교된다. 사용자 정의 키는 equals와 hashCode를 일관되게 구현하고 저장 후 키의 비교 필드를 변경하지 않는다.

TreeSet의 lower(x), floor(x), ceiling(x), higher(x)는 각각 <, <=, >=, >인 가장 가까운 원소를 반환하며 없으면 null이다. TreeMap에는 lowerKey 등 대응 메서드가 있다. first/last는 비어 있으면 예외다. 비교 결과 0인 서로 다른 객체는 TreeSet에서 같은 원소로 취급되므로 비교 기준에 주의한다.

### Queue·Deque·Stack
| 목적 | 추가 | 제거하며 반환 | 조회만 |
|---|---|---|---|
| FIFO 큐 | offer(x) | poll() | peek() |
| 덱 앞 | offerFirst(x) | pollFirst() | peekFirst() |
| 덱 뒤 | offerLast(x) | pollLast() | peekLast() |
| 스택 | push(x) | pop() | peek() |

poll/peek 계열은 비어 있으면 null, pop/removeFirst/getFirst 계열은 예외다. null을 int로 자동 언박싱해도 예외가 발생한다. ArrayDeque는 null을 허용하지 않는다. Stack 대신 Deque를 기본 선택으로 사용한다.

```java
Queue<Integer> queue = new ArrayDeque<>();
queue.offer(10); // 뒤에 삽입
Integer front = queue.poll(); // 앞에서 꺼냄, 빈 큐면 null

Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
if (!stack.isEmpty()) {
    int top = stack.pop(); // 마지막으로 넣은 원소 제거
}
```

### PriorityQueue
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
PriorityQueue<int[]> jobs = new PriorityQueue<>(
    (a, b) -> Integer.compare(a[1], b[1])); // 두 번째 값이 작은 순서

jobs.offer(new int[]{5, 20});
int[] firstJob = jobs.poll(); // 비어 있으면 null
```

offer는 추가 성공 여부, poll은 제거한 원소, peek는 제거하지 않은 선두를 반환한다. contains와 remove(Object)는 O(n)이다. for-each 순회는 정렬 순서를 보장하지 않는다. 같은 우선순위의 순서도 보장하지 않으므로 필요하면 보조 비교 기준을 둔다. 넣은 객체의 비교 필드를 직접 바꿔도 힙이 자동 재정렬되지 않는다.

## 입출력과 변환
백준은 Main과 표준 입출력, LeetCode는 제공된 메서드 시그니처를 사용한다.

```java
// 공백·줄바꿈을 구분하지 않는 토큰 입력. EOF면 null.
static class FastInput {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
```

문장·공백 자체가 데이터라면 readLine을 쓴다. 대량 출력은 StringBuilder에 모아 한 번에 출력한다.

```java
int[] a = {1, 2, 3};
List<Integer> list = new ArrayList<>();
for (int x : a) list.add(x); // 기본형을 박싱
int[] back = list.stream().mapToInt(Integer::intValue).toArray();
String[] words = {"a", "b"};
List<String> editable = new ArrayList<>(Arrays.asList(words));
String[] wordArray = editable.toArray(new String[0]);
// Arrays.asList(words)는 크기 변경 불가, 원본 배열과 원소 저장소 공유.
// Arrays.asList(a)는 List<Integer>가 아니라 원소 하나인 List<int[]>다.
```

## 알고리즘 선택
| 입력·요구 조건 | 후보 | 주의 |
|---|---|---|
| 모든 후보가 적음 | 완전탐색·백트래킹 | 상태 수와 결과 복사 비용 포함 |
| 연결 여부·도달 가능성 | DFS/BFS | 방문 상태의 범위 정의 |
| 동일 비용 최단거리 | BFS | 큐에 넣을 때 방문 표시 |
| 음수 없는 가중치 최단거리 | 다익스트라 | 최소 거리로 꺼낼 때 확정 |
| 모든 쌍 거리, 작은 V | 플로이드-워셜 | O(V³), 음수 사이클 주의 |
| 음수 간선의 단일 시작점 거리 | 벨만-포드 | O(VE), 도달 가능한 음수 사이클 판별 |
| 연결 집합 병합 | Union-Find | 루트끼리 연결 |
| 선수 조건·작업 순서 | 위상 정렬 | 방향 그래프, 사이클이면 전체 정렬 불가 |
| 모든 정점을 최소 비용으로 연결 | MST | 최단 경로 문제와 구분 |
| 정렬된 배열·단조 판정 | 이분 탐색 | 경계와 구간 정의 |
| 연속 구간 합 | 누적합·윈도우 | 가변 합 윈도우의 단조성 확인 |
| 겹치는 부분 문제 | DP | 상태·초기값·전이·계산 순서 |
| 매번 최선 선택 | 그리디 | 선택이 전체 최적을 보장한다는 근거 필요 |

## 탐색과 구간
### 이분 탐색
오름차순 배열에서 첫 a[i] >= target을 찾는다. 없으면 a.length. 정렬 전 인덱스는 보존되지 않는다. O(log n).
```java
static int lowerBound(int[] a, int target) {
    int l = 0, r = a.length; // [l, r)
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (a[mid] < target) l = mid + 1;
        else r = mid;
    }
    return l;
}
// upperBound: 조건을 a[mid] <= target으로 바꾸면 첫 > target 위치.
// 값의 존재: pos < a.length && a[pos] == target.
// 중복 개수: upperBound - lowerBound.
```

### 투 포인터·슬라이딩 윈도우
정렬 배열의 두 수 합은 양 끝에서 시작해 합에 따라 한쪽을 이동한다. O(n). 합은 long으로 계산하면 덧셈 범위를 넓힐 수 있다.

고정 길이 윈도우는 음수가 있어도 이동 가능하다. 아래는 1 <= k <= a.length 전제의 최대 합이다.
```java
static long maxWindow(int[] a, int k) {
    long sum = 0;
    for (int i = 0; i < k; i++) sum += a[i];
    long best = sum;
    for (int i = k; i < a.length; i++) {
        sum += (long) a[i] - a[i - k]; // 들어온 값 추가, 나간 값 제거
        best = Math.max(best, sum);
    }
    return best;
}
```

가변 길이에서 합이 크면 줄이고 작으면 늘리는 판단은 음수가 있으면 보장되지 않는다. [4, -1], 목표 3에서 4를 먼저 버리면 정답을 놓친다. 양수 배열과 양수 목표의 합 개수 문제에서는 단조성을 활용할 수 있지만, 0이 있으면 같은 합의 여러 구간을 별도 고려해야 한다. 문자 중복 등 다른 조건의 윈도우는 그 조건의 유지·복구 가능성을 판단한다.

### 누적합
```java
long[] prefix = new long[a.length + 1];
for (int i = 0; i < a.length; i++) {
    prefix[i + 1] = prefix[i] + a[i];
}
long rangeSum = prefix[r] - prefix[l]; // [l, r), 질의 O(1)
```

합 k의 구간 개수는 이전 누적합 빈도를 이용할 수 있다. 초기 누적합 0을 한 번 넣고, 현재 합 - k 조회 후 현재 합의 빈도를 늘린다. k == 0일 때 빈 구간을 세지 않도록 순서를 지킨다. [LC560 풀이](../../solutions/leetcode/0560-subarray-sum-equals-k/README.md).

### 정렬·구간·단조 스택
구간 병합은 시작점 정렬 후 겹치는 구간의 끝을 갱신한다. 닫힌 구간인지에 따라 <와 <=가 달라진다. 단조 스택은 원소 또는 인덱스를 증가·감소 순으로 유지하며 각 원소가 최대 한 번 들어가고 나가 O(n)으로 처리할 수 있다. 같은 값도 제거할지 여부를 문제 조건에 맞춘다.

## 그래프
### 표현·DFS·BFS
```java
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
for (int[] e : edges) {
    graph.get(e[0]).add(e[1]); // 방향 그래프
    // 무방향이면 graph.get(e[1]).add(e[0])도 추가
}
```

아래 메서드는 0-based 인접 리스트 기준이다. DFS/BFS 모두 O(V + E). 재귀 깊이가 길면 반복형 탐색을 고려한다.
```java
static void dfs(int u, List<List<Integer>> graph, boolean[] seen) {
    seen[u] = true;
    for (int v : graph.get(u)) {
        if (!seen[v]) dfs(v, graph, seen);
    }
}
static int[] bfs(int start, List<List<Integer>> graph) {
    int[] distance = new int[graph.size()];
    Arrays.fill(distance, -1);
    Queue<Integer> q = new ArrayDeque<>();
    distance[start] = 0;
    q.offer(start);
    while (!q.isEmpty()) {
        int u = q.poll();
        for (int v : graph.get(u)) {
            if (distance[v] != -1) continue;
            distance[v] = distance[u] + 1; // 넣기 전에 방문 처리
            q.offer(v);
        }
    }
    return distance;
}
```

격자는 dr = {1,-1,0,0}, dc = {0,0,1,-1}로 네 방향을 나타낸다. d마다 dr[d], dc[d]를 더하고 행·열 범위, 이동 조건, 방문 여부를 검사한다. 다중 시작점 BFS는 모든 시작점을 거리 0으로 먼저 넣는다. 레벨별 처리는 반복 시작 시 q.size()를 저장하고 그 개수만 꺼낸다.

### 다익스트라
모든 가중치가 0 이상일 때 사용한다. 아래는 1-based, 간선 int[]{도착, 비용}, 큐 항목 long[]{정점, 누적 거리}다. 유한 거리와 더하기 결과가 INF 미만이라는 전제다.

```java
static long[] dijkstra(List<List<int[]>> graph, int start) {
    final long INF = Long.MAX_VALUE / 4;
    long[] dist = new long[graph.size()];
    Arrays.fill(dist, INF);
    boolean[] visited = new boolean[graph.size()];
    PriorityQueue<long[]> pq = new PriorityQueue<>(
        (a, b) -> Long.compare(a[1], b[1]));
    dist[start] = 0;
    pq.offer(new long[]{start, 0});

    while (!pq.isEmpty()) {
        long[] cur = pq.poll();
        int u = (int) cur[0];
        if (visited[u]) continue;
        visited[u] = true; // 최소 거리로 꺼낸 시점에 확정
        for (int[] edge : graph.get(u)) {
            int v = edge[0];
            long candidate = dist[u] + edge[1];
            if (candidate < dist[v]) {
                dist[v] = candidate;
                pq.offer(new long[]{v, candidate});
            }
        }
    }
    return dist;
}
```

| 중복 처리 방지 | 의미 |
|---|---|
| visited[u] 검사 | 이미 확정·처리한 정점은 생략 |
| cur[1] > dist[u] 검사 | 더 짧은 경로가 발견된 오래된 큐 항목 생략 |

두 번째 방식을 사용하면 visited 선언·검사·설정을 제거하고 오래된 항목 검사를 넣는다. 두 방식 모두 올바르며 visited가 항상 더 빠른 것은 아니다. 방문 처리는 큐 삽입 시점에 하면 안 된다. 중복 삽입형 구현의 시간은 O(V + E log(E + 1)), 공간은 O(V + E). [LC743 최종 코드](../../solutions/leetcode/0743-network-delay-time/Solution.java).

### 플로이드-워셜
작은 그래프의 모든 쌍 최단거리. O(V³) 시간, O(V²) 공간. 음수 간선도 가능하지만 음수 사이클이 있으면 관련 최단거리가 정의되지 않는다.

```java
static long[][] floyd(int n, int[][] edges) {
    final long INF = Long.MAX_VALUE / 4;
    long[][] d = new long[n][n];
    for (int i = 0; i < n; i++) {
        Arrays.fill(d[i], INF);
        d[i][i] = 0;
    }
    for (int[] e : edges) { // 0-based {출발, 도착, 비용}
        d[e[0]][e[1]] = Math.min(d[e[0]][e[1]], e[2]);
    }
    for (int k = 0; k < n; k++) { // 경유 정점은 가장 바깥 반복문
        for (int i = 0; i < n; i++) {
            if (d[i][k] == INF) continue;
            for (int j = 0; j < n; j++) {
                if (d[k][j] == INF) continue;
                d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }
    return d; // d[i][i] < 0이면 음수 사이클 존재
}
```

유한 거리 합이 long 범위를 넘지 않는 입력에 사용한다. 무방향 간선이면 초기화 때 반대 방향도 저장한다.

### Union-Find
경로 압축 + rank 합치기. 연산당 분할 상환 O(α(V)), 공간 O(V).
```java
static class UnionFind {
    int[] parent, rank;
    UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean merge(int x, int y) {
        int a = find(x), b = find(y);
        if (a == b) return false;
        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a; // 반드시 루트끼리 연결
            rank[a]++;
        }
        return true;
    }
}
```

rank는 경로 압축 후 실제 높이와 항상 같지는 않다. 방향 그래프의 사이클 판별에는 이 단순 병합 방식을 그대로 적용하지 않는다.

### 위상 정렬
0-based 방향 그래프, O(V + E). 반환된 순서가 전체 정점 수보다 짧으면 사이클이 있다.
```java
static List<Integer> topological(List<List<Integer>> graph) {
    int n = graph.size();
    int[] degree = new int[n];
    for (List<Integer> nexts : graph) {
        for (int v : nexts) degree[v]++;
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (degree[i] == 0) q.offer(i);
    List<Integer> order = new ArrayList<>();
    while (!q.isEmpty()) {
        int u = q.poll();
        order.add(u);
        for (int v : graph.get(u)) {
            if (--degree[v] == 0) q.offer(v); // 선수 조건 해소
        }
    }
    return order;
}
```

### 최소 신장 트리: Kruskal
무방향 그래프 전체 연결의 최소 비용. 간선 비용 정렬 후 서로 다른 집합만 연결한다. O(E log E + V), 공간 O(V)에 정렬 보조 공간이 추가된다.
```java
static long kruskal(int n, int[][] edges) {
    // 1-based 정점, {출발, 도착, 비용}; n >= 1
    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
    UnionFind uf = new UnionFind(n);
    long total = 0;
    int used = 0;
    for (int[] e : edges) {
        if (uf.merge(e[0], e[1])) {
            total += e[2];
            if (++used == n - 1) break;
        }
    }
    if (used != n - 1) throw new IllegalArgumentException("연결되지 않은 그래프");
    return total;
}
```

## 완전탐색과 DP
### 순열·조합·부분집합
서로 다른 값으로 구성된 a를 가정한다. 선택 후 재귀를 호출하고 선택을 취소한다. 결과에는 cur 자체 대신 복사본을 넣는다.

```java
static void perm(int[] a, int r, boolean[] used,
                 List<Integer> cur, List<List<Integer>> out) {
    if (cur.size() == r) {
        out.add(new ArrayList<>(cur)); // 결과 스냅샷
        return;
    }
    for (int i = 0; i < a.length; i++) {
        if (used[i]) continue;
        used[i] = true;
        cur.add(a[i]);
        perm(a, r, used, cur, out);
        cur.remove(cur.size() - 1);
        used[i] = false;
    }
}
static void comb(int[] a, int start, int r,
                 List<Integer> cur, List<List<Integer>> out) {
    if (cur.size() == r) {
        out.add(new ArrayList<>(cur));
        return;
    }
    for (int i = start; i <= a.length - (r - cur.size()); i++) {
        cur.add(a[i]);
        comb(a, i + 1, r, cur, out); // 현재 i 다음부터 선택
        cur.remove(cur.size() - 1);
    }
}
static void subsets(int[] a, int start,
                    List<Integer> cur, List<List<Integer>> out) {
    out.add(new ArrayList<>(cur));
    for (int i = start; i < a.length; i++) {
        cur.add(a[i]);
        subsets(a, i + 1, cur, out);
        cur.remove(cur.size() - 1);
    }
}
```

호출 시 cur와 out은 빈 리스트, 순열 used는 new boolean[a.length], start는 0이다. 순열·조합은 0 <= r <= a.length 전제. 전체 순열 출력은 O(n×n!), 부분집합 출력은 O(n×2^n), r개 조합은 출력 복사만 O(r×C(n,r))다. 중복 입력은 별도 중복 제거 규칙이 필요하다.

### 그리디
정렬 순서·현재 선택이 이후 선택을 망치지 않는 근거를 먼저 세운다. 큰 동전부터 쓰는 방법은 모든 동전 체계에서 최적이 아니다. 동전 {4,3,1}, 목표 6에서는 4+1+1보다 3+3이 적다. 문제마다 교환 논증·불변식 등을 확인한다. [LC55 기록](../../solutions/leetcode/0055-jump-game/README.md).

### DP
상태의 의미 → 초기값 → 전이 → 계산 순서 → 답 위치 순으로 정의한다. 0/1 배낭은 각 물건을 한 번만 쓰므로 용량을 내림차순으로 순회한다.
```java
static long knapsack(int capacity, int[] weight, int[] value) {
    long[] dp = new long[capacity + 1]; // 용량 w 이하에서 최대 가치
    for (int i = 0; i < weight.length; i++) {
        for (int w = capacity; w >= weight[i]; w--) {
            dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
        }
    }
    return dp[capacity];
}
```

물건 무게는 양수, 두 배열 길이는 같다고 가정한다. 시간 O(n×capacity), 공간 O(capacity). 무제한 사용은 순회 방향이 달라진다. 정확히 채워야 하는 상태라면 도달 불가능 값을 따로 두어야 한다. 피보나치 계열도 n=0 경계와 결과 수치 범위를 확인한다.

## 연결 리스트와 트리
이중 연결 리스트는 노드의 prev/next 및 head/tail을 함께 갱신한다. 이미 노드 참조가 있으면 삭제 O(1), 값을 찾아 삭제하면 검색 O(n)이다.

```java
static class Link {
    int value;
    Link prev, next;
}
static class DoublyList {
    Link head, tail;
    void addLast(int value) {
        Link node = new Link();
        node.value = value;
        node.prev = tail;
        if (tail == null) head = node;
        else tail.next = node;
        tail = node;
    }
    void delete(Link node) { // 이 리스트에 속한 유효한 노드 전제
        if (node.prev == null) head = node.next;
        else node.prev.next = node.next;
        if (node.next == null) tail = node.prev;
        else node.next.prev = node.prev;
        node.prev = node.next = null;
    }
}
static class TreeNode {
    int value;
    TreeNode left, right;
    TreeNode(int value) { this.value = value; }
}
static int depth(TreeNode root) {
    if (root == null) return 0; // 빈 트리
    return 1 + Math.max(depth(root.left), depth(root.right));
}
```

전위는 현재→왼쪽→오른쪽, 중위는 왼쪽→현재→오른쪽, 후위는 왼쪽→오른쪽→현재다. 일반 이진 트리에는 정렬 조건이 없고, 이진 탐색 트리는 왼쪽·오른쪽 값의 순서 조건이 있다. 단순 BST 삽입·검색은 높이 O(h), 편향되면 O(n)이다. 트리 깊이 탐색은 O(V), 재귀 공간 O(h). [LC104 두 구현](../../solutions/leetcode/0104-maximum-depth-of-binary-tree/README.md).

## 제출 전 점검
- 배열.length / 문자열.length() / 컬렉션.size() 구분.
- 0-based와 1-based, 닫힌 구간과 반열린 구간 확인.
- 합·곱·거리 계산 전에 long 승격. INF에 덧셈하지 않기.
- 빈 큐의 null 언박싱, 빈 리스트 인덱스 접근 확인.
- BFS는 삽입 시 방문, 다익스트라는 최소 거리 추출 시 확정.
- Union-Find는 원소가 아닌 루트끼리 연결.
- 재귀 상태 복구 및 결과 복사, 여러 테스트 간 상태 초기화.
- 정렬이 입력을 변경해도 되는지, Comparator가 일관되는지 확인.
- 음수가 있는 합 문제에서 포인터 이동의 단조성을 가정하지 않기.
- 파일 존재·로컬 테스트와 실제 온라인 채점 통과를 구분.

## 공식 API 참고
API 설명은 Java 17 공식 문서 기준으로 확인했다. 알고리즘 코드는 학습용 예제로, 각 절의 입력 조건을 적용한다.
- [Arrays](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html)
- [ArrayList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)
- [Map](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)
- [Deque](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Deque.html)
- [PriorityQueue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html)
- [TreeSet](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeSet.html)

[문제집으로 돌아가기](../leetcode/problemset.md)
