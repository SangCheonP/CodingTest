package Bruteforce;

/**
 * 시간 : 최대 100개 중에서 3개를 뽑는 모든 경우의 수, 100^3 = 1,000,000 (일백만) -> 충분
 * 공간 : 최대 숫자 100개 저장 하는 int[100]
 * 예외 :
 */

import java.io.*;
import java.util.*;

public class Baek_2798_블랙잭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, result = -1;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = nums[i] + nums[j] + nums[k];

                    if(sum == M) {
                        System.out.println(M);
                        return;
                    }

                    if (sum < M) {
                        result = Math.max(result, sum);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
