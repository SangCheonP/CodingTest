package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
SWEA 1225 암호생성기 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
 */
public class SWEA_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            Queue<Integer> queue = new ArrayDeque<>();
            int TC = Integer.parseInt(br.readLine());

            String[] nums = br.readLine().split(" ");

            for(String n : nums){
                queue.offer(Integer.parseInt(n));
            }

            int cur = 1;

            while(true){

                cur = cur % 6;

                if(cur == 0)
                    cur = 1;

                int outNum = queue.poll();
                outNum = (outNum - cur) < 0 ? 0 : outNum - cur;

                queue.offer(outNum);

                if(outNum == 0){
                    System.out.print("#" + tc);
                    List<Integer> sout = new ArrayList<>(queue);
                    for(int j = 0; j < 8; j++){
                        System.out.print(" " + sout.get(j));
                    }
                    System.out.println();
                    break;
                }


                cur++;
            }
        }
    }
}
