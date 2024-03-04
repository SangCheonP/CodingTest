package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2741 N번 찍기
https://www.acmicpc.net/problem/2741
 */
public class Baek_2741_N찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[8];

        int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] des = {8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < 8; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if(input.equals(asc)){

        }else if(input.equals(asc)){
            System.out.println("de");
        }else{
            System.out.println("mixed");
        }

    }
}
