# 대기업 코딩테스트 대비 LeetCode 문제집 v1
작성 기준: 2026-09-30 · 카카오/라인/네이버 제외 · 기본 72문제 + 확장 24문제

[학습 홈](../../README.md) · [풀이 저장 방법](../../solutions/leetcode/README.md) · [오답 기록 양식](../../templates/solution-note.md)

선정 근거와 기업별 보완 방법은 [참고 자료](references.md)에 정리했다.

## 매일 어떻게 풀까?
### 추천: 12주 과정
각 단계는 6문제다. 월~토는 표의 순서대로 새 문제 1개를 푼다. 두 번째 문제는 3일 또는 7일 전 틀렸던 문제를 복습한다. 첫 주 초반에는 복습 대상이 없으면 1개만 풀어도 된다. 일요일은 새 문제 없이 오답 1~2개를 풀고 기록을 정리한다.
- Easy: 먼저 20~30분, Medium: 먼저 40~60분 고민한다. 처음 배우는 유형은 해설 학습을 포함해 하루 60~90분까지 허용한다.
- 제한시간에 접근이 안 나오면 작은 힌트를 확인하고 다시 시도한다. 해설을 본 문제는 '학습'으로 기록하고 다음 날 빈 화면에서 다시 구현한다.
- 어렵고 긴 문제를 푼 날은 1문제로 끝낸다. 밀린 문제를 다음 날 모두 몰아 풀지 않는다.
- 이미 혼자 풀 수 있는 문제는 복습 처리하고 다음 순서로 넘어가도 된다.

### 빠른 과정: 6주
월~토 새 문제 2개, 일요일 오답 1~2개. 기본 72문제를 6주에 끝낸다. Medium 두 개가 90분을 넘어가거나 해설 의존이 이어지면 추천 과정으로 전환한다. 확장 24문제는 추천 속도로 4주, 빠른 속도로 2주 추가한다.

## 권장 순서와 체크리스트
E=Easy / M=Medium / H=Hard. 문제 제목을 누르면 LeetCode로 이동한다. 기본 문제는 1~72번, 확장 문제는 73~96번이다.

- 최초 통과: LeetCode 채점 통과 시 ✅, 미통과 또는 채점 미확인 시 ☐.
- 독립 재풀이: 힌트·해설 없이 다시 풀어 채점 통과 시 ✅, 그 전에는 ☐.
- 기록: 날짜는 YYYY-MM-DD, 시간은 20분 형식으로 적는다. 모르는 시간은 미기록으로 남긴다.
- 표에는 날짜·시간·짧은 결과·풀이 링크만 적고, 오답 원인과 반례는 문제별 README에 기록한다.

각 단계 제목은 학습용 힌트이므로 실전 연습 때에는 가리고 풀어야 한다.

### 1단계 / 추천 1주차 — 배열·문자열·해시

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 1 | [1. Two Sum](https://leetcode.com/problems/two-sum/) | E | ✅ | ☐ | 2026-10-02 / 20분 · [풀이](../../solutions/leetcode/0001-two-sum/README.md) |
| 2 | [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/) | E | ✅ | ☐ | 2026-10-02 / 20분 |
| 3 | [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | E | ☐ | ☐ | 2026-10-03 / 미기록 / 힌트 사용·채점 미확인 · [풀이](../../solutions/leetcode/0217-contains-duplicate/README.md) |
| 4 | [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) | E | ✅ | ☐ | 2026-10-06 / 20분 / 정답·접근 직접 설명 · [풀이](../../solutions/leetcode/0387-first-unique-character-in-a-string/README.md) |
| 5 | [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/) | M | ✅ | ☐ | 2026-10-07 / 20분 / 정답 · [풀이](../../solutions/leetcode/0049-group-anagrams/README.md) |
| 6 | [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | M | ✅ | ☐ | 2026-10-07 / 30분 / 정답·힌트 사용·복습 대상 · [풀이](../../solutions/leetcode/0128-longest-consecutive-sequence/README.md) |

### 2단계 / 추천 2주차 — 정렬·구간·스택

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 7 | [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | E | ✅ | ☐ | 2026-10-08 / 20분 / 원본 정답·코드 정리 · [풀이](../../solutions/leetcode/0020-valid-parentheses/README.md) |
| 8 | [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | E | ☐ | ☐ | |
| 9 | [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/) | M | ☐ | ☐ | |
| 10 | [57. Insert Interval](https://leetcode.com/problems/insert-interval/) | M | ☐ | ☐ | |
| 11 | [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | M | ☐ | ☐ | |
| 12 | [394. Decode String](https://leetcode.com/problems/decode-string/) | M | ☐ | ☐ | |

### 3단계 / 추천 3주차 — 격자 구현·시뮬레이션

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 13 | [48. Rotate Image](https://leetcode.com/problems/rotate-image/) | M | ☐ | ☐ | |
| 14 | [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | M | ☐ | ☐ | |
| 15 | [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/) | M | ☐ | ☐ | |
| 16 | [289. Game of Life](https://leetcode.com/problems/game-of-life/) | M | ☐ | ☐ | |
| 17 | [59. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | M | ☐ | ☐ | |
| 18 | [885. Spiral Matrix III](https://leetcode.com/problems/spiral-matrix-iii/) | M | ☐ | ☐ | |

### 4단계 / 추천 4주차 — DFS·연결요소

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 19 | [733. Flood Fill](https://leetcode.com/problems/flood-fill/) | E | ☐ | ☐ | |
| 20 | [200. Number of Islands](https://leetcode.com/problems/number-of-islands/) | M | ☐ | ☐ | |
| 21 | [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | M | ☐ | ☐ | |
| 22 | [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/) | M | ☐ | ☐ | |
| 23 | [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | M | ☐ | ☐ | |
| 24 | [785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/) | M | ☐ | ☐ | |

### 5단계 / 추천 5주차 — BFS·최단거리

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 25 | [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | M | ☐ | ☐ | |
| 26 | [542. 01 Matrix](https://leetcode.com/problems/01-matrix/) | M | ☐ | ☐ | |
| 27 | [1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | M | ☐ | ☐ | |
| 28 | [1926. Nearest Exit from Entrance in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/) | M | ☐ | ☐ | |
| 29 | [752. Open the Lock](https://leetcode.com/problems/open-the-lock/) | M | ☐ | ☐ | |
| 30 | [934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/) | M | ☐ | ☐ | |

### 6단계 / 추천 6주차 — 완전탐색·백트래킹

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 31 | [78. Subsets](https://leetcode.com/problems/subsets/) | M | ☐ | ☐ | |
| 32 | [77. Combinations](https://leetcode.com/problems/combinations/) | M | ☐ | ☐ | |
| 33 | [46. Permutations](https://leetcode.com/problems/permutations/) | M | ☐ | ☐ | |
| 34 | [39. Combination Sum](https://leetcode.com/problems/combination-sum/) | M | ☐ | ☐ | |
| 35 | [79. Word Search](https://leetcode.com/problems/word-search/) | M | ☐ | ☐ | |
| 36 | [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | M | ☐ | ☐ | |

### 7단계 / 추천 7주차 — 투포인터·윈도우·누적합

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 37 | [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | M | ☐ | ☐ | |
| 38 | [15. 3Sum](https://leetcode.com/problems/3sum/) | M | ☐ | ☐ | |
| 39 | [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | M | ☐ | ☐ | |
| 40 | [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | M | ☐ | ☐ | |
| 41 | [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | M | ☐ | ☐ | |
| 42 | [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | M | ☐ | ☐ | |

### 8단계 / 추천 8주차 — 이분탐색·그리디

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 43 | [704. Binary Search](https://leetcode.com/problems/binary-search/) | E | ☐ | ☐ | |
| 44 | [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/) | E | ☐ | ☐ | |
| 45 | [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | M | ☐ | ☐ | |
| 46 | [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | M | ☐ | ☐ | |
| 47 | [55. Jump Game](https://leetcode.com/problems/jump-game/) | M | ☐ | ☐ | |
| 48 | [134. Gas Station](https://leetcode.com/problems/gas-station/) | M | ☐ | ☐ | |

### 9단계 / 추천 9주차 — 힙·위상정렬·유니온파인드

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 49 | [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | M | ☐ | ☐ | |
| 50 | [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | M | ☐ | ☐ | |
| 51 | [207. Course Schedule](https://leetcode.com/problems/course-schedule/) | M | ☐ | ☐ | |
| 52 | [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | M | ☐ | ☐ | |
| 53 | [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/) | M | ☐ | ☐ | |
| 54 | [721. Accounts Merge](https://leetcode.com/problems/accounts-merge/) | M | ☐ | ☐ | |

### 10단계 / 추천 10주차 — 가중 그래프·트리

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 55 | [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/) | M | ☐ | ☐ | |
| 56 | [1631. Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/) | M | ☐ | ☐ | |
| 57 | [1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | M | ☐ | ☐ | |
| 58 | [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | E | ☐ | ☐ | |
| 59 | [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | M | ☐ | ☐ | |
| 60 | [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | M | ☐ | ☐ | |

### 11단계 / 추천 11주차 — DP 기초

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 61 | [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | E | ☐ | ☐ | |
| 62 | [198. House Robber](https://leetcode.com/problems/house-robber/) | M | ☐ | ☐ | |
| 63 | [62. Unique Paths](https://leetcode.com/problems/unique-paths/) | M | ☐ | ☐ | |
| 64 | [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | M | ☐ | ☐ | |
| 65 | [322. Coin Change](https://leetcode.com/problems/coin-change/) | M | ☐ | ☐ | |
| 66 | [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | M | ☐ | ☐ | |

### 12단계 / 추천 12주차 — DP 심화·복합 구현

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 67 | [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | M | ☐ | ☐ | |
| 68 | [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | M | ☐ | ☐ | |
| 69 | [139. Word Break](https://leetcode.com/problems/word-break/) | M | ☐ | ☐ | |
| 70 | [91. Decode Ways](https://leetcode.com/problems/decode-ways/) | M | ☐ | ☐ | |
| 71 | [146. LRU Cache](https://leetcode.com/problems/lru-cache/) | M | ☐ | ☐ | |
| 72 | [874. Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/) | E | ☐ | ☐ | |

### 추가 1주차 — 확장 A: 탐색·자료구조

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 73 | [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/) | M | ☐ | ☐ | |
| 74 | [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/) | M | ☐ | ☐ | |
| 75 | [853. Car Fleet](https://leetcode.com/problems/car-fleet/) | M | ☐ | ☐ | |
| 76 | [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | M | ☐ | ☐ | |
| 77 | [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | M | ☐ | ☐ | |
| 78 | [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | M | ☐ | ☐ | |

### 추가 2주차 — 확장 B: 완전탐색·BFS

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 79 | [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | M | ☐ | ☐ | |
| 80 | [93. Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | M | ☐ | ☐ | |
| 81 | [473. Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/) | M | ☐ | ☐ | |
| 82 | [51. N-Queens](https://leetcode.com/problems/n-queens/) | H | ☐ | ☐ | |
| 83 | [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | M | ☐ | ☐ | |
| 84 | [127. Word Ladder](https://leetcode.com/problems/word-ladder/) | H | ☐ | ☐ | |

### 추가 3주차 — 확장 C: 그래프·DP

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 85 | [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | M | ☐ | ☐ | |
| 86 | [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | M | ☐ | ☐ | |
| 87 | [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/) | M | ☐ | ☐ | |
| 88 | [802. Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | M | ☐ | ☐ | |
| 89 | [72. Edit Distance](https://leetcode.com/problems/edit-distance/) | M | ☐ | ☐ | |
| 90 | [494. Target Sum](https://leetcode.com/problems/target-sum/) | M | ☐ | ☐ | |

### 추가 4주차 — 확장 D: DP·상태 구현

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 |
|---|---|---|---|---|---|
| 91 | [518. Coin Change II](https://leetcode.com/problems/coin-change-ii/) | M | ☐ | ☐ | |
| 92 | [221. Maximal Square](https://leetcode.com/problems/maximal-square/) | M | ☐ | ☐ | |
| 93 | [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | M | ☐ | ☐ | |
| 94 | [1140. Stone Game II](https://leetcode.com/problems/stone-game-ii/) | M | ☐ | ☐ | |
| 95 | [2007. Find Original Array From Doubled Array](https://leetcode.com/problems/find-original-array-from-doubled-array/) | M | ☐ | ☐ | |
| 96 | [1041. Robot Bounded In Circle](https://leetcode.com/problems/robot-bounded-in-circle/) | M | ☐ | ☐ | |

## 중간 점검과 실전 연습
24번까지: 연결요소와 방문 처리를 설명할 수 있는지 확인한다.
36번까지: 경로 탐색에서 방문 상태를 복원하는 이유와 조합 중복을 막는 방법을 확인한다.
54번까지: 복잡도를 계산하고, 사이클 검사 및 Union-Find를 빈 화면에서 구현할 수 있는지 확인한다.
72번까지: DP 상태와 전이를 설명하고, 틀린 문제를 다시 풀 수 있는지 확인한다.

4·8·12주차 일요일에는 오답 중 서로 다른 단계의 2문제를 골라 90~120분 안에 재풀이한다. 제목 외의 유형·해설은 가린다. 기억나는 정답을 재현하는 연습이므로 이것만으로 실전 성적을 추정하지 않는다. 미풀이 확장 문제 2개를 지인이 무작위로 골라주면 낯선 문제 모의시험에 쓸 수 있다. 모의시험에 사용한 확장 문제는 완료 기록을 남겨 다음 확장 주차에서 중복 부담을 줄인다.

## Java 풀이 후 점검
- 합계·곱·거리 누적값은 int 범위를 넘는지 확인하고 필요하면 long을 쓴다.
- BFS에서 방문 표시를 큐에 넣는 시점에 하는지 확인한다.
- 정렬 비교에서 a-b 대신 Integer.compare(a,b)를 사용해 오버플로를 피한다.
- DFS의 방문 배열이 전체 연결요소 탐색용인지, 현재 경로용인지 구분한다.
- 입력이 큰 재귀 탐색은 스택 깊이를 고려한다. BFS 큐는 ArrayDeque를 활용할 수 있다.
- LeetCode 함수 풀이에 익숙해진 뒤 실제 시험 방식에 맞춘 입력·출력과 다중 테스트케이스 초기화를 연습한다.

예: 방문 처리 위치를 설명하는 Java 조각
```java
// 큐에 넣을 때 방문 표시를 해야 같은 칸이 반복해서 들어가지 않습니다.
if (!visited[nr][nc]) {
    visited[nr][nc] = true;
    queue.offer(new int[]{nr, nc});
}
```
이 조각은 nr,nc의 범위와 이동 가능 여부를 이미 확인한 경우에만 사용한다.

## 오답 기록 틀
- 문제 번호:
- 결과: 독립 해결 / 힌트 / 해설 학습 / 시간초과 / 오답
- 소요 시간:
- 처음 생각한 방법과 복잡도:
- 막힌 원인: 유형 판단 / 구현 / 경계조건 / 복잡도 / Java 사용
- 틀린 입력 또는 최소 반례:
- 다음 재풀이 날짜:
- 3일 뒤 결과:
- 7일 뒤 결과:

## 다 풀면 어떻게 추가할까?
기본 72문제 이후 확장 73~96번을 순서대로 풀면 된다. 특정 유형의 오답이 반복되면 해당 확장 묶음을 먼저 풀어도 된다. Hard 2문제는 선택 도전이며 막히면 건너뛰고 다시 돌아온다.

96문제 이후에는 '완료한 LC 번호, 해설을 본 문제, 평균 풀이 시간, 지원 기업 및 시험일'을 알려주면 다음 20~30문제를 중복 없이 추가할 수 있다. 예: '기본 72번까지 끝냈고 BFS와 DP가 약해. Medium이 평균 55분 걸려. 다음 24문제를 추가해줘.'
추가 묶음은 약점 50%, 다른 유형을 섞은 문제 30%, 도전 20%를 기본 편성 기준으로 삼되 실제 성적에 맞춘다. 이는 추천 기준이지 후기에서 계산된 수치가 아니다. 저장소 링크와 완료 기록을 알려주면 이 파일에 97번부터 새 순서와 체크 항목을 이어서 넣을 수 있다.

요약: 기본 72문제를 추천 12주 동안 '새 문제 1개 + 선택 복습 1개'로 푼다. 완료 후 확장 24문제를 진행하고, 이후에는 오답과 목표 기업에 맞춰 계속 추가한다.
