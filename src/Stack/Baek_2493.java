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
        long beforeTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // top 저장 배열
        int[] top = new int[N];
        int topIdx = -1;

        // 결과 저장 배열
        int[] result = new int[N];

        for(int curHigh : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()){

            top[++topIdx] = curHigh;

            int curIdx = topIdx - 1;

            while(curIdx >= 0){
                if(top[curIdx] >= top[topIdx]){
                    result[topIdx] = curIdx + 1;
                    break;
                }else {
                    curIdx--;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
