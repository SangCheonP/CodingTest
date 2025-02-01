/**
* 1. 스택에 숫자를 하나씩 넣음
* 2. 전에 넣은 숫자가 현재 숫자보다 작고, k가 남아있으면 전에 숫자 제거하고, 현재 숫자 넣음
* 3. 작으면 그냥 넣음
* 4. 다 진행했는데 k가 남으면 뒤에서 제거
**/

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(char n : number.toCharArray()){
            // 제거해야 할 개수가 남아있고, 스택의 마지막 값이 현재 값보다 작다면 제거
            while(!stack.isEmpty() && k > 0 && stack.peek() < n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        
        // k가 남아 있다면 뒤에서 제거
        while (k-- > 0) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}
