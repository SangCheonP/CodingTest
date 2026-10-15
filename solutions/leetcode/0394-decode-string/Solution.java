import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> cntStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder cur = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 여러 자리 반복 횟수를 누적
                num = num * 10 + c - '0';
            } else if (c == '[') {
                // 바깥 문자열과 반복 횟수를 저장하고 안쪽 문자열 처리
                cntStack.push(num);
                strStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int cnt = cntStack.pop();
                StringBuilder prev = strStack.pop();
                // 완성한 안쪽 문자열을 바깥 문자열에 반복해서 추가
                for (int i = 0; i < cnt; i++) {
                    prev.append(cur);
                }
                cur = prev;
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }
}
