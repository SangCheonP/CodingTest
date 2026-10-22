# 207. Course Schedule

- 문제: https://leetcode.com/problems/course-schedule/
- 난도: Medium
- 풀이 날짜: 2026-10-22
- 채점 상태: 정답 (사용자 확인)
- 소요 시간: 약 30분 (사용자 확인)
- 결과: 독립 해결·힌트 미사용 (사용자 확인)
- 코드: [Solution.java](./Solution.java)

## 접근
선수 과목에서 후속 과목으로 연결한 방향 그래프와 진입 차수를 구성한다. 진입 차수가 0인 모든 과목을 큐에 넣고 처리하는 Kahn 위상 정렬 방식이다.

indegree는 아직 수강하지 않은 직접 선수 과목 수다. 과목을 처리하면 후속 과목의 indegree를 감소시키고, 0이 된 과목을 큐에 넣는다. processed는 처리한 과목 수다. 순환 관계가 있으면 해당 과목들의 조건이 해소되지 않으므로 processed가 numCourses보다 작다.

## 복잡도
V는 과목 수, E는 선수 조건 수다.
- 시간: O(V + E). 각 과목과 간선을 한 번씩 처리한다.
- 추가 공간: O(V + E). 인접 리스트, 진입 차수 배열, 큐를 사용한다.

## 경계 사례 및 검토
- numCourses = 2, prerequisites = [] → true
- numCourses = 2, prerequisites = [[1, 0]] → true
- numCourses = 2, prerequisites = [[1, 0], [0, 1]] → false
- numCourses = 3, prerequisites = [[1, 0], [0, 1]] → false. 고립된 과목을 처리해도 순환 관계는 남는다.
- 위 사례는 코드 흐름 검토이며 별도 로컬 실행은 수행하지 않았다. 채점 통과는 사용자 확인에 근거한다.

## 수정 및 복습
- 공유 코드의 numCourse를 numCourses로 수정하고 import, 클래스·메서드 선언과 한국어 주석을 추가했다.
- 단순 변수명 오타는 복습 사유에서 제외한다.
- 독립 해결했으며 개념 부족이 확인되지 않아 오답·힌트 의존 복습에 등록하지 않는다.
- 독립 재풀이 완료는 별도 확인 전까지 체크하지 않는다.
