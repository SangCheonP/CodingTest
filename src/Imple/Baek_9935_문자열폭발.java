package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 * 모든 폭발 문자열 폭발
 * 남은 문자열은 순서대로 붙음
 * 새로 생긴 문자열에 폭발 문자열이 포함될 수도
 * 폭발은 폭발 문자열이 없을 때까지
 *
 * 남은 문자열 구하기
 * 없으면 -> FRULA
 *
 *
 */
public class Baek_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toString();
        String boom = br.readLine().toString();

        Stack<Character> stack = new Stack<>();

        for (char c : line.toCharArray()){
            stack.push(c);

            // 스택 안에 있는 것이 폭발 문자열보다 작으면
            if(boom.length() > stack.size())
                continue;
            
            // 스택의 윗부분의 폭발문자열 길이만큼 비교
            List<Character> tmp = new LinkedList<>();
            
            // 문자열 뒤부터 비교
            for(int i = boom.length() - 1; i >= 0; i--){
                tmp.add(stack.pop());

                // 일치하지 않은 문자열이면
                if(boom.charAt(i) != tmp.get(tmp.size()-1)){
                    // stack에 다시 넣음
                    for(char tmpC : tmp){
                        stack.add(tmpC);
                    }
                    break;
                }
            }
        }

        if(stack.size() == 0){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.insert(0, stack.pop());
            }
            System.out.println(sb);
        }
    }
}
