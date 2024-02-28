package Heap;
/*
SWEA 3000 중간값 구하기(D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-fO0s6ARoDFAXT
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3000_중간값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        PriorityQueue<Long> minHeap, maxHeap;

        // maxHeap 중간값 minHeap
        for (int tc = 1; tc <= TC; tc++) {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long A = Long.parseLong(st.nextToken());

            maxHeap.add(A);

            long result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                long l = Long.parseLong(st.nextToken());
                long r = Long.parseLong(st.nextToken());

                maxHeap.add(l);
                minHeap.add(r);

                long outL = maxHeap.poll();
                long outR = minHeap.poll();

                if(outL <= outR){
                    result += outL%20171109;
                    maxHeap.add(outL);
                    minHeap.add(outR);
                }else {
                    result += outR%20171109;
                    maxHeap.add(outR);
                    minHeap.add(outL);
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
