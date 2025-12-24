package 코테_기본;

import java.io.*;

public class Baek_2562_최댓값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for (int i = 1; i <= 9; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n > max) {
                max = n;
                idx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(idx);

        System.out.println(sb);
    }
}
