/**
* 1. 큐를 만들어서 인덱스랑 우선순위를 넣음
* 2. 자신보다 높은 우선순위가 있는 지 체크. 
* 2-1. for문
* 2-2. Map
* 3. 더 높은 우선순위가 없으면 해당 프로세스 삭제
* 3-1. 있으면, 프로세스를 다시 넣음
**/

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        int[] priorityCount = new int[10]; // 우선순위 개수를 저장하는 배열
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Process(i, priorities[i]));
            priorityCount[priorities[i]]++;
        }
        
        int answer = 0;
        
        while(!queue.isEmpty()){
            Process cur = queue.poll();
            
            // 현재 프로세스보다 높은 우선순위가 있는지 확인
            boolean hasHigherPriority = false;
            for(int i = cur.priority + 1; i <= 9; i++){
                if(priorityCount[i] > 0){
                    hasHigherPriority = true;
                    break;
                }
            }
            
            // 더 높은 순위가 있면 큐에 넣음
            if(hasHigherPriority){
                queue.offer(cur);
            } else{ // 없으면
                answer++;
                priorityCount[cur.priority]--;
                
                // 원하는 프로세스면 종료
                if(cur.idx == location){
                    return answer;
                }
            }
        }
    
        return answer;
    }
}

class Process{
    int idx;
    int priority;
    
    Process(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
