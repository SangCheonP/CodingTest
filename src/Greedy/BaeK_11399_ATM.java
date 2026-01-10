package Greedy;

import java.util.*;
import java.io.*;

/**
 * 시간 : 리스트를 한 번만 돌아 문제없음
 * 공간 : 리스트를 하나만 사용해서 문제없음
 */

public class BaeK_11399_ATM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int result = 0;
        for (int i = N; i > 0; i--) {
            result += i * list.get(N - i);
        }

        System.out.println(result);

        /**
         * 1 = 1
         * 1 2 = 3
         * 1 2 3 = 6
         * 1 2 3 3 = 9
         * 1 2 3 3 4 = 13
         * => 32
         */
    }
}
