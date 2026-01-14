package Greedy;

import java.util.*;
import java.io.*;

/**
 * 시간 : O(N log N)
 * - N개의 데이터를 우선순위 큐에 삽입: N * log N
 * - 큐에서 두 개를 꺼내고 다시 넣는 작업(N-1번 반복): (N-1) * 3 * log N
 * - 전체적으로 O(N log N)이므로 N=100,000일 때 약 170만 번의 연산으로 충분함.
 * * 공간 : O(N)
 * - PriorityQueue에 최대 N개의 데이터를 저장하므로 N에 비례하는 공간이 필요함.
 * * 예외 : N = 1일 때
 * - 비교 대상이 없으므로 비교 횟수는 0임. (현재 코드에서 이 부분을 0으로 출력하게 수정 필요)
 * - 결과값이 약 21억(int 범위)을 아슬아슬하게 넘길 가능성이 있다면 long 고려 필요.
 */

public class Baek_1715_카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() > 1) {
            int n = pq.poll() + pq.poll();
            result += n;
            pq.offer(n);
        }

        System.out.println(result);
    }
}
