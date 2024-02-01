package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
백준 14889 스타트와 링크 (실버 1)
https://www.acmicpc.net/problem/14889
 */
public class Baek_14889 {
    public static int N;
    public static int[][] map;
    public static int[] start;
    public static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수
        // 4 <= N <= 20
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        start = new int[N/2];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        isSelected[0] = true;
        start[0] = 1;

        comb(1, 1);
    }

    public static void comb(int idx, int trueCnt){
        if(idx == isSelected.length && trueCnt == N/2){
            System.out.println(Arrays.toString(isSelected));
            // true -> start 나
            return;
        }
        if (idx == isSelected.length) {
            return;
        }

        isSelected[idx] = true;
        comb(idx + 1, trueCnt + 1);

        isSelected[idx] = false;
        comb(idx + 1, trueCnt);
    }
}
