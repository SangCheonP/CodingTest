package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2577 숫자의 개수
https://www.acmicpc.net/problem/2577
 */
public class Baek_2577_숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = 1;
        int[] result = new int[10];

        for (int i = 0; i < 3; i++) {
            num *= Long.parseLong(br.readLine());
        }

        char[] tmp = Long.toString(num).toCharArray();

        for (int i = 0; i < tmp.length; i++) {
            result[tmp[i] - '0'] += 1;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }
    }
}
