package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 14501 퇴사(실버3) - Greedy, Comb
https://www.acmicpc.net/problem/14501
 */
public class Baek_14501_퇴사 {
    public static int N, result;
    public static int[][] counsels;
    public static boolean[] canCoun;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        counsels = new int[N][2];
        canCoun = new boolean[N];

        for (int i = 0; i < N; i++) {
            // 0: 걸리는 시간 / 1: 이익
            st = new StringTokenizer(br.readLine());
            counsels[i][0] = Integer.parseInt(st.nextToken());
            counsels[i][1] = Integer.parseInt(st.nextToken());
        }

        // 상담 가능한 것들 체크
        for (int i = 0; i < N; i++) {
            if(i + counsels[i][0] <= N){
                canCoun[i] = true;
            }
        }

        result = 0;

        // 상담 가능한 것들만 가지고 조합을 만듦(단, 상담시간 유의)
        comb(0, 0);

        System.out.println(result);
    }

    public static void comb(int idx, int sum){
        // 끝까지 체크 or 해당 상담이후로 가능한 상담이 없을 때
        if(idx >= N || !remainCheck(idx)){
            result = Math.max(result, sum);
            return;
        }
        // 상담을 끝낼 수 있는 것이면
        if(canCoun[idx]){
            // 해당 idx날 상담 선택시, 변경된 날짜와 값을 넘겨줌
            comb(idx + counsels[idx][0], sum + counsels[idx][1]);
            // 상담 선택X
            comb(idx+1, sum);
        // 상담을 끝낼 수 없으면
        }else {
            // 상담 선택X
            comb(idx+1, sum);
        }

    }

    // 상담할 것이 남았는 지 체크
    public static boolean remainCheck(int idx){
        for (int i = idx; i < N; i++) {
            if(canCoun[i]){
                return true;
            }
        }
        return false;
    }
}

