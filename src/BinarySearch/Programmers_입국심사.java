import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long start = 1;
        // 가장 긴 시간 * 목표 인원수
        long end = (long) Arrays.stream(times).max().getAsInt() * n;
        
        // 경계값도 검사해야하기 때문에 = 넣음
        while(start <= end){
            long mid = (start + end) / 2; // 중간 시간
            long total = 0; // 처리 가능한 총 인원
            
            // mid 시간 동안 각 심사관이 처리할 수 있는 인원 계산
            for(int time : times){
                total += mid / time;
                if(total >= n) break; // 처리 가능한 인원이 목표를 넘으면 중단
            }
            
            if (total >= n) { // 목표 인원 이상 처리 가능
                answer = Math.min(answer, mid); // 최소 시간 갱신
                end = mid - 1; // 더 짧은 시간 탐색
            } else { // 목표 인원 처리 불가
                start = mid + 1; // 더 긴 시간 탐색
            }
        }
        
        return answer;
    }
}
