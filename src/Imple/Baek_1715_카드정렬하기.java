package Imple;

import java.util.*;
import java.io.*;

public class Baek_1715_카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();

            int n3 = n1 + n2;

            result += n3;
            pq.offer(n3);
        }

        System.out.println(result);
    }
}
