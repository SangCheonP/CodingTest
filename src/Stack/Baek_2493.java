package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 2493 탑 (골드5)
https://www.acmicpc.net/problem/2493
 */
public class Baek_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // top 저장 배열
        // idx, high
        Stack<Integer[]> top = new Stack<>();

        // 저장할 탑의 idx
        int topIdx = -1;

        // 결과 저장 배열
        int[] result = new int[N];

        for(int curHigh : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()){
            while(true) {
                // 비어있으면
                if(top.isEmpty()){
                    top.add(new Integer[]{++topIdx, curHigh});
                    result[topIdx] = 0;
                    break;
                }
                // 바로 앞의 높이가 넣을려는 높이보다 낮으면
                else if (top.peek()[1] < curHigh) {
                    top.pop();
                // 존재하고, 바로 앞의 높이가 나보다 크거나 같으면
                } else {
                    result[++topIdx] = top.peek()[0] + 1;
                    top.add(new Integer[]{topIdx, curHigh});
                    break;
                }
            }
        }

        for(int n : result)
            System.out.print(n + " ");
    }
}
