package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
백준 1158 요세푸스 문제 (실버4)
https://www.acmicpc.net/problem/1158
 */
public class Beak_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder("<");

        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int chk = 1;

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }


        while(!queue.isEmpty()){
            if(chk == M){
                chk = 1;
                sb.append(queue.poll() + ", ");
            }else {
                chk += 1;
                queue.offer(queue.poll());
            }
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        System.out.println(sb.append(">"));
    }
}

