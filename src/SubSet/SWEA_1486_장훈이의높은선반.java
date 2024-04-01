package SubSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486_장훈이의높은선반 {
    public static int N, B, result;
    public static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            // N: 점원의 수, B: 선반의 높이
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            result = Integer.MAX_VALUE;

            subset(0, 0);

            System.out.println("#"+tc + " " + result);
        }
    }

    public static void subset(int idx, int sum){
        if(idx == N && sum >= B){
            result = Math.min(result, sum - B);
        }

        if(idx == N)
            return;

        subset(idx+1, sum+nums[idx]);
        subset(idx+1, sum);

    }
}

