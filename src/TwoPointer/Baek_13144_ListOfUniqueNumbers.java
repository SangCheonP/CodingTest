package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 길이 N인 수열
 * 수열에서 연속한 1개 이상의 수를 뽑았을 때 -> 같은 수가 없는 경우의 수
 * 1 <= N <= 100,000
 * 
 * N이 크기 때문에 N or NlogN으로 풀어야함
 */
public class Baek_13144_ListOfUniqueNumbers {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 문제에서 숫자의 범위가 1 <= Ai <= 100,000이라고 가정
        boolean[] seen = new boolean[100_001];
        int result = 0;
        int left = 0, right = 0;

        while(left < N){
            // 가능한 만큼 right를 이동
            while(right < N && !seen[nums[right]]){
                seen[nums[right]] = true;
                right += 1;
            }

            // 현재 창의 크기를 결과에 더함
            result += (right - left);

            // left를 이동하며 seen에서 제거
            seen[nums[left]] = false;
            left += 1;
        }

        System.out.println(result);
    }
}
