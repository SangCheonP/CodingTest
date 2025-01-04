/**
1. 우선순위 큐를 정의(소요 시간, 요청 시각, 작업 번호), jobs를 넣음
2. 시간 변수를 만들어서, 하나씩 빼면서 진행
3. 하나가 끝났을 때, 현재 시각 - 요청 시각을 sum에 더함
4. sum을 jobs의 길이로 나눠서 반환
**/
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시각으로 정렬
        Arrays.sort(jobs, (a ,b) -> a[0] - b[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int currentTime = 0;   // 현재 시각
        int totalTime = 0;     // 총 대기 시간
        int index = 0;         // jobs 배열의 인덱스
        int completed = 0;     // 완료된 작업 수
        
        while(completed < jobs.length){
            // 현재 시각까지 요청된 작업을 우선순위 큐에 넣음
            while(index < jobs.length && jobs[index][0] <= currentTime){
                pq.add(new Job(index, jobs[index][0], jobs[index][1]));
                index++;
            }
            
            if(!pq.isEmpty()){
                // 큐에서 하나 빼서 처리
                Job currentJob = pq.poll();
                currentTime += currentJob.useTime;
                totalTime += currentTime - currentJob.requestTime;
                completed++;
            }else{
                // 큐가 비어있으면 다음 요청 시각으로 이동
                currentTime = jobs[index][0];
            }
        }
        
        return totalTime / jobs.length; // 평균 대기 시간 반환
    }
}

class Job implements Comparable<Job> {
    int num;           // 작업 번호
    int requestTime;   // 요청 시각
    int useTime;       // 소요 시간

    Job(int num, int requestTime, int useTime) {
        this.num = num;
        this.requestTime = requestTime;
        this.useTime = useTime;
    }

    @Override
    public int compareTo(Job o) {
        // 우선순위를 소요 시간을 기준으로 정렬
        if (this.useTime == o.useTime) {
            if(this.requestTime == o.requestTime){
                return this.num - o.num;
            }
            return this.requestTime - o.requestTime;
        }
        return this.useTime - o.useTime;
    }
}
