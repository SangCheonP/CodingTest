package DP;

import java.util.*;
import java.io.*;

public class Baek_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N + 1];
        map[1] = 0;

        for (int i = 2; i <= N; i++) {
            map[i] = map[i - 1] + 1;
            if (i % 2 == 0) {
                map[i] = Math.min(map[i / 2] + 1, map[i]);
            }
            if (i % 3 == 0) {
                map[i] = Math.min(map[i / 3] + 1, map[i]);
            }
        }

        System.out.println(map[N]);
    }
}
