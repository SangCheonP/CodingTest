# 3. Longest Substring Without Repeating Characters

- 문제: https://leetcode.com/problems/longest-substring-without-repeating-characters/
- 난도: Medium
- 풀이 날짜: 2026-10-26
- 채점 상태: 정답 (사용자 확인)
- 소요 시간: 20분
- 결과: 독립 해결·힌트 미사용 (사용자 확인)
- 코드: [Solution.java](./Solution.java)

## 접근
- 중복 없는 구간 [j, i]를 유지하는 슬라이딩 윈도우.
- 현재 문자가 이미 있으면 왼쪽 문자를 제거하며 j 이동.
- 중복 해소 후 현재 문자를 추가하고 최대 길이 갱신.

## 복잡도
- 시간: 평균 O(n). 각 문자는 최대 한 번 추가·제거.
- 공간: O(min(n, 문자 종류 수)).

## 검토
- 빈 문자열 → 0, bbbbb → 1, abba → 2, pwwkew → 3.
- 코드 흐름을 확인하고 사용자 로직을 유지했다.
- 로컬 Java 컴파일·실행은 javac가 없어 수행하지 않았다. 채점 정답은 사용자 확인에 근거한다.

## 복습
- 개념 또는 해결 전략 부족이 확인되지 않아 오답 복습에 등록하지 않는다.
- 최초 독립 해결과 별도 독립 재풀이는 구분한다. 독립 재풀이 체크는 유지한다.
