package Queue;

import java.util.*;

class Programmers_올바른괄호 {
    public boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 여는 괄호를 큐에 삽입
                queue.offer(c);
            } else {
                // 닫는 괄호 처리
                if (queue.isEmpty()) {
                    // 닫는 괄호가 큐에 남아 있는 여는 괄호보다 많으면 false
                    return false;
                }
                queue.poll(); // 큐에서 가장 먼저 들어간 여는 괄호 제거
            }
        }

        // 큐가 비어 있으면 올바른 괄호, 남아 있으면 잘못된 괄호
        return queue.isEmpty();
    }
}
