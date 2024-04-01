package Perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_4008_숫자만들기 {
    public static int N;
    public static long max, min;
    public static int[] nums; // 숫자 배열
    public static char[] result; // 기호 조합 배열
    public static boolean[] visited; // 기호 조합시 사용
    public static List<Character> signs; // 조합된 기호
    public static HashMap<String, Integer> map; // 기호 중복 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());

            max = Long.MIN_VALUE;
            min = Long.MAX_VALUE;

            nums = new int[N];
            visited = new boolean[N-1];
            result = new char[N-1];
            signs = new ArrayList<>();
            map = new HashMap<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                int end = Integer.parseInt(st.nextToken());
                switch (i){
                    case 0:
                        for (int j = 0; j < end; j++) {
                            signs.add('+');
                        }
                        break;
                    case 1:
                        for (int j = 0; j < end; j++) {
                            signs.add('-');
                        }
                        break;
                    case 2:
                        for (int j = 0; j < end; j++) {
                            signs.add('*');
                        }
                        break;
                    case 3:
                        for (int j = 0; j < end; j++) {
                            signs.add('/');
                        }
                        break;
                }
            }

            nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            perm(0);

            System.out.println("#"+tc + " " + Math.abs(max-min));
        }
    }

    public static void perm(int idx){
        if(idx == N-1){
            if(!map.containsKey(String.valueOf(result))){
                map.put(String.valueOf(result), 1);

                long tmp = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    switch (result[i-1]){
                        case '+':
                            tmp += nums[i];
                            break;
                        case '-':
                            tmp -= nums[i];
                            break;
                        case '*':
                            tmp *= nums[i];
                            break;
                        case '/':
                            tmp /= nums[i];
                            break;
                    }
                }

                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
            return;
        }

        for (int i = 0; i < N-1; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            result[idx] = signs.get(i);
            perm(idx+1);
            visited[i] = false;
        }
    }
}
