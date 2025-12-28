package Bruteforce;

/**
 * 시간 : 1,000,000 * 7(최대) -> 충분
 * 공간 : 변수만 선언
 * 예외 :
 */

import java.util.*;
import java.io.*;

public class Baek_2231_분해합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int cur = 0; cur <= N; cur++) {
            int sum = cur;
            int temp = cur;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(sum == N) {
                result = cur;
                break;
            }
        }

        System.out.println(result);
    }
}
