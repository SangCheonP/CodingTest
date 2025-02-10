/**
* 최고의 집합
* 1. 원소의 합 = S
* 2. 원소의 곱이 최대
* n개의 원소의 합이 s인 집합을 구함
* -> s/2해서 나온 값으로 n개 배열 생성
* 만약 값이 부족하면 원소 하나씩 돌면서 1을 추가
* 만약 s가 n보다 작으면 [-1] 리턴
**/

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        // S가 N보다 작으면 조건을 만족하는 집합이 없음
        if (s < n) return new int[]{-1};

        // 배열의 기본 값 설정
        int baseValue = s / n;
        int remainder = s % n; // 남은 값을 균등하게 분배

        int[] result = new int[n];
        Arrays.fill(result, baseValue); // 기본 값으로 채우기

        // 나머지를 앞에서부터 하나씩 추가
        for (int i = 0; i < remainder; i++) {
            result[n - 1 - i] += 1;
        }

        return result;
    }
}
