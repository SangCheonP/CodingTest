package 코테_기본;

/**
 * 시간 : 9X9 배열 한번만 돌으면 되니까 O(81) -> O(N)
 * 공간 : 변수만 사용해서 문제 없음
 * 예외 : 0 or 100미만 자연수 -> int 가능
 */

import java.io.*;
import java.util.*;

public class Baek_2566_최댓값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxN = -1;
        int maxI = -1, maxJ = -1;

        int temp;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 9; j++) {
                temp = Integer.parseInt(st.nextToken());
                if(temp > maxN) {
                    maxN = temp;
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxN).append("\n");
        sb.append(maxI).append(" ").append(maxJ);
        System.out.println(sb);
    }
}
