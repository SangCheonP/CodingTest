package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_15649 {
    static int N = 0;
    static int M = 0;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        // 1 ~ N 까지 자연수 중에서 중복 없이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ~ N 까지
        int n1 = Integer.parseInt(st.nextToken());
        // 길이
        int n2 = Integer.parseInt(st.nextToken());

        N = n1;
        M = n2;

        printPerm(1);

    }

    static void printPerm(int N, int M){

    }
}
