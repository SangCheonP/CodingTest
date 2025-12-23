package Bruteforce;
/**
* total = b + y
*       = w * h
* brown = 2w + 2h - 4
* 
**/

import java.util.*;

class Programmers_카펫 {
    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 타일 개수
        
        for (int width = total; width >= 1; width--) {
            if (total % width == 0) { // 전체 타일을 나누어 떨어지는 width 찾기
                int height = total / width; // 대응하는 height 계산
                
                // 가로가 세로보다 크거나 같은 경우만 진행
                if (width >= height) {
                    // 테두리에 있는 갈색 타일 개수 검사
                    int calculatedBrown = (2 * width) + (2 * height) - 4;
                    if (calculatedBrown == brown) {
                        return new int[]{width, height}; // 정답 반환
                    }
                }
            }
        }
        return new int[0]; // 예외 처리 (실제로는 주어지는 입력이 항상 조건을 만족함)
    }
}
