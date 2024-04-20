package DP;

import java.io.*;
import java.util.*;

public class Baek_2156_포도주시식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        if(N == 1){
            result = arr[0];
        }else if(N == 2){
            result = arr[0] + arr[1];
        }else{
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max((arr[1] + arr[2]), Math.max((arr[0] + arr[1]), (arr[0] + arr[2])));

            // dp
            // 1. 전와인 + 현재 와인(전전전 와인까지고려 값을 사용)
            // 2. 전전와인 + 현재 와인
            // 3. 현재 와인 안 마심
            for(int i = 3; i < N; i++){
                    dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i]);
            }
            result = dp[N-1];
        }

        System.out.println(result);
    }
}
