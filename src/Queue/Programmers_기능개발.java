package Queue; /**
1. 큐 2개를 선언
2. 각 큐에 진행도, 속도를 넣음
3. 맨 앞이 100이상이면 진행도가 100보다 작은 것이 나올때까지 뺌, 그 수를 결과 배열에 넣음
4. 이제 처음부터 끝까지 돌면서 진행도를 높임
5. 기능이 없을 때까지 진행
**/

import java.util.*;

class Programmers_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();
        
        // 1. 진행도와 속도를 큐에 삽입
        for (int progress : progresses) {
            p.offer(progress);
        }
        
        for (int speed : speeds) {
            s.offer(speed);
        }
        
        // 2. 큐가 비어있을 때까지 반복
        while(!p.isEmpty()){
            // 2-1. 모든 작업의 진행도를 증가
            int size = p.size();
            for (int i = 0; i < size; i++) {
                int curProgress = p.poll();
                int curSpeed = s.poll();
                p.offer(curProgress + curSpeed);
                s.offer(curSpeed);
            }
            
            // 2-2. 맨 앞 작업이 완료(100 이상)되었는지 확인
            int count = 0;
            while (!p.isEmpty() && p.peek() >= 100) {
                p.poll();
                s.poll(); // 진행도와 속도 모두 제거
                count++;
            }
            
            // 2-3. 완료된 작업이 있다면 결과 리스트에 추가
            if (count > 0) {
                list.add(count);
            }
        }
        
        // 3. 결과를 배열로 변환하여 반환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
