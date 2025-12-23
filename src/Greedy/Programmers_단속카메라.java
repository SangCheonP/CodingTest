package Greedy;

import java.util.Arrays;

class Programmers_단속카메라 {
    public int solution(int[][] routes) {
        // 차량의 진출 지점(끝점) 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameras = 0;  // 설치된 카메라 개수
        int lastCamera = Integer.MIN_VALUE;  // 마지막 카메라 위치 (초기값은 가장 작은 값)

        for (int[] route : routes) {
            int start = route[0]; // 차량의 시작 위치
            int end = route[1];   // 차량의 끝 위치

            // 현재 차량이 마지막 카메라의 범위를 벗어나면 새로운 카메라 설치
            if (start > lastCamera) {
                cameras++;         // 새로운 카메라 추가
                lastCamera = end;  // 카메라를 차량의 끝 위치에 설치
            }
        }

        return cameras;
    }
}
