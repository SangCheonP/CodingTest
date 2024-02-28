package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 3304 최장 공통 부분 수열
https://swexpertacademy.com/main/code/pro%E3%85%81blem/problemDetail.do?contestProbId=AWBOHEx66kIDFAWr
 */
public class SWEA_3304_최장공통부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        String str1, str2;

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            str1 = st.nextToken().toString();
            str2 = st.nextToken().toString();

            int[][] dp = new int[str1.length()+1][str2.length()+1];

            for (int i = 1; i <= str1.length(); i++) {
                for (int j = 1; j <= str2.length(); j++) {
                    // 매칭
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    // 매칭X
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[str1.length()][str2.length()]);
        }
    }
}
