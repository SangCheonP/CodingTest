package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2839 설탕배달 (실버4)
 */
public class SWEA_2839 {
    public static int N, result, limit;
    public static boolean canMake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        result = Integer.MAX_VALUE;

        // 현재 남은 설탕
        int cur = N;

        // 5kg 봉투 개수
        int bag5Cnt = N / 5;
        cur = N % 5;

        // 3kg 봉투 개수
        int bag3Cnt = cur / 3;
        cur = cur % 3;

        while (true){
            // 딱 맞게 봉투를 못만들면
            if(bag5Cnt == 0 && cur != 0) {
                System.out.println(-1);
                break;
            }
            // 딱 맞게 봉투가 만들어지면
            else if(cur == 0) {
                System.out.println(bag3Cnt + bag5Cnt);
                break;
            }

            // 5kg 봉투 하나 줄임
            bag5Cnt--;
            cur += 5;

            // 3kg 봉투 최대한 늘림
            bag3Cnt += cur/3;
            cur %= 3;
        }
    }
}
