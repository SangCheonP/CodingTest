package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Baek 2563 색종이 (실버5)
https://www.acmicpc.net/problem/2563
 */
public class Baek_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int result = 0;
        boolean[][] map = new boolean[100][100];

        for (int tc = 0; tc < TC; tc++) {
            // 시작 지점
            st = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());

            // 해당 지점이 체크
            for(int i = si; i < si + 10; i++){
                for (int j = sj; j < sj + 10; j++) {
                    // 이미 체크돼 있으면 패스
                    if(map[i][j] == true)
                        continue;
                    // 체크 후, 크기 증가
                    else{
                        map[i][j] = true;
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
