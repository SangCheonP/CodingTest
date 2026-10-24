# CodingTest

Java 코딩테스트 학습 기록 · 기본 72문제 + 확장 24문제

| 학습순서 | 진행 현황 | 알고리즘 정리 |
|---|---|---|
| [유형별 순서 보기](#study-order) | [전체 96문제 현황](docs/leetcode/problemset.md#progress) | [Java 함수·자료구조·알고리즘](docs/reference/java-algorithms.md) |

**학습순서 클릭 → 해당 단계 현황 → 코드 클릭 → Java 풀이**

## 진행 현황

2026-10-24 문제집 체크 기준. 최신 결과는 [전체 현황](docs/leetcode/problemset.md#progress)에서 확인.

| 기본 | 확장 | 전체 최초 통과 |
|---|---|---|
| 24 / 72 | 0 / 24 | **24 / 96** |

채점 미확인과 미풀이 모두 ☐로 표시. 독립 재풀이는 별도 체크.

<a id="study-order"></a>

## 학습순서

**순서·유형을 누르면 해당 단계의 진행 현황으로 이동.**

기본 → 확장 순으로 학습하되, 한 사이클 안에서는 서로 다른 유형을 하나씩 교차한다.

| 구분 | 문제집 순서 | 유형 | 최초 통과 |
|---|---|---|---|
| 기본 1 | [1~6](docs/leetcode/problemset.md#stage-01) | [배열·문자열·해시](docs/leetcode/problemset.md#stage-01) | 5 / 6 |
| 기본 2 | [7~12](docs/leetcode/problemset.md#stage-02) | [정렬·구간·스택](docs/leetcode/problemset.md#stage-02) | 5 / 6 |
| 기본 3 | [13~18](docs/leetcode/problemset.md#stage-03) | [격자 구현·시뮬레이션](docs/leetcode/problemset.md#stage-03) | 1 / 6 |
| 기본 4 | [19~24](docs/leetcode/problemset.md#stage-04) | [DFS·연결요소](docs/leetcode/problemset.md#stage-04) | 1 / 6 |
| 기본 5 | [25~30](docs/leetcode/problemset.md#stage-05) | [BFS·최단거리](docs/leetcode/problemset.md#stage-05) | 1 / 6 |
| 기본 6 | [31~36](docs/leetcode/problemset.md#stage-06) | [완전탐색·백트래킹](docs/leetcode/problemset.md#stage-06) | 1 / 6 |
| 기본 7 | [37~42](docs/leetcode/problemset.md#stage-07) | [투포인터·윈도우·누적합](docs/leetcode/problemset.md#stage-07) | 2 / 6 |
| 기본 8 | [43~48](docs/leetcode/problemset.md#stage-08) | [이분탐색·그리디](docs/leetcode/problemset.md#stage-08) | 2 / 6 |
| 기본 9 | [49~54](docs/leetcode/problemset.md#stage-09) | [힙·위상정렬·유니온파인드](docs/leetcode/problemset.md#stage-09) | 3 / 6 |
| 기본 10 | [55~60](docs/leetcode/problemset.md#stage-10) | [가중 그래프·트리](docs/leetcode/problemset.md#stage-10) | 2 / 6 |
| 기본 11 | [61~66](docs/leetcode/problemset.md#stage-11) | [DP 기초](docs/leetcode/problemset.md#stage-11) | 1 / 6 |
| 기본 12 | [67~72](docs/leetcode/problemset.md#stage-12) | [DP 심화·복합 구현](docs/leetcode/problemset.md#stage-12) | 0 / 6 |
| 확장 1 | [73~78](docs/leetcode/problemset.md#stage-13) | [확장 A · 탐색·자료구조](docs/leetcode/problemset.md#stage-13) | 0 / 6 |
| 확장 2 | [79~84](docs/leetcode/problemset.md#stage-14) | [확장 B · 완전탐색·BFS](docs/leetcode/problemset.md#stage-14) | 0 / 6 |
| 확장 3 | [85~90](docs/leetcode/problemset.md#stage-15) | [확장 C · 그래프·DP](docs/leetcode/problemset.md#stage-15) | 0 / 6 |
| 확장 4 | [91~96](docs/leetcode/problemset.md#stage-16) | [확장 D · DP·상태 구현](docs/leetcode/problemset.md#stage-16) | 0 / 6 |

## 학습 규칙

- 평일 **새 문제 1~2개**, 주말 **1개**.
- 한 사이클 내 서로 다른 알고리즘·핵심 개념으로 구성.
- 새 진도 우선. 복습은 사이클 이후 필요한 개념만 최소한으로 진행.
- 단순 오타·문법·일회성 구현 실수는 복습에서 제외.
- 기록: **채점 결과 / 독립·힌트·해설 / 소요 시간 / 막힌 점**.

## 자료 바로가기

| 자료 | 내용 |
|---|---|
| [Java 코테 참고](docs/reference/java-algorithms.md) | 정렬·자료구조 API·알고리즘 템플릿 |
| [문제집·진행 현황](docs/leetcode/problemset.md) | 96문제 체크·날짜·코드·풀이 노트 |
| [풀이 저장 방법](solutions/leetcode/README.md) | 폴더·파일·기록 규칙 |
| [풀이 노트 양식](templates/solution-note.md) | 접근·복잡도·학습 기록 |
| [선정 근거](docs/leetcode/references.md) | 기업 후기·유형 선정 기준 |
| [기존 풀이](src) | 백준·프로그래머스·SWEA·Theory |

최초 통과는 실제 채점 결과 확인 후 체크한다. 기본·확장 완료 후 약점에 맞춰 후속 문제를 추가한다.
