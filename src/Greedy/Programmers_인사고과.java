import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0]; // 원호의 점수 저장
        
        // **1️⃣ 평가1 내림차순 정렬 → 평가1이 같으면 평가2 오름차순 정렬**
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // 평가1이 같으면 평가2 오름차순 정렬
            return b[0] - a[0]; // 평가1 내림차순 정렬
        });

        int rank = 1; // 원호의 초기 등수
        int maxSecondScore = 0; // 현재까지의 평가2 최대값 저장
        
        // **2️⃣ 평가1이 높은 순서대로 탐색하면서 인센티브 대상 검토**
        for (int[] score : scores) {
            // **현재까지의 평가2 최대값보다 크거나 같다면 갱신**
            if (score[1] >= maxSecondScore) {
                maxSecondScore = score[1]; // 평가2 최대값 업데이트
                
                // **원호보다 점수가 높은 경우 랭크 증가**
                if (score[0] + score[1] > target[0] + target[1]) {
                    rank++;
                }
            } 
            // **두 점수 모두 낮다면 원호가 인센티브를 받을 수 없음**
            else if (Arrays.equals(target, score)) {
                return -1;
            }
        }

        return rank; // 최종 등수 반환
    }
}
