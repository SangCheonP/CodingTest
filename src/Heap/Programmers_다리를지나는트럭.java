/**
* 1. 현재 어떤 트럭인지를 가르키는 인덱스를 가지고 해당 트럭 선택
* 2. 해당 트럭이 큐에 들어갈 수 있는 지 체크
* 2-1. 큐의 사이즈가 < bridge_length인지 체크
* 2-2. 현재 큐에 들어있는 트럭 무게 + 넣을 트럭 무게 <= weight -> 트럭 무게를 저장하는 변수 필요
* 2-3. 모두 true면 트럭을 넣음
* 2-4. false면 큐의 맨 앞에서 뺌
* 3. 시간 증가
* 4. 모든 트럭이 올 때까지 진행
**/

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 경과 시간
        int truckIdx = 0; // 대기 트럭 인덱스
        int truckWeightSum = 0; // 현재 다리 위 트럭 무게 합

        Queue<Truck> queue = new LinkedList<>(); // [트럭 무게, 경과 시간]
        
        while(truckIdx < truck_weights.length || !queue.isEmpty()){
            // 1. 시간 증가
            time++;
            
            // 2. 큐의 맨 앞의 트럭이 다리를 모두 건넌 경우 제거
            if(!queue.isEmpty() && queue.peek().t == bridge_length){
                truckWeightSum -= queue.poll().w; // 다리를 건넌 트럭의 무게 제거
            }
            
            // 3. 대기 트럭을 다리에 올릴 수 있는지 확인
            if(truckIdx < truck_weights.length && truckWeightSum + truck_weights[truckIdx] <= weight && queue.size() < bridge_length){
                queue.offer(new Truck(truck_weights[truckIdx], 0)); // 트럭 추가
                truckWeightSum += truck_weights[truckIdx]; // 현재 다리 위 무게 합 갱신
                truckIdx++;
            }
            
            // 4. 다리 위 트럭의 경과 시간 증가
            for(Truck truck : queue){
                truck.t++;
            }
        }
        
        return time;
    }
}

class Truck{
    int w, t;
    
    Truck(int w, int t){
        this.w = w;
        this.t = t;
    }
}
