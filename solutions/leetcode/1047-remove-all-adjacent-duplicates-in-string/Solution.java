import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            // 마지막 문자와 같으면 인접한 두 문자를 제거
            if (!deque.isEmpty() && deque.peekLast() == c) {
                deque.pollLast();
            } else {
                deque.offerLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 남은 문자를 앞에서부터 결과에 추가
        for (char c : deque) {
            sb.append(c);
        }

        return sb.toString();
    }
}
