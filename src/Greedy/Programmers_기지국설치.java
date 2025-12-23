package Greedy;

class Programmers_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1; // 한 기지국이 커버할 수 있는 범위
        int position = 1; // 현재 탐색 중인 위치
        
        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            // 기지국이 없는 구간이 존재하면 추가 기지국 설치
            if (position < left) {
                int emptyLength = left - position; // 전파가 닿지 않는 길이
                answer += (emptyLength + range - 1) / range; // 필요한 기지국 개수 계산
            }
            
            // 현재 위치 업데이트
            position = right + 1;
        }

        // 마지막 기지국 이후의 남은 구간 처리
        if (position <= n) {
            int emptyLength = n - position + 1;
            answer += (emptyLength + range - 1) / range;
        }

        return answer;
    }
}
