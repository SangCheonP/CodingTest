/**
* 1. 모든 보석의 종류 개수를 확인하여 목표 개수(gemsCnt)를 구함.
* 2. start, end를 0으로 설정하고, Map을 사용해 현재 포함된 보석 개수를 관리.
* 3. end를 증가시키며 gems[end] 보석을 Map에 추가.
* 4. Map의 키 개수(gemMap.size())가 gemsCnt와 같다면 최소 구간을 갱신.
* 5. start를 이동시키며 구간을 줄이고, 최소 구간(minLen)을 유지.
**/

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 1. 모든 보석의 종류 개수 구하기
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int gemsCnt = gemTypes.size(); // 보석의 총 종류 개수

        // 2. 투 포인터 및 맵 초기화
        Map<String, Integer> gemMap = new HashMap<>();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2]; // 정답 배열 (구간의 시작, 끝)

        // 3. 투 포인터 탐색 시작
        while (end < gems.length) {
            // 보석 추가
            gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
            end++; // end 증가

            // 모든 보석 종류를 포함한 경우 start 조정
            while (gemMap.size() == gemsCnt) {
                // 현재 구간 길이 계산
                if (end - start < minLen) {
                    minLen = end - start; // 최소 길이 갱신
                    answer[0] = start + 1; // 문제에서 인덱스가 1부터 시작
                    answer[1] = end;
                }

                // start 위치의 보석 제거
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                if (gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]); // 개수가 0이면 삭제
                }
                start++; // start 증가
            }
        }

        return answer;
    }
}
