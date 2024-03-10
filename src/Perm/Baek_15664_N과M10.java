package Perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Baek_15664_N과M10 {
    static int N, M;
    static int[] inputArr, result;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 주어지는 자연수의 갯수 / M: 결과 수열의 길이
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 입력 받은 수 저장 배열
        inputArr = new int[N];
        // 사용한 수 체크 배열
        isSelected = new boolean[N];
        // 결과를 저장할 배열
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr);

        perm(0, 0);
    }

    static void perm(int idx, int cnt){
        // M개의 순열이 만들어지면
        if (cnt == M){
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        int before = -1;
        for (int i = idx; i < N; i++) {
            // 해당 숫자가 선택되었으면
            if(isSelected[i] || (before == inputArr[i])){
                continue;
            }

            // 해당 숫자 선택O
            isSelected[i] = true;
            result[cnt] = inputArr[i];
            perm(i+1, cnt+1);

            // 해당 숫자 선택X
            isSelected[i] = false;
            before = inputArr[i];
        }
    }
}
