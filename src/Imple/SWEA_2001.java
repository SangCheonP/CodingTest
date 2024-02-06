package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
SWEA 2001 파리퇴치 (D2)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
 */
public class SWEA_2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // N: 배열의 크기, M: 파리채의 크기
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            int result = 0;

            int[][] map = new int[N][N];

            for(int i = 0; i < N; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 파리채 전체 움직임
            for(int i = 0; i < N - M + 1; i++){
                for(int j = 0; j < N - M + 1; j++){
                    // 한 파리채의 값 구함
                    int tmp = 0;
                    for(int z = 0; z < M; z++){
                        for(int x = 0; x < M; x++){
                            tmp += map[i + z][j + x];
                        }
                    }
                    result = Math.max(result, tmp);
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
