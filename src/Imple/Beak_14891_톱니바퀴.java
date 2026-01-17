package Imple;

import java.util.*;
import java.io.*;

public class Beak_14891_톱니바퀴 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] gear = new int[4][8];
        for (int i = 0; i < 4; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = tmp[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            int[] dir = rollGear(select, d, gear);

            for (int i = 0; i < 4; i++) {
                int temp = dir[i];
                if (temp == 1) {
                    int keep = gear[i][7];
                    for (int j = 7; j >= 1; j--) {
                        gear[i][j] = gear[i][j - 1];
                    }
                    gear[i][0] = keep;
                } else if (temp == -1) {
                    int keep = gear[i][0];
                    for (int j = 0; j < 7; j++) {
                        gear[i][j] = gear[i][j + 1];
                    }
                    gear[i][7] = keep;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) {
                result += Math.pow(2, i);
            }
        }
        System.out.println(result);
    }

    static int[] rollGear(int sel, int d, int[][] gear) {
        int[] result = new int[4];
        result[sel] = d;

        for (int i = sel - 1; i >= 0; i--) {
            if (gear[i][2] != gear[i + 1][6]) {
                result[i] = result[i + 1] * (-1);
            } else {
                break;
            }
        }

        for (int i = sel + 1; i < 4; i++) {
            if (gear[i - 1][2] != gear[i][6]) {
                result[i] = result[i - 1] * (-1);
            } else {
                break;
            }
        }

        return result;
    }
}
