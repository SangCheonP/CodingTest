# CodingTest

[학습순서](#study-order) · [진행 현황](#progress) · [알고리즘 정리](#algorithms)

<a id="study-order"></a>

## 학습순서

순서·유형 클릭 → 아래 해당 현황. 현황의 **코드** 클릭 → Java 풀이.

| 구분 | 문제집 순서 | 유형 | 최초 통과 |
|---|---|---|---|
| 기본 1 | [1~6](#stage-01) | [배열·문자열·해시](#stage-01) | 5 / 6 |
| 기본 2 | [7~12](#stage-02) | [정렬·구간·스택](#stage-02) | 5 / 6 |
| 기본 3 | [13~18](#stage-03) | [격자 구현·시뮬레이션](#stage-03) | 1 / 6 |
| 기본 4 | [19~24](#stage-04) | [DFS·연결요소](#stage-04) | 1 / 6 |
| 기본 5 | [25~30](#stage-05) | [BFS·최단거리](#stage-05) | 1 / 6 |
| 기본 6 | [31~36](#stage-06) | [완전탐색·백트래킹](#stage-06) | 1 / 6 |
| 기본 7 | [37~42](#stage-07) | [투포인터·윈도우·누적합](#stage-07) | 2 / 6 |
| 기본 8 | [43~48](#stage-08) | [이분탐색·그리디](#stage-08) | 2 / 6 |
| 기본 9 | [49~54](#stage-09) | [힙·위상정렬·유니온파인드](#stage-09) | 3 / 6 |
| 기본 10 | [55~60](#stage-10) | [가중 그래프·트리](#stage-10) | 2 / 6 |
| 기본 11 | [61~66](#stage-11) | [DP 기초](#stage-11) | 1 / 6 |
| 기본 12 | [67~72](#stage-12) | [DP 심화·복합 구현](#stage-12) | 0 / 6 |
| 확장 1 | [73~78](#stage-13) | [확장 A · 탐색·자료구조](#stage-13) | 0 / 6 |
| 확장 2 | [79~84](#stage-14) | [확장 B · 완전탐색·BFS](#stage-14) | 0 / 6 |
| 확장 3 | [85~90](#stage-15) | [확장 C · 그래프·DP](#stage-15) | 0 / 6 |
| 확장 4 | [91~96](#stage-16) | [확장 D · DP·상태 구현](#stage-16) | 0 / 6 |

<a id="progress"></a>

## 진행 현황

✅ 최초 통과 · ☐ 미풀이 또는 채점 미확인 · 독립 재풀이는 별도 표시

문제 제목 → LeetCode · **코드 → Java 풀이** · 풀이 → 풀이 노트

<a id="stage-01"></a>

### 1단계 — 배열·문자열·해시

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 1 | [1. Two Sum](https://leetcode.com/problems/two-sum/) | E | ✅ | ☐ | 2026-10-02 / 20분 · [풀이](solutions/leetcode/0001-two-sum/README.md) | [코드](solutions/leetcode/0001-two-sum/Solution.java) |
| 2 | [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/) | E | ✅ | ☐ | 2026-10-02 / 20분 | 미등록 |
| 3 | [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | E | ☐ | ☐ | 2026-10-03 / 미기록 / 힌트 사용·채점 미확인 · [풀이](solutions/leetcode/0217-contains-duplicate/README.md) | [코드](solutions/leetcode/0217-contains-duplicate/Solution.java) |
| 4 | [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) | E | ✅ | ☐ | 2026-10-06 / 20분 / 정답·접근 직접 설명 · [풀이](solutions/leetcode/0387-first-unique-character-in-a-string/README.md) | [코드](solutions/leetcode/0387-first-unique-character-in-a-string/Solution.java) |
| 5 | [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/) | M | ✅ | ☐ | 2026-10-07 / 20분 / 정답 · [풀이](solutions/leetcode/0049-group-anagrams/README.md) | [코드](solutions/leetcode/0049-group-anagrams/Solution.java) |
| 6 | [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | M | ✅ | ☐ | 2026-10-07 / 30분 / 정답·힌트 사용·복습 대상 · [풀이](solutions/leetcode/0128-longest-consecutive-sequence/README.md) | [코드](solutions/leetcode/0128-longest-consecutive-sequence/Solution.java) |

<a id="stage-02"></a>

### 2단계 — 정렬·구간·스택

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 7 | [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | E | ✅ | ☐ | 2026-10-08 / 20분 / 원본 정답·코드 정리 · [풀이](solutions/leetcode/0020-valid-parentheses/README.md) | [코드](solutions/leetcode/0020-valid-parentheses/Solution.java) |
| 8 | [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | E | ✅ | ☐ | 2026-10-12 / 20분 / 정답 · [풀이](solutions/leetcode/1047-remove-all-adjacent-duplicates-in-string/README.md) | [코드](solutions/leetcode/1047-remove-all-adjacent-duplicates-in-string/Solution.java) |
| 9 | [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/) | M | ✅ | ☐ | 2026-10-12 / 30분 / 정답 · [풀이](solutions/leetcode/0056-merge-intervals/README.md) | [코드](solutions/leetcode/0056-merge-intervals/Solution.java) |
| 10 | [57. Insert Interval](https://leetcode.com/problems/insert-interval/) | M | ✅ | ☐ | 2026-10-13 / 약 30분 / 정답·PQ에서 순회로 개선 · [풀이](solutions/leetcode/0057-insert-interval/README.md) | [코드](solutions/leetcode/0057-insert-interval/Solution.java) |
| 11 | [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | M | ☐ | ☐ | | 미등록 |
| 12 | [394. Decode String](https://leetcode.com/problems/decode-string/) | M | ✅ | ☐ | 2026-10-15 / 약 60분 / 정답·힌트 사용·닫는 괄호 처리 피드백 · [풀이](solutions/leetcode/0394-decode-string/README.md) | [코드](solutions/leetcode/0394-decode-string/Solution.java) |

<a id="stage-03"></a>

### 3단계 — 격자 구현·시뮬레이션

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 13 | [48. Rotate Image](https://leetcode.com/problems/rotate-image/) | M | ✅ | ☐ | 2026-10-17 / 약 60분 / 정답·반복문 경계 피드백 · [풀이](solutions/leetcode/0048-rotate-image/README.md) | [코드](solutions/leetcode/0048-rotate-image/Solution.java) |
| 14 | [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | M | ☐ | ☐ | | 미등록 |
| 15 | [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/) | M | ☐ | ☐ | | 미등록 |
| 16 | [289. Game of Life](https://leetcode.com/problems/game-of-life/) | M | ☐ | ☐ | | 미등록 |
| 17 | [59. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | M | ☐ | ☐ | | 미등록 |
| 18 | [885. Spiral Matrix III](https://leetcode.com/problems/spiral-matrix-iii/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-04"></a>

### 4단계 — DFS·연결요소

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 19 | [733. Flood Fill](https://leetcode.com/problems/flood-fill/) | E | ✅ | ☐ | 2026-10-18 / 20분 / 정답·독립 해결·힌트 미사용·풀이 후 개선 · [풀이](solutions/leetcode/0733-flood-fill/README.md) | [코드](solutions/leetcode/0733-flood-fill/Solution.java) |
| 20 | [200. Number of Islands](https://leetcode.com/problems/number-of-islands/) | M | ☐ | ☐ | | 미등록 |
| 21 | [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | M | ☐ | ☐ | | 미등록 |
| 22 | [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/) | M | ☐ | ☐ | | 미등록 |
| 23 | [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | M | ☐ | ☐ | | 미등록 |
| 24 | [785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-05"></a>

### 5단계 — BFS·최단거리

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 25 | [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | M | ✅ | ☐ | 2026-10-20 / 20분 / 정답·독립 해결·힌트 미사용·공유본 오타 수정 · [풀이](solutions/leetcode/0994-rotting-oranges/README.md) | [코드](solutions/leetcode/0994-rotting-oranges/Solution.java) |
| 26 | [542. 01 Matrix](https://leetcode.com/problems/01-matrix/) | M | ☐ | ☐ | | 미등록 |
| 27 | [1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | M | ☐ | ☐ | | 미등록 |
| 28 | [1926. Nearest Exit from Entrance in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/) | M | ☐ | ☐ | | 미등록 |
| 29 | [752. Open the Lock](https://leetcode.com/problems/open-the-lock/) | M | ☐ | ☐ | | 미등록 |
| 30 | [934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-06"></a>

### 6단계 — 완전탐색·백트래킹

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 31 | [78. Subsets](https://leetcode.com/problems/subsets/) | M | ✅ | ☐ | 2026-10-19 / 30분 / 정답·인덱스 실수 수정 · [풀이](solutions/leetcode/0078-subsets/README.md) | [코드](solutions/leetcode/0078-subsets/Solution.java) |
| 32 | [77. Combinations](https://leetcode.com/problems/combinations/) | M | ☐ | ☐ | | 미등록 |
| 33 | [46. Permutations](https://leetcode.com/problems/permutations/) | M | ☐ | ☐ | | 미등록 |
| 34 | [39. Combination Sum](https://leetcode.com/problems/combination-sum/) | M | ☐ | ☐ | | 미등록 |
| 35 | [79. Word Search](https://leetcode.com/problems/word-search/) | M | ☐ | ☐ | | 미등록 |
| 36 | [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-07"></a>

### 7단계 — 투포인터·윈도우·누적합

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 37 | [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | M | ✅ | ☐ | 2026-10-18 / 20분 / 정답·설명 참고 후 공간복잡도 개선 · [풀이](solutions/leetcode/0167-two-sum-ii-input-array-is-sorted/README.md) | [코드](solutions/leetcode/0167-two-sum-ii-input-array-is-sorted/Solution.java) |
| 38 | [15. 3Sum](https://leetcode.com/problems/3sum/) | M | ☐ | ☐ | | 미등록 |
| 39 | [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | M | ☐ | ☐ | | 미등록 |
| 40 | [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | M | ☐ | ☐ | | 미등록 |
| 41 | [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | M | ✅ | ☐ | 2026-10-21 / 30분 / 정답·힌트 사용·복습 연기 · [풀이](solutions/leetcode/0560-subarray-sum-equals-k/README.md) | [코드](solutions/leetcode/0560-subarray-sum-equals-k/Solution.java) |
| 42 | [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-08"></a>

### 8단계 — 이분탐색·그리디

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 43 | [704. Binary Search](https://leetcode.com/problems/binary-search/) | E | ✅ | ☐ | 2026-10-15 / 10분 / 정답 · [풀이](solutions/leetcode/0704-binary-search/README.md) | [코드](solutions/leetcode/0704-binary-search/Solution.java) |
| 44 | [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/) | E | ☐ | ☐ | | 미등록 |
| 45 | [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | M | ☐ | ☐ | | 미등록 |
| 46 | [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | M | ☐ | ☐ | | 미등록 |
| 47 | [55. Jump Game](https://leetcode.com/problems/jump-game/) | M | ✅ | ☐ | 2026-10-20 / 약 30분 / 정답·힌트 사용 후 그리디로 개선 · [풀이](solutions/leetcode/0055-jump-game/README.md) | [코드](solutions/leetcode/0055-jump-game/Solution.java) |
| 48 | [134. Gas Station](https://leetcode.com/problems/gas-station/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-09"></a>

### 9단계 — 힙·위상정렬·유니온파인드

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 49 | [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | M | ✅ | ☐ | 2026-10-19 / 약 10분 / 정답·독립 해결·힌트 미사용 · [풀이](solutions/leetcode/0215-kth-largest-element-in-an-array/README.md) | [코드](solutions/leetcode/0215-kth-largest-element-in-an-array/Solution.java) |
| 50 | [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | M | ☐ | ☐ | | 미등록 |
| 51 | [207. Course Schedule](https://leetcode.com/problems/course-schedule/) | M | ✅ | ☐ | 2026-10-22 / 약 30분 / 정답·독립 해결·힌트 미사용 · [풀이](solutions/leetcode/0207-course-schedule/README.md) | [코드](solutions/leetcode/0207-course-schedule/Solution.java) |
| 52 | [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | M | ☐ | ☐ | | 미등록 |
| 53 | [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/) | M | ✅ | ☐ | 2026-10-22 / 30분 / 정답·독립 해결·힌트 미사용 · [풀이](solutions/leetcode/0684-redundant-connection/README.md) | [코드](solutions/leetcode/0684-redundant-connection/Solution.java) |
| 54 | [721. Accounts Merge](https://leetcode.com/problems/accounts-merge/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-10"></a>

### 10단계 — 가중 그래프·트리

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 55 | [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/) | M | ✅ | ☐ | 2026-10-23 / 40분 / 정답·다익스트라 코드 큰 틀 참고·visited 방식 · [풀이](solutions/leetcode/0743-network-delay-time/README.md) | [코드](solutions/leetcode/0743-network-delay-time/Solution.java) |
| 56 | [1631. Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/) | M | ☐ | ☐ | | 미등록 |
| 57 | [1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | M | ☐ | ☐ | | 미등록 |
| 58 | [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | E | ✅ | ☐ | 2026-10-21 / 30분 / 정답·힌트 사용·재귀 및 BFS · [풀이](solutions/leetcode/0104-maximum-depth-of-binary-tree/README.md) | [재귀](solutions/leetcode/0104-maximum-depth-of-binary-tree/Solution.java) · [BFS](solutions/leetcode/0104-maximum-depth-of-binary-tree/SolutionBfs.java) |
| 59 | [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | M | ☐ | ☐ | | 미등록 |
| 60 | [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-11"></a>

### 11단계 — DP 기초

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 61 | [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | E | ✅ | ☐ | 2026-10-17 / 20분 / 정답·독립 해결·힌트 미사용 · [풀이](solutions/leetcode/0070-climbing-stairs/README.md) | [코드](solutions/leetcode/0070-climbing-stairs/Solution.java) |
| 62 | [198. House Robber](https://leetcode.com/problems/house-robber/) | M | ☐ | ☐ | | 미등록 |
| 63 | [62. Unique Paths](https://leetcode.com/problems/unique-paths/) | M | ☐ | ☐ | | 미등록 |
| 64 | [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | M | ☐ | ☐ | | 미등록 |
| 65 | [322. Coin Change](https://leetcode.com/problems/coin-change/) | M | ☐ | ☐ | | 미등록 |
| 66 | [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-12"></a>

### 12단계 — DP 심화·복합 구현

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 67 | [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | M | ☐ | ☐ | | 미등록 |
| 68 | [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | M | ☐ | ☐ | | 미등록 |
| 69 | [139. Word Break](https://leetcode.com/problems/word-break/) | M | ☐ | ☐ | | 미등록 |
| 70 | [91. Decode Ways](https://leetcode.com/problems/decode-ways/) | M | ☐ | ☐ | | 미등록 |
| 71 | [146. LRU Cache](https://leetcode.com/problems/lru-cache/) | M | ☐ | ☐ | | 미등록 |
| 72 | [874. Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/) | E | ☐ | ☐ | | 미등록 |

<a id="stage-13"></a>

### 확장 A: 탐색·자료구조

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 73 | [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/) | M | ☐ | ☐ | | 미등록 |
| 74 | [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/) | M | ☐ | ☐ | | 미등록 |
| 75 | [853. Car Fleet](https://leetcode.com/problems/car-fleet/) | M | ☐ | ☐ | | 미등록 |
| 76 | [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | M | ☐ | ☐ | | 미등록 |
| 77 | [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | M | ☐ | ☐ | | 미등록 |
| 78 | [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-14"></a>

### 확장 B: 완전탐색·BFS

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 79 | [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | M | ☐ | ☐ | | 미등록 |
| 80 | [93. Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | M | ☐ | ☐ | | 미등록 |
| 81 | [473. Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/) | M | ☐ | ☐ | | 미등록 |
| 82 | [51. N-Queens](https://leetcode.com/problems/n-queens/) | H | ☐ | ☐ | | 미등록 |
| 83 | [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | M | ☐ | ☐ | | 미등록 |
| 84 | [127. Word Ladder](https://leetcode.com/problems/word-ladder/) | H | ☐ | ☐ | | 미등록 |

<a id="stage-15"></a>

### 확장 C: 그래프·DP

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 85 | [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | M | ☐ | ☐ | | 미등록 |
| 86 | [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | M | ☐ | ☐ | | 미등록 |
| 87 | [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/) | M | ☐ | ☐ | | 미등록 |
| 88 | [802. Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | M | ☐ | ☐ | | 미등록 |
| 89 | [72. Edit Distance](https://leetcode.com/problems/edit-distance/) | M | ☐ | ☐ | | 미등록 |
| 90 | [494. Target Sum](https://leetcode.com/problems/target-sum/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-16"></a>

### 확장 D: DP·상태 구현

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 91 | [518. Coin Change II](https://leetcode.com/problems/coin-change-ii/) | M | ☐ | ☐ | | 미등록 |
| 92 | [221. Maximal Square](https://leetcode.com/problems/maximal-square/) | M | ☐ | ☐ | | 미등록 |
| 93 | [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | M | ☐ | ☐ | | 미등록 |
| 94 | [1140. Stone Game II](https://leetcode.com/problems/stone-game-ii/) | M | ☐ | ☐ | | 미등록 |
| 95 | [2007. Find Original Array From Doubled Array](https://leetcode.com/problems/find-original-array-from-doubled-array/) | M | ☐ | ☐ | | 미등록 |
| 96 | [1041. Robot Bounded In Circle](https://leetcode.com/problems/robot-bounded-in-circle/) | M | ☐ | ☐ | | 미등록 |

[맨 위로](#codingtest)

<a id="algorithms"></a>

## 알고리즘 정리

- **기준:** Java 17
- **위치:** 메서드·내부 클래스는 `Solution` 또는 `Main` 안에 작성
- **import:** `java.util.*`, 입출력은 `java.io.*`
- **기호:** n = 원소 수, V = 정점 수, E = 간선 수
- **복잡도:** 해시는 평균, 배열 확장은 분할 상환 기준

### 목차

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

### 정렬과 배열

#### Arrays.sort와 Comparator

- **원본 변경**, 반환값 `void`
- 원래 인덱스 필요 → 정렬 전에 저장
- `Comparator`: `int[]` 불가, `Integer[]`·`int[][]` 가능

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

| 항목 | 핵심 |
|---|---|
| 비교 결과 | 음수: 앞 / 0: 동순위 / 양수: 뒤 |
| 안전한 비교 | `Integer.compare`, `Long.compare` |
| `x - y` | 오버플로 주의 |
| `Comparable` | 클래스 기본 정렬 기준 |
| `Comparator` | 사용 지점의 정렬 기준 |
| 객체 정렬 | 안정 정렬 |
| 비교 정렬 비용 | 일반적으로 O(n log n), 자료형·JDK에 따라 차이 |

#### 배열 함수

| 호출 | 동작·반환값 | 주의 |
|---|---|---|
| Arrays.fill(a, v) | 모든 칸을 v로, void | 2차원 기본형 배열은 행마다 호출 |
| Arrays.copyOf(a, len) | 길이 len인 새 배열 | 부족한 int 칸은 0 |
| Arrays.copyOfRange(a, l, r) | [l, r) 복사 | 끝 제외 |
| Arrays.equals(a, b) | 1차원 내용 비교, boolean | 2차원 내용은 deepEquals |
| Arrays.toString(a) | 1차원 출력 문자열 | 2차원은 deepToString |
| Arrays.binarySearch(a, x) | 있으면 인덱스 | 정렬 필수, 중복의 첫 위치 보장 없음 |

- 실패 반환값: `-(삽입 위치) - 1`
- `pos < 0`이면 삽입 위치: `-pos - 1`
- 검색 O(log n), 복사·채우기·내용 비교 O(n)

```java
int[][] matrix = {{1, 2}, {3, 4}};
int[][] copy = new int[matrix.length][];
for (int i = 0; i < matrix.length; i++) {
    copy[i] = matrix[i].clone(); // 각 행을 따로 복사
}
// matrix.clone()만 하면 내부 행은 공유된다.
```

### 문자열과 수치

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

- 뒤 추가: 추가 문자 수에 비례, 확장 비용은 분할 상환
- 중간 삽입·삭제: O(n)
- `toString()`: O(n) 복사

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

### 자료구조 API

#### 빠른 선택

| 목적 | 기본 선택 | 대표 비용 |
|---|---|---|
| 인덱스 접근·뒤 추가 | ArrayList | get/set O(1), 뒤 add 분할 상환 O(1) |
| 중복 제거·존재 검사 | HashSet | add/contains/remove 평균 O(1) |
| 키별 값·빈도 | HashMap | get/put/remove 평균 O(1) |
| 삽입 순서 유지 | LinkedHashMap, LinkedHashSet | 해시 연산 평균 O(1) |
| 정렬된 키·이웃 찾기 | TreeMap, TreeSet | 기본 검색·삽입·삭제 O(log n) |
| 스택·FIFO 큐·덱 | ArrayDeque | 양 끝 연산 분할 상환 O(1) |
| 최솟값·최댓값 반복 추출 | PriorityQueue | offer/poll O(log n), peek O(1) |

#### List

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

- 인덱스 접근: `ArrayList` O(1), `LinkedList` O(n)
- 순회 중 삭제: `Iterator.remove()` 사용

#### Map과 Set

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

- 배열 키: **내용이 아닌 참조 기준** 비교
- 사용자 정의 키: `equals`·`hashCode` 함께 구현
- 저장 후 키의 비교 필드 변경 금지

| TreeSet API | 반환 원소 |
|---|---|
| `lower(x)` | x 미만 중 최대 |
| `floor(x)` | x 이하 중 최대 |
| `ceiling(x)` | x 이상 중 최소 |
| `higher(x)` | x 초과 중 최소 |

- 해당 원소 없음 → `null`
- `TreeMap`: `lowerKey` 등 대응 API
- 빈 집합의 `first/last` → 예외
- 비교 결과 0 → 같은 원소로 취급

#### Queue·Deque·Stack

| 목적 | 추가 | 제거하며 반환 | 조회만 |
|---|---|---|---|
| FIFO 큐 | offer(x) | poll() | peek() |
| 덱 앞 | offerFirst(x) | pollFirst() | peekFirst() |
| 덱 뒤 | offerLast(x) | pollLast() | peekLast() |
| 스택 | push(x) | pop() | peek() |

- 빈 자료구조: `poll/peek` → `null`, `pop/removeFirst/getFirst` → 예외
- `null`을 `int`로 받으면 예외
- `ArrayDeque`: `null` 저장 불가
- 스택 기본 선택: `Deque`

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

#### PriorityQueue

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
PriorityQueue<int[]> jobs = new PriorityQueue<>(
    (a, b) -> Integer.compare(a[1], b[1])); // 두 번째 값이 작은 순서

jobs.offer(new int[]{5, 20});
int[] firstJob = jobs.poll(); // 비어 있으면 null
```

- `offer`: 추가 성공 여부 / `poll`: 제거 후 반환 / `peek`: 조회
- `contains`, `remove(Object)`: O(n)
- for-each 순회: **정렬 순서 보장 없음**
- 동순위 처리 순서 필요 → 보조 비교 기준 추가
- 삽입 후 비교 필드 변경 → 자동 재정렬 안 됨

### 입출력과 변환

- 백준: `Main` + 표준 입출력
- LeetCode: 제공된 메서드 사용

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

- 문장·공백 보존: `readLine()`
- 대량 출력: `StringBuilder`로 모아 출력

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

### 알고리즘 선택

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

### 탐색과 구간

#### 이분 탐색

- **조건:** 오름차순 배열
- **반환:** 첫 `a[i] >= target` 위치, 없으면 `a.length`
- **시간:** O(log n)
- 정렬하면 원래 인덱스가 달라짐
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

#### 투 포인터·슬라이딩 윈도우

- **조건:** 정렬 배열의 두 수 합
- 양 끝에서 시작 → 합에 따라 한쪽 이동
- **시간:** O(n), 합은 `long` 권장

- **고정 길이:** 음수 포함 가능
- 아래 예제: 길이 k의 최대 합, `1 <= k <= a.length`
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

- **가변 길이 합 비교:** 음수가 있으면 이동 방향 보장 불가
- 반례: `[4, -1]`, 목표 3 → 4를 먼저 버리면 실패
- 양수 배열·양수 목표: 합의 단조성 활용 가능
- 0 포함: 같은 합의 여러 구간 주의
- 문자 중복 등 다른 조건: 조건 유지·복구 가능 여부 확인

#### 누적합

```java
long[] prefix = new long[a.length + 1];
for (int i = 0; i < a.length; i++) {
    prefix[i + 1] = prefix[i] + a[i];
}
long rangeSum = prefix[r] - prefix[l]; // [l, r), 질의 O(1)
```

- **목적:** 합 k인 구간 개수
- 초기값: 누적합 0의 빈도 = 1
- 순서: `현재 합 - k` 조회 → 현재 합 빈도 증가
- 조회 먼저: `k == 0`일 때 빈 구간 제외
- [LC560 풀이](solutions/leetcode/0560-subarray-sum-equals-k/README.md)

#### 정렬·구간·단조 스택

| 기법 | 핵심 | 주의 |
|---|---|---|
| 구간 병합 | 시작점 정렬 → 겹치는 끝 갱신 | 경계 포함 여부에 따라 `<`, `<=` 선택 |
| 단조 스택 | 증가·감소 순서 유지 | 같은 값 제거 여부 확인 |

단조 스택: 각 원소 최대 1회 삽입·제거 → O(n).

### 그래프

#### 표현·DFS·BFS

```java
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
for (int[] e : edges) {
    graph.get(e[0]).add(e[1]); // 방향 그래프
    // 무방향이면 graph.get(e[1]).add(e[0])도 추가
}
```

- **기준:** 0-based 인접 리스트
- **시간:** O(V + E)
- 재귀가 깊으면 반복형 탐색 고려
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

- 격자 방향: `dr = {1,-1,0,0}`, `dc = {0,0,1,-1}`
- 다음 칸: `dr[d]`, `dc[d]` 사용
- 검사: 범위 → 이동 조건 → 방문 여부
- 다중 시작점: 시작점 모두 거리 0으로 큐에 삽입
- 레벨 처리: 시작 시 `q.size()` 저장 → 그 개수만 처리

#### 다익스트라

- **조건:** 모든 가중치 ≥ 0
- **기준:** 1-based
- 간선: `int[]{도착, 비용}`
- 큐: `long[]{정점, 누적 거리}`
- 유한 거리·덧셈 결과는 `INF` 미만

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

- 두 번째 방식 사용 시 `visited` 선언·검사·설정 제거
- 두 방식 모두 가능, `visited`가 항상 더 빠르지는 않음
- **방문 확정: 큐에서 꺼낼 때**
- **시간:** O(V + E log(E + 1)) / **공간:** O(V + E)
- [LC743 최종 코드](solutions/leetcode/0743-network-delay-time/Solution.java)

#### 플로이드-워셜

- **목적:** 작은 그래프의 모든 쌍 최단거리
- **시간:** O(V³) / **공간:** O(V²)
- 음수 간선 가능, 음수 사이클의 영향을 받는 최단거리는 정의 불가

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

- 거리 합: `long` 범위 확인
- 무방향 간선: 반대 방향도 초기화

#### Union-Find

- **기법:** 경로 압축 + rank 합치기
- **연산:** 분할 상환 O(α(V)) / **공간:** O(V)
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

- 경로 압축 후 `rank` ≠ 실제 높이일 수 있음
- 방향 그래프 사이클 판별에 그대로 적용 금지

#### 위상 정렬

- **기준:** 0-based 방향 그래프
- **시간:** O(V + E)
- 결과 개수 < 정점 수 → 사이클 존재
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

#### 최소 신장 트리: Kruskal

- **목적:** 무방향 그래프 전체 연결의 최소 비용
- 비용순 정렬 → 서로 다른 집합만 연결
- **시간:** O(E log E + V)
- **공간:** O(V) + 정렬 보조 공간
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

### 완전탐색과 DP

#### 순열·조합·부분집합

- **조건:** 배열 a의 값은 서로 다름
- 선택 → 재귀 → 선택 취소
- 결과 저장: `new ArrayList<>(cur)`로 복사

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

- 초기값: `cur/out` 빈 리스트, `used = new boolean[a.length]`, `start = 0`
- 순열·조합 조건: `0 <= r <= a.length`
- 중복 입력: 별도 중복 제거 필요

| 출력 | 비용 |
|---|---|
| 전체 순열 | O(n×n!) |
| 부분집합 | O(n×2^n) |
| r개 조합 | 결과 복사만 O(r×C(n,r)) |

#### 그리디

- 현재 선택이 전체 최적을 보장하는지 확인
- 큰 동전 우선이 항상 정답은 아님
- 반례: `{4,3,1}`, 목표 6 → `4+1+1`보다 `3+3`
- 증명 도구: 교환 논증·불변식
- [LC55 기록](solutions/leetcode/0055-jump-game/README.md)

#### DP

- 설계: **상태 → 초기값 → 전이 → 계산 순서 → 답**
- 0/1 배낭: 물건당 1회 사용 → 용량 내림차순
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

- **조건:** 무게 > 0, 두 배열 길이 동일
- **시간:** O(n×capacity) / **공간:** O(capacity)
- 무제한 사용: 순회 방향 변경
- 정확히 채우기: 도달 불가능 상태 별도 표시
- 피보나치 계열: `n = 0`과 수치 범위 확인

### 연결 리스트와 트리

- 변경 대상: `prev/next`와 `head/tail`
- 노드 참조 있음: 삭제 O(1)
- 값으로 찾기: 검색 O(n)

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

| 순회 | 순서 |
|---|---|
| 전위 | 현재 → 왼쪽 → 오른쪽 |
| 중위 | 왼쪽 → 현재 → 오른쪽 |
| 후위 | 왼쪽 → 오른쪽 → 현재 |

- 일반 이진 트리: 정렬 조건 없음
- 이진 탐색 트리: 왼쪽·오른쪽 값의 순서 조건 존재
- 단순 BST 삽입·검색: O(h), 편향 시 O(n)
- 깊이 탐색: 시간 O(V), 재귀 공간 O(h)
- [LC104 두 구현](solutions/leetcode/0104-maximum-depth-of-binary-tree/README.md)

### 제출 전 점검

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

### 공식 API 참고

Java 17 공식 API. 알고리즘 예제는 각 절의 입력 조건 확인.
- [Arrays](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html)
- [ArrayList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)
- [Map](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)
- [Deque](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Deque.html)
- [PriorityQueue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html)
- [TreeSet](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeSet.html)

[맨 위로](#codingtest)
