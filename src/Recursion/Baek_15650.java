package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
백준 15650 N과 M(2) ()
https://www.acmicpc.net/problem/15650
 */
public class Baek_15650 {
    static boolean[] select;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        // 1 ~ N 까지
        N = Integer.parseInt(str[0]);
        // 한 수열 안에 M개
        M = Integer.parseInt(str[1]);
        select = new boolean[N];
        
        combin(0, 0);
    }

    static void combin(int idx, int cnt){
        if(cnt == M){
            for(int i = 0; i < select.length; i++){
                if(select[i]){
                    System.out.print((i+1) + " ");
                }
            }
            System.out.println();
            return;
        }

        if(idx == N)
            return;

        // 숫자 선택
        select[idx] = true;
        combin(idx + 1, cnt + 1);
        // 숫자 선택X
        select[idx] = false;
        combin(idx + 1, cnt);
    }
}
