package Heap;

import java.util.*;

class Programmers_이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 최소힙
        Map<Integer, Integer> map = new HashMap<>(); // 숫자의 개수를 관리할 Map
        
        for(String oper : operations){
            String[] parts = oper.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if(command.equals("I")){ // 숫자 삽입
                maxPq.offer(num);
                minPq.offer(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else{ // 최댓값 또는 최솟값 삭제
                if(num == 1){ // 최댓값 삭제
                    while(!maxPq.isEmpty() && map.get(maxPq.peek()) == 0){ // 없는 숫자 꺼냄
                        maxPq.poll();
                    }
                    if(!maxPq.isEmpty()){
                        int max = maxPq.poll();
                        map.put(max, map.get(max) - 1);
                    }
                } else if(num == -1){ // 최솟값 삭제
                    while(!minPq.isEmpty() && map.get(minPq.peek()) == 0){ // 없는 숫자 꺼냄
                        minPq.poll();
                    }
                    if(!minPq.isEmpty()){
                        int min = minPq.poll();
                        map.put(min, map.get(min) - 1);
                    }
                }
            }
        }
        
        // 유효한 최대, 최소값 찾기
        while(!maxPq.isEmpty() && map.get(maxPq.peek()) == 0){
            maxPq.poll();
        }
        while(!minPq.isEmpty() && map.get(minPq.peek()) == 0){
            minPq.poll();
        }
        
        if(maxPq.isEmpty() || minPq.isEmpty())
            return new int[] {0, 0};
        else{
            return new int[] {maxPq.poll(), minPq.poll()};
        }
    }
}
