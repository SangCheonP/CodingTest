package 코테_기본;

/**
 * 시간 : 초기화 -> O(10 * 10) * 색종이 개수 -> N * O(100) -> O(N), 개수는 각 색종이들마다 세므로 앞에 포함됨
 * 공간 : boolean[101][101] 충분
 * 예외 : 색종이가 도화지 밖으로 나가는 경우는 없다 -> 크게 고려할 게 없음, 그나마 색종이 사이즈가 OXO 인 경우
 */

import java.util.*;
import java.io.*;

public class Baek_2563_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int result = 0;

        boolean[][] check = new boolean[101][101];

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            for (int ti = i; ti < i + 10; ti++) {
                for (int tj = j; tj < j + 10; tj++) {
                    if(!check[ti][tj]){
                        check[ti][tj] = true;
                        result++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb);
    }
}