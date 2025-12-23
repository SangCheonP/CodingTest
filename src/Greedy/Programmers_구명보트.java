package Greedy;
/**
* 1. 먼저 무게를 오름차순으로 정렬
* 2. 현재 사람을 가르키는 인덱스
* 2-1. 현재 사람과 다음 사람 합쳐서 limit 보다 크면 인덱스를 다음 사람으로 옮김.
* 2-2. limit보다 작으면 다음다음 사람한테 넘김
* 3. 결과를 수에 맞게 증가
**/

import java.util.*;

class Programmers_구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 무게를 오름차순으로 정렬
        int i = 0, j = people.length - 1; // 가장 가벼운 사람과 가장 무거운 사람의 인덱스
        int answer = 0;

        // i == j 일때, 어차피 1번만 운행하니 상관없음
        while (i <= j) {
            if (people[i] + people[j] <= limit) { // 두 사람의 무게 합이 limit 이하인 경우
                i++; // 다음 가장 가벼운 사람으로 이동
            }
            j--; // 다음 가장 무거운 사람으로 이동
            answer++; // 보트 수 증가
        }

        return answer; // 필요한 보트의 최소 수 반환
    }
}
