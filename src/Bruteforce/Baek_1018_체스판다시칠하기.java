package Bruteforce;

/**
 *  시간 : 50 * 50 * 64번 도니까 충분
 *  공간 : 50 * 50 하나만 사용해서 충분
 *  예외 :
 */

import java.util.*;
import java.io.*;

public class Baek_1018_체스판다시칠하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // i
        int M = Integer.parseInt(st.nextToken()); // j

        char[][] map = new char[N][M];

        for (int t = 0; t < N; t++) {
            map[t] = br.readLine().toCharArray();
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int temp = check(i, j, map);

                result = Math.min(result, temp);
            }
        }

        System.out.println(result);
    }

    static int check(int i, int j, char[][] map) {
        int count = 0;

        for (int y = i; y < i + 8; y++) {
            for (int x = j; x < j + 8; x++) {
                // (y + x)의 합이 짝수/홀수임에 따라 색이 번갈아 나와야 함
                boolean isWhiteExpected = ((y + x) % 2 == 0);

                if (isWhiteExpected) {
                    if (map[y][x] != 'W') count++;
                } else {
                    if (map[y][x] != 'B') count++;
                }
            }
        }

        return Math.min(count, 64 - count);
    }
}


