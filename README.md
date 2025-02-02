# CodingTest

## 주로 출제되는 알고리즘

- 해시
- 스택/큐
- 힙
```
PriorityQueue<> pq = new PriorityQueue<>();
```
  - 최대
  - 최소
- 정렬
```
Collections.sort(?, Collections.reverseOrder());
```
- 완전탐색
- 탐욕법
- DP
- DFS/BFS
- 이분탐색
- 그래프
- 순열
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
