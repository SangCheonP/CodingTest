package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1074 Z (실버1)
https://www.acmicpc.net/problem/1074
https://ggasoon2.tistory.com/11
 */
public class Baek_1074 {
    public static int N, r, c, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 배열의 크기, r행 c열을 몇번째 방문했는지 출력
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        result = 0;

        //div(N, 0, (int) Math.pow(2, N) - 1, 0, (int) Math.pow(2, N) - 1);

        System.out.println(sol(N, r, c));
    }

    public static int sol(int N, int r, int c){
        if(N == 0)
            return 0;

        return 2*(r%2) + (c%2) + 4*sol(N-1, r/2, c/2);
    }

//    public static void div(int N, int stR, int edR, int stC, int edC){
//        if(N == 0)
//            return;
//        // 4가지
//        int pow4 = (int) Math.pow(4, N - 1);
//
//        // 좌상
//        if(stR <= r && r <= (stR+edR)/2 && stC <= c && c <= (stC+edC)/2){
//            div(N - 1, stR, edR/2, stC, edC/2);
//
//        // 우상
//        } else if (stR <= r && r <= (stR+edR)/2 && (stC+edC)/2+1 <= c && c <= edC) {
//            // 마지막 곱한 것은 개수
//            result += 1 * pow4 * 1;
//            div(N - 1, stR, edR/2, (stC+edC)/2, edC);
//
//        // 좌하
//        } else if ((stR+edR)/2+1 <= r && r <= edR && stC <= c && c <= (stC+edC)/2) {
//            result += 1 * pow4 * 2;
//            div(N - 1, (stR+edR)/2, edR, stC, edC/2);
//
//        // 우하
//        } else if ((stR+edR)/2+1 <= r && r <= edR && (stC+edC)/2+1 <= c && c <= edC) {
//            result += 1 * pow4 * 3;
//            div(N - 1, (stR+edR)/2, edR, (stC+edC)/2, edC);
//        }
//    }
}
