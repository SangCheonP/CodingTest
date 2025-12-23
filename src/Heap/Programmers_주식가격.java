package Heap; /**
* 1. 큐에 모든 가격을 넣음
* 2. 큐가 빌때까지
* 3. 큐에서 하나 뺌, 시간 = 1
* 4. for문을 통해 뺀 것과 큐 속에 있는 가격들을 비교
* 5. 뺀 것의 가격이 더 높거나, 같으면 계속 진행, 시간+1
* 6. 뺀 것의 가격이 더 낮으면 종료
**/

import java.util.*;

class Programmers_주식가격 {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        
        List<Integer> result = new ArrayList<>();
        
        // 1. 주식 가격을 큐에 넣음
        for(int price : prices){
            queue.offer(price);
        }
        
        // 2. 큐가 빌때까지 반복
        while(!queue.isEmpty()){
            int cur = queue.poll(); // 값을 하나 뺌
            int time = 0;
            
            for(int price : queue){
                if(cur > price){ // 가격이 떨어지면 종료
                    time++;
                    break;
                }
                time++;
            }
            
            result.add(time);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
