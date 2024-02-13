package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 16435 스네이트버드 (실버5)
https://www.acmicpc.net/problem/16435
 */
public class Baek_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 과일의 개수, L: 스네이크버드의 초기 길이
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean isPrint = false;

        int[] fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 오름차순으로 정렬
        Arrays.sort(fruits);


        for (int i = 0; i < N; i++) {
            // 자기 길이보다 낮거나, 같은 열매 먹음
            if(L >= fruits[i]){
                L++;
            }
            // 자기 길이보다 크면
            else{
                System.out.println(L);
                isPrint = true;
                break;
            }
        }
        if(!isPrint)
            System.out.println(L);
    }
}
