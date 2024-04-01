package Perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.IntBuffer;
import java.util.Arrays;

public class SWEA_4008_숫자만들기2 {
    public static int N, min, max;
    public static int[] signs, nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());

            signs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            int[] op = new int[4];
            dfs(op, 1, nums[0]);

            System.out.println("#"+tc+" "+Math.abs(max-min));
        }
    }

    public static void dfs(int[] op, int idx, int sum){
        // 모든 조합을 다 만들면
        if(idx == N){
            // 개수 맞는지 체크
            if(op[0] == signs[0] && op[1] == signs[1] && op[2] == signs[2] && op[3] == signs[3]) {
                max = Math.max(sum, max);
                min = Math.min(sum, min);
            }
        }else{
            // 사칙연산
            for (int i = 0; i < 4; i++) {
                op[i] += 1;

                // 해당 연산자를 더 많이 사용했으면 패스
                if(op[0] > signs[0]){
                    op[i] -= 1;
                    continue;
                }
                
                switch (i){
                    case 0:
                        dfs(op, idx+1, sum+nums[idx]);
                        break;
                    case 1:
                        dfs(op, idx+1, sum-nums[idx]);
                        break;
                    case 2:
                        dfs(op, idx+1, sum*nums[idx]);
                        break;
                    case 3:
                        dfs(op, idx+1, sum/nums[idx]);
                        break;
                }

                op[i] -= 1;
            }
        }
    }


}
