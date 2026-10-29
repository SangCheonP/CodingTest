# 대기업 코딩테스트 대비 LeetCode 문제집 v1
작성 기준: 2026-09-30 · 카카오/라인/네이버 제외 · 기본 72문제 + 확장 24문제

[학습순서](../../README.md#study-order) · [알고리즘 정리](../reference/java-algorithms.md) · [풀이 저장 방법](../../solutions/leetcode/README.md) · [오답 기록 양식](../../templates/solution-note.md)

선정 근거와 기업별 보완 방법은 [참고 자료](references.md)에 정리했다.

## 학습 기준

- 평일 새 문제 1~2개, 주말 1개. 어려운 문제는 하루 1개.
- 한 사이클에서 서로 다른 알고리즘·핵심 개념을 교차 학습.
- 기본 72문제 → 확장 24문제. 표 번호는 문제집 순서이며 실제 배정 순서와 다를 수 있음.
- 새 진도 우선. 복습은 현재 사이클 이후 필요한 개념만 최소한으로 배정.
- Easy 20~30분, Medium 40~60분 독립 시도. 하루 총 60~90분 이내.

<a id="progress"></a>

## 권장 순서와 체크리스트
E=Easy / M=Medium / H=Hard. 문제 제목 → LeetCode, **코드 열 → Java 풀이**, 기록의 풀이 링크 → 풀이 노트. 코드 미등록은 채점 결과와 별개다. 기본 문제는 1~72번, 확장 문제는 73~96번이다.

- 최초 통과: LeetCode 채점 통과 시 ✅, 미통과 또는 채점 미확인 시 ☐.
- 독립 재풀이: 힌트·해설 없이 다시 풀어 채점 통과 시 ✅, 그 전에는 ☐.
- 기록: 날짜는 YYYY-MM-DD, 시간은 20분 형식으로 적는다. 모르는 시간은 미기록으로 남긴다.
- 표에는 날짜·시간·짧은 결과·풀이 링크만 적고, 오답 원인과 반례는 문제별 README에 기록한다.

각 단계 제목은 학습용 힌트이므로 실전 연습 때에는 가리고 풀어야 한다.

<a id="stage-01"></a>

### 1단계 / 추천 1주차 — 배열·문자열·해시

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 1 | [1. Two Sum](https://leetcode.com/problems/two-sum/) | E | ✅ | ☐ | 2026-10-02 / 20분 · [풀이](../../solutions/leetcode/0001-two-sum/README.md) | [코드](../../solutions/leetcode/0001-two-sum/Solution.java) |
| 2 | [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/) | E | ✅ | ☐ | 2026-10-02 / 20분 | 미등록 |
| 3 | [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | E | ☐ | ☐ | 2026-10-03 / 미기록 / 힌트 사용·채점 미확인 · [풀이](../../solutions/leetcode/0217-contains-duplicate/README.md) | [코드](../../solutions/leetcode/0217-contains-duplicate/Solution.java) |
| 4 | [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) | E | ✅ | ☐ | 2026-10-06 / 20분 / 정답·접근 직접 설명 · [풀이](../../solutions/leetcode/0387-first-unique-character-in-a-string/README.md) | [코드](../../solutions/leetcode/0387-first-unique-character-in-a-string/Solution.java) |
| 5 | [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/) | M | ✅ | ☐ | 2026-10-07 / 20분 / 정답 · [풀이](../../solutions/leetcode/0049-group-anagrams/README.md) | [코드](../../solutions/leetcode/0049-group-anagrams/Solution.java) |
| 6 | [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | M | ✅ | ☐ | 2026-10-07 / 30분 / 정답·힌트 사용·복습 대상 · [풀이](../../solutions/leetcode/0128-longest-consecutive-sequence/README.md) | [코드](../../solutions/leetcode/0128-longest-consecutive-sequence/Solution.java) |

<a id="stage-02"></a>

### 2단계 / 추천 2주차 — 정렬·구간·스택

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 7 | [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | E | ✅ | ☐ | 2026-10-08 / 20분 / 원본 정답·코드 정리 · [풀이](../../solutions/leetcode/0020-valid-parentheses/README.md) | [코드](../../solutions/leetcode/0020-valid-parentheses/Solution.java) |
| 8 | [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/) | E | ✅ | ☐ | 2026-10-12 / 20분 / 정답 · [풀이](../../solutions/leetcode/1047-remove-all-adjacent-duplicates-in-string/README.md) | [코드](../../solutions/leetcode/1047-remove-all-adjacent-duplicates-in-string/Solution.java) |
| 9 | [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/) | M | ✅ | ☐ | 2026-10-12 / 30분 / 정답 · [풀이](../../solutions/leetcode/0056-merge-intervals/README.md) | [코드](../../solutions/leetcode/0056-merge-intervals/Solution.java) |
| 10 | [57. Insert Interval](https://leetcode.com/problems/insert-interval/) | M | ✅ | ☐ | 2026-10-13 / 약 30분 / 정답·PQ에서 순회로 개선 · [풀이](../../solutions/leetcode/0057-insert-interval/README.md) | [코드](../../solutions/leetcode/0057-insert-interval/Solution.java) |
| 11 | [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | M | ☐ | ☐ | | 미등록 |
| 12 | [394. Decode String](https://leetcode.com/problems/decode-string/) | M | ✅ | ☐ | 2026-10-15 / 약 60분 / 정답·힌트 사용·닫는 괄호 처리 피드백 · [풀이](../../solutions/leetcode/0394-decode-string/README.md) | [코드](../../solutions/leetcode/0394-decode-string/Solution.java) |

<a id="stage-03"></a>

### 3단계 / 추천 3주차 — 격자 구현·시뮬레이션

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 13 | [48. Rotate Image](https://leetcode.com/problems/rotate-image/) | M | ✅ | ☐ | 2026-10-17 / 약 60분 / 정답·반복문 경계 피드백 · [풀이](../../solutions/leetcode/0048-rotate-image/README.md) | [코드](../../solutions/leetcode/0048-rotate-image/Solution.java) |
| 14 | [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | M | ✅ | ☐ | 2026-10-29 / 약 30분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0054-spiral-matrix/README.md) | [코드](../../solutions/leetcode/0054-spiral-matrix/Solution.java) |
| 15 | [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/) | M | ☐ | ☐ | | 미등록 |
| 16 | [289. Game of Life](https://leetcode.com/problems/game-of-life/) | M | ☐ | ☐ | | 미등록 |
| 17 | [59. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/) | M | ☐ | ☐ | | 미등록 |
| 18 | [885. Spiral Matrix III](https://leetcode.com/problems/spiral-matrix-iii/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-04"></a>

### 4단계 / 추천 4주차 — DFS·연결요소

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 19 | [733. Flood Fill](https://leetcode.com/problems/flood-fill/) | E | ✅ | ☐ | 2026-10-18 / 20분 / 정답·독립 해결·힌트 미사용·풀이 후 개선 · [풀이](../../solutions/leetcode/0733-flood-fill/README.md) | [코드](../../solutions/leetcode/0733-flood-fill/Solution.java) |
| 20 | [200. Number of Islands](https://leetcode.com/problems/number-of-islands/) | M | ✅ | ☐ | 2026-10-27 / 약 20분 / 정답·독립 해결·힌트 미사용·풀이 후 반환형 정리 · [풀이](../../solutions/leetcode/0200-number-of-islands/README.md) | [코드](../../solutions/leetcode/0200-number-of-islands/Solution.java) |
| 21 | [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island/) | M | ☐ | ☐ | | 미등록 |
| 22 | [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/) | M | ☐ | ☐ | | 미등록 |
| 23 | [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | M | ☐ | ☐ | | 미등록 |
| 24 | [785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-05"></a>

### 5단계 / 추천 5주차 — BFS·최단거리

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 25 | [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | M | ✅ | ☐ | 2026-10-20 / 20분 / 정답·독립 해결·힌트 미사용·공유본 오타 수정 · [풀이](../../solutions/leetcode/0994-rotting-oranges/README.md) | [코드](../../solutions/leetcode/0994-rotting-oranges/Solution.java) |
| 26 | [542. 01 Matrix](https://leetcode.com/problems/01-matrix/) | M | ☐ | ☐ | | 미등록 |
| 27 | [1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/) | M | ☐ | ☐ | | 미등록 |
| 28 | [1926. Nearest Exit from Entrance in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/) | M | ☐ | ☐ | | 미등록 |
| 29 | [752. Open the Lock](https://leetcode.com/problems/open-the-lock/) | M | ☐ | ☐ | | 미등록 |
| 30 | [934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-06"></a>

### 6단계 / 추천 6주차 — 완전탐색·백트래킹

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 31 | [78. Subsets](https://leetcode.com/problems/subsets/) | M | ✅ | ☐ | 2026-10-19 / 30분 / 정답·인덱스 실수 수정 · [풀이](../../solutions/leetcode/0078-subsets/README.md) | [코드](../../solutions/leetcode/0078-subsets/Solution.java) |
| 32 | [77. Combinations](https://leetcode.com/problems/combinations/) | M | ☐ | ☐ | | 미등록 |
| 33 | [46. Permutations](https://leetcode.com/problems/permutations/) | M | ✅ | ☐ | 2026-10-28 / 약 30분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0046-permutations/README.md) | [코드](../../solutions/leetcode/0046-permutations/Solution.java) |
| 34 | [39. Combination Sum](https://leetcode.com/problems/combination-sum/) | M | ☐ | ☐ | | 미등록 |
| 35 | [79. Word Search](https://leetcode.com/problems/word-search/) | M | ☐ | ☐ | | 미등록 |
| 36 | [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-07"></a>

### 7단계 / 추천 7주차 — 투포인터·윈도우·누적합

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 37 | [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | M | ✅ | ☐ | 2026-10-18 / 20분 / 정답·설명 참고 후 공간복잡도 개선 · [풀이](../../solutions/leetcode/0167-two-sum-ii-input-array-is-sorted/README.md) | [코드](../../solutions/leetcode/0167-two-sum-ii-input-array-is-sorted/Solution.java) |
| 38 | [15. 3Sum](https://leetcode.com/problems/3sum/) | M | ☐ | ☐ | | 미등록 |
| 39 | [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | M | ✅ | ☐ | 2026-10-26 / 20분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0003-longest-substring-without-repeating-characters/README.md) | [코드](../../solutions/leetcode/0003-longest-substring-without-repeating-characters/Solution.java) |
| 40 | [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | M | ☐ | ☐ | | 미등록 |
| 41 | [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) | M | ✅ | ☐ | 2026-10-21 / 30분 / 정답·힌트 사용·복습 연기 · [풀이](../../solutions/leetcode/0560-subarray-sum-equals-k/README.md) | [코드](../../solutions/leetcode/0560-subarray-sum-equals-k/Solution.java) |
| 42 | [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-08"></a>

### 8단계 / 추천 8주차 — 이분탐색·그리디

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 43 | [704. Binary Search](https://leetcode.com/problems/binary-search/) | E | ✅ | ☐ | 2026-10-15 / 10분 / 정답 · [풀이](../../solutions/leetcode/0704-binary-search/README.md) | [코드](../../solutions/leetcode/0704-binary-search/Solution.java) |
| 44 | [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/) | E | ☐ | ☐ | | 미등록 |
| 45 | [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | M | ✅ | ☐ | 2026-10-27 / 30분 / 정답·힌트 사용·이분탐색 2회로 개선 · [풀이](../../solutions/leetcode/0034-find-first-and-last-position-of-element-in-sorted-array/README.md) | [코드](../../solutions/leetcode/0034-find-first-and-last-position-of-element-in-sorted-array/Solution.java) |
| 46 | [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | M | ☐ | ☐ | | 미등록 |
| 47 | [55. Jump Game](https://leetcode.com/problems/jump-game/) | M | ✅ | ☐ | 2026-10-20 / 약 30분 / 정답·힌트 사용 후 그리디로 개선 · [풀이](../../solutions/leetcode/0055-jump-game/README.md) | [코드](../../solutions/leetcode/0055-jump-game/Solution.java) |
| 48 | [134. Gas Station](https://leetcode.com/problems/gas-station/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-09"></a>

### 9단계 / 추천 9주차 — 힙·위상정렬·유니온파인드

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 49 | [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | M | ✅ | ☐ | 2026-10-19 / 약 10분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0215-kth-largest-element-in-an-array/README.md) | [코드](../../solutions/leetcode/0215-kth-largest-element-in-an-array/Solution.java) |
| 50 | [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | M | ✅ | ☐ | 2026-10-28 / 약 30분 / 정답 보고·최초 힌트 미사용·비교식 수정본 재채점 미확인 · [풀이](../../solutions/leetcode/0347-top-k-frequent-elements/README.md) | [코드](../../solutions/leetcode/0347-top-k-frequent-elements/Solution.java) |
| 51 | [207. Course Schedule](https://leetcode.com/problems/course-schedule/) | M | ✅ | ☐ | 2026-10-22 / 약 30분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0207-course-schedule/README.md) | [코드](../../solutions/leetcode/0207-course-schedule/Solution.java) |
| 52 | [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | M | ☐ | ☐ | | 미등록 |
| 53 | [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/) | M | ✅ | ☐ | 2026-10-22 / 30분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0684-redundant-connection/README.md) | [코드](../../solutions/leetcode/0684-redundant-connection/Solution.java) |
| 54 | [721. Accounts Merge](https://leetcode.com/problems/accounts-merge/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-10"></a>

### 10단계 / 추천 10주차 — 가중 그래프·트리

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 55 | [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/) | M | ✅ | ☐ | 2026-10-23 / 40분 / 정답·다익스트라 코드 큰 틀 참고·visited 방식 · [풀이](../../solutions/leetcode/0743-network-delay-time/README.md) | [코드](../../solutions/leetcode/0743-network-delay-time/Solution.java) |
| 56 | [1631. Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/) | M | ☐ | ☐ | | 미등록 |
| 57 | [1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | M | ☐ | ☐ | | 미등록 |
| 58 | [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | E | ✅ | ☐ | 2026-10-21 / 30분 / 정답·힌트 사용·재귀 및 BFS · [풀이](../../solutions/leetcode/0104-maximum-depth-of-binary-tree/README.md) | [재귀](../../solutions/leetcode/0104-maximum-depth-of-binary-tree/Solution.java) · [BFS](../../solutions/leetcode/0104-maximum-depth-of-binary-tree/SolutionBfs.java) |
| 59 | [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | M | ☐ | ☐ | | 미등록 |
| 60 | [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-11"></a>

### 11단계 / 추천 11주차 — DP 기초

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 61 | [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | E | ✅ | ☐ | 2026-10-17 / 20분 / 정답·독립 해결·힌트 미사용 · [풀이](../../solutions/leetcode/0070-climbing-stairs/README.md) | [코드](../../solutions/leetcode/0070-climbing-stairs/Solution.java) |
| 62 | [198. House Robber](https://leetcode.com/problems/house-robber/) | M | ✅ | ☐ | 2026-10-26 / 20분 / 정답·힌트 미사용·DP 배열에서 두 변수로 개선 · [풀이](../../solutions/leetcode/0198-house-robber/README.md) | [코드](../../solutions/leetcode/0198-house-robber/Solution.java) |
| 63 | [62. Unique Paths](https://leetcode.com/problems/unique-paths/) | M | ☐ | ☐ | | 미등록 |
| 64 | [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) | M | ☐ | ☐ | | 미등록 |
| 65 | [322. Coin Change](https://leetcode.com/problems/coin-change/) | M | ☐ | ☐ | | 미등록 |
| 66 | [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-12"></a>

### 12단계 / 추천 12주차 — DP 심화·복합 구현

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 67 | [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) | M | ☐ | ☐ | | 미등록 |
| 68 | [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | M | ☐ | ☐ | | 미등록 |
| 69 | [139. Word Break](https://leetcode.com/problems/word-break/) | M | ☐ | ☐ | | 미등록 |
| 70 | [91. Decode Ways](https://leetcode.com/problems/decode-ways/) | M | ☐ | ☐ | | 미등록 |
| 71 | [146. LRU Cache](https://leetcode.com/problems/lru-cache/) | M | ☐ | ☐ | | 미등록 |
| 72 | [874. Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/) | E | ☐ | ☐ | | 미등록 |

<a id="stage-13"></a>

### 추가 1주차 — 확장 A: 탐색·자료구조

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 73 | [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/) | M | ☐ | ☐ | | 미등록 |
| 74 | [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/) | M | ☐ | ☐ | | 미등록 |
| 75 | [853. Car Fleet](https://leetcode.com/problems/car-fleet/) | M | ☐ | ☐ | | 미등록 |
| 76 | [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | M | ☐ | ☐ | | 미등록 |
| 77 | [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | M | ☐ | ☐ | | 미등록 |
| 78 | [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-14"></a>

### 추가 2주차 — 확장 B: 완전탐색·BFS

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 79 | [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) | M | ☐ | ☐ | | 미등록 |
| 80 | [93. Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/) | M | ☐ | ☐ | | 미등록 |
| 81 | [473. Matchsticks to Square](https://leetcode.com/problems/matchsticks-to-square/) | M | ☐ | ☐ | | 미등록 |
| 82 | [51. N-Queens](https://leetcode.com/problems/n-queens/) | H | ☐ | ☐ | | 미등록 |
| 83 | [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | M | ☐ | ☐ | | 미등록 |
| 84 | [127. Word Ladder](https://leetcode.com/problems/word-ladder/) | H | ☐ | ☐ | | 미등록 |

<a id="stage-15"></a>

### 추가 3주차 — 확장 C: 그래프·DP

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 85 | [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | M | ☐ | ☐ | | 미등록 |
| 86 | [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) | M | ☐ | ☐ | | 미등록 |
| 87 | [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/) | M | ☐ | ☐ | | 미등록 |
| 88 | [802. Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | M | ☐ | ☐ | | 미등록 |
| 89 | [72. Edit Distance](https://leetcode.com/problems/edit-distance/) | M | ☐ | ☐ | | 미등록 |
| 90 | [494. Target Sum](https://leetcode.com/problems/target-sum/) | M | ☐ | ☐ | | 미등록 |

<a id="stage-16"></a>

### 추가 4주차 — 확장 D: DP·상태 구현

| 순서 | LC 번호 / 문제 | 난도 | 최초 통과 | 독립 재풀이 | 날짜 / 시간 / 결과·풀이 | 코드 |
|---|---|---|---|---|---|---|
| 91 | [518. Coin Change II](https://leetcode.com/problems/coin-change-ii/) | M | ☐ | ☐ | | 미등록 |
| 92 | [221. Maximal Square](https://leetcode.com/problems/maximal-square/) | M | ☐ | ☐ | | 미등록 |
| 93 | [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | M | ☐ | ☐ | | 미등록 |
| 94 | [1140. Stone Game II](https://leetcode.com/problems/stone-game-ii/) | M | ☐ | ☐ | | 미등록 |
| 95 | [2007. Find Original Array From Doubled Array](https://leetcode.com/problems/find-original-array-from-doubled-array/) | M | ☐ | ☐ | | 미등록 |
| 96 | [1041. Robot Bounded In Circle](https://leetcode.com/problems/robot-bounded-in-circle/) | M | ☐ | ☐ | | 미등록 |

## 중간 점검과 실전 연습
24번까지: 연결요소와 방문 처리를 설명할 수 있는지 확인한다.
36번까지: 경로 탐색에서 방문 상태를 복원하는 이유와 조합 중복을 막는 방법을 확인한다.
54번까지: 복잡도를 계산하고, 사이클 검사 및 Union-Find를 빈 화면에서 구현할 수 있는지 확인한다.
72번까지: DP 상태와 전이를 설명하고, 틀린 문제를 다시 풀 수 있는지 확인한다.

4단계 분량을 학습하면 평일 기존 배정량 안에서 서로 다른 유형의 시간제한 연습을 진행한다. 복습은 새 진도 우선 원칙과 실제 약점에 맞춰 최소한으로 포함한다.

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

기본 72문제 → 확장 24문제 → 약점별 후속 문제. 새 문제를 우선하며 유형을 교차한다.
