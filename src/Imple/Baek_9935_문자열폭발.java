package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 모든 폭발 문자열 폭발
 * 남은 문자열은 순서대로 붙음
 * 새로 생긴 문자열에 폭발 문자열이 포함될 수도
 * 폭발은 폭발 문자열이 없을 때까지
 *
 * 남은 문자열 구하기
 * 없으면 -> FRULA
 */

/**
 * sb의 뒷 부분이 폭발 문자열이랑 같은지 비교
 * 만약 같으면 해당 문자열 제거
 * 다르면 넘어감
 */

/**
 * 1. StringBuilder의 delete와 substring은 end는 미포함(4면, 3까지)
 * 2. Stack을 활용하여 풀수는 있으나 비교하고 복사를 반복하기 때문에 N^2의 시간 복잡도를 갖는다.
 */
public class Baek_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toString();
        String boom = br.readLine().toString();

        StringBuilder sb = new StringBuilder();

        for (char c : line.toCharArray()){
            sb.append(c);

            // 폭발 문자열이 버퍼보다 크면 다음 문자 진행
            if(boom.length() > sb.length())
                continue;
            
            // sb의 뒷부분이 폭발 문자열이랑 일치하면 삭제
            if(sb.substring(sb.length() - boom.length(), sb.length()).equals(boom)){
                sb.delete(sb.length() - boom.length(), sb.length());
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
