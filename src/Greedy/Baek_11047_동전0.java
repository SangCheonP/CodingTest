package Greedy;

import java.util.*;
import java.io.*;

/** 전 단위로 다음 단위를 만들 수 있음 -> Ki = C * Ki-1
 *  시간 : 리스트 정렬 + 배열을 한번만 돌아서 배열크기 -> 문제없음
 *  공간 : 리스트 + 배열이라 문제없음
 *
 */

public class Baek_11047_동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > K) continue;
            list.add(num);
        }

        Collections.sort(list, Collections.reverseOrder());

        int cur = 0, sum = 0;

        for (int n : list) {
            int remain = K - sum;

            if(remain < n) continue;

            int add = remain / n;
            cur += add;
            sum += (add * n);

            if (sum == K) {
                System.out.println(cur);
                break;
            }
        }


    }
}
