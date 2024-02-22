package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2567 색종이 - 2 (실버4)
 */
public class Baek_2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int[][] map = new int[110][110];
        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};
        int result = 0;

        for(int tc = 0; tc < TC; tc++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());



            for(int i = u; i < u + 10; i++){
                for (int j = l; j < l + 10; j++) {
                    if(map[100 - i][j + 2] == 0){
                        map[100 - i][j + 2] = 1;
                    }
                }
            }
        }
        // 색종이 근처에 0이 있으면 해당 부분 더함
        for (int i = 0; i < 110; i++) {
            for (int j = 0; j < 110; j++) {
                if(map[i][j] == 1){
                    for (int d = 0; d < 4; d++) {
                        if(map[i + di[d]][j + dj[d]] == 0)
                            result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
