package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_14888_연산자끼워넣기 {
    static int N;
    static long resultMax, resultMin;
    static int[] nums, signs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        signs = new int[4];
        for (int i = 0; i < 4; i++) {
            signs[i] = Integer.parseInt(st.nextToken());
        }

        // 최대, 최소값 초기화
        resultMax = Long.MIN_VALUE;
        resultMin = Long.MAX_VALUE;

        // 백트래킹 시작 (초기값은 nums[0]으로 시작)
        dfs(1, nums[0]);

        System.out.println(resultMax);
        System.out.println(resultMin);
    }

    /**
     * 백트래킹을 통해 모든 가능한 연산 순서를 탐색합니다.
     *
     * @param idx 현재 탐색할 숫자의 인덱스
     * @param calc 지금까지의 계산 결과
     */
    static void dfs(int idx, long calc) {
        if (idx == N) { // 모든 숫자를 사용했을 경우 최대/최소값 갱신
            resultMax = Math.max(resultMax, calc);
            resultMin = Math.min(resultMin, calc);
            return;
        }

        // 각 연산자를 사용하면서 재귀적으로 호출
        if (signs[0] > 0) { // '+' 연산자 사용 가능할 경우
            signs[0]--;
            dfs(idx + 1, calc + nums[idx]);
            signs[0]++;
        }
        if (signs[1] > 0) { // '-' 연산자 사용 가능할 경우
            signs[1]--;
            dfs(idx + 1, calc - nums[idx]);
            signs[1]++;
        }
        if (signs[2] > 0) { // '*' 연산자 사용 가능할 경우
            signs[2]--;
            dfs(idx + 1, calc * nums[idx]);
            signs[2]++;
        }
        if (signs[3] > 0) { // '/' 연산자 사용 가능할 경우
            signs[3]--;
            // 나눗셈의 경우 음수 나눗셈 처리 필요
            if (calc < 0) {
                dfs(idx + 1, -(-calc / nums[idx]));
            } else {
                dfs(idx + 1, calc / nums[idx]);
            }
            signs[3]++;
        }
    }
}
