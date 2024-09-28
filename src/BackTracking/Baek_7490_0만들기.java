package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1 ~ N까지 오름차순 수열 1,2,3,...,N
 * +, -, ' '
 * 수식의 결과가 0이 되는 것을 모두 찾음
 * T < 10
 * 3 <= N <= 9
 * 
 * 각 테스트 케이스의 결과는 한 줄을 띄워 구분
 */

/**
 * 1. 배열이나 리스트가 아닌 스트링으로 저장
 * 2. 백트래킹을 할 때. (처리할 수, 지금까지 합, 마지막으로 처리한 수, 현재까지의 수식)을 넘김
 */
public class Baek_7490_0만들기 {
    static int N;
    static List<String> results;
    static StringBuilder expression;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc++){
            N = Integer.parseInt(br.readLine());

            results = new ArrayList<>();
            expression = new StringBuilder();
            expression.append("1"); // 시작 숫자

            dfs(2, 1, 1, expression.toString());

            // 결과 출력
            for(String expr : results){
                output.append(expr).append("\n");
            }

            if(tc != TC -1){
                output.append("\n"); // 각 테스트 케이스 사이에 한 줄 띄우기
            }
        }

        System.out.println(output);
    }

    /**
     * @param num 현재 처리 중인 숫자
     * @param curSum 지금까지의 합
     * @param lastNum 마지막으로 처리된 숫자 (공백 연결시 필요)
     * @param expr 현재까지의 식
     */
    static void dfs(int num, int curSum, int lastNum, String expr){
        // 모든 숫자릴 다 처리했으면
        if(num > N){
            if(curSum == 0)
                results.add(expr);
            return;
        }

        // 공백 추가: 숫자 연결(32)
        int newLastNum = (lastNum >=0) ? (lastNum *10 + num) : (lastNum *10 - num);
        int newSum = curSum - lastNum + newLastNum;
        dfs(num + 1, newSum, newLastNum, expr + " " + num);

        // + 추가(43)
        dfs(num + 1, curSum + num, num, expr + "+" + num);

        // - 추가(45)
        dfs(num + 1, curSum - num, -num, expr + "-" + num);
    }
}
