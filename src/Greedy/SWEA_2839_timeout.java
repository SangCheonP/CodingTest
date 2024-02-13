package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2839 설탕배달 (실버4)
 */
public class SWEA_2839_timeout {
    public static int N, result, limit;
    public static boolean canMake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        result = Integer.MAX_VALUE;
        // N에 딱 맞게 만들 수 있는 지 체크
        canMake = false;

        // 봉투를 가장 많이 사용하는 경우, 봉투의 수
        limit = N/3 + 1;

        recur(0, 0 ,0);

        if(canMake)
            System.out.println(result);
        else
            System.out.println(-1);

    }

    public static void recur(int idx, int bag3Cnt, int bag5Cnt){
        // 가지치기
        if(N < 3 * bag3Cnt + 5 * bag5Cnt || idx == limit )
            return;

        // 정확하게 N그램이 만들어지면
        if(N == 3 * bag3Cnt + 5 * bag5Cnt){
            result = Math.min(result, bag3Cnt+bag5Cnt);
            //System.out.println("3: " +bag3Cnt + ", 5: " + bag5Cnt);
            canMake = true;
            return;
        }

        // 3그램 봉지사용
        recur(idx+1, bag3Cnt+1, bag5Cnt);
        // 5그램 봉지사용
        recur(idx+1, bag3Cnt, bag5Cnt+1);
    }
}
