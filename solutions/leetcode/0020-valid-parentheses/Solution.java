import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            // 대응할 여는 괄호가 없으면 실패
            if (stack.isEmpty()) {
                return false;
            }

            char open = stack.pop();

            // 괄호의 종류가 다르면 실패
            if ((c == ')' && open != '(')
                    || (c == ']' && open != '[')
                    || (c == '}' && open != '{')) {
                return false;
            }
        }

        // 닫히지 않은 괄호가 없어야 성공
        return stack.isEmpty();
    }
}
