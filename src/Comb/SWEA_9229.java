package Comb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
SWEA 9229 한빈이와 Spot Mart (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
 */
public class SWEA_9229 {
    public static int N, M, result;
    // 과자 봉지 무게 배열
    public static int[] wg;
    // 조합 저장 배열
    public static int[] combArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            String[] str = br.readLine().split(" ");
            // N: 과자 봉지의 개수, M: 최대 무게
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);

            result = -1;

            // 과자 봉지 무게 배열
            wg = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 조합을 찾고 조건에 맞으면 result에 담음
            combArr = new int[2];
            comb(0, 0);

//            for(int i = 0; i < N; i++){
//                for(int j = i + 1; j < N; j++){
//                    int sum = wg[i] + wg[j];
//                    if(sum > M)
//                        continue;
//                    result = Math.max(result, sum);
//                }
//            }

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void comb(int idx, int cnt){
        if(cnt == combArr.length) {
            int tmp = combArr[0] + combArr[1];
            if(tmp <= M)
                result = Math.max(result, tmp);
            return;
        }
        if(idx == wg.length)
            return;

        // 해당 무게 선택
        combArr[cnt] = wg[idx];
        comb(idx + 1, cnt + 1);
        // 해당 무게 선택X
        comb(idx + 1, cnt);
    }
}
