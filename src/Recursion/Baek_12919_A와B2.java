package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 12919 A와B 2 골5
 * https://acmicpc.net/problem/12919
 *
 */

public class Baek_12919_A와B2 {
    static StringBuilder S, T;
    static boolean canMake = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = new StringBuilder(br.readLine()); // 목표 문자열
        T = new StringBuilder(br.readLine()); // 시작 문자열

        recur(T);

        if (canMake) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void recur(StringBuilder cur) {
        // 이미 만들 수 있으면 중단
        if (canMake) {
            return;
        }

        // 길이가 S와 같아지면 비교
        if (cur.length() == S.length()) {
            if (cur.toString().equals(S.toString())) {
                canMake = true;
            }
            return;
        }

        // 길이가 더 긴 경우만 처리
        if (cur.length() > S.length()) {
            // 현재 문자열을 복사하여 새롭게 처리
            if (cur.charAt(cur.length() - 1) == 'A') {
                StringBuilder next = new StringBuilder(cur);
                next.deleteCharAt(next.length() - 1); // 마지막 문자 A 제거
                recur(next);
            }

            // 첫 번째 문자가 B인 경우
            if (cur.charAt(0) == 'B') {
                StringBuilder next = new StringBuilder(cur);
                next.deleteCharAt(0); // 첫 번째 문자 B 제거
                next.reverse(); // 뒤집기
                recur(next);
            }
        }
    }
}
