package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
백준 2164 카드2 (실버4)
 */
public class Baek_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            que.offer(i);
        }

        while (que.size() != 1){
            // 맨 앞에서 하나 뺌
            que.poll();

            // 맨 앞에서 하나 빼서, 뒤에 넣음
            que.offer(que.poll());
        }
        System.out.println(que.peek());
    }
}
