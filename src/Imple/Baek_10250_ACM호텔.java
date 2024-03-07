package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 10250 ACM 호텔
https://www.acmicpc.net/problem/10250
 */
public class Baek_10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int TC = Integer.parseInt(br.readLine());
        int H, W, N;

        for (int tc = 1; tc <= TC; tc++) {
            // H: 높이 / W: 거리 / N: 몇 번째 손님
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            sb = new StringBuilder();

            int YY;
            if(N % H == 0){
                YY = H;
            }else{
                YY = N % H;
            }

            sb.append(YY);

            int XX = 1;
            if(N % H == 0){
                XX = N / H;
            } else if (N > H) {
                XX = N / H + 1;
            } else if (N < H) {
                XX = 1;
            }

            if(XX < 10){
                sb.append(0).append(XX);
            }else {
                sb.append(XX);
            }
            System.out.println(sb);
        }
    }
}
