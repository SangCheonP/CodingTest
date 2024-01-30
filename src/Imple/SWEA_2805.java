package Imple;
/*
SWEA 2805 농작물 수확하기 D3
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class SWEA_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            int formSize = Integer.parseInt(br.readLine());
            int result = 0;

            int[][] map = new int[formSize][formSize];

            for(int i = 0; i < formSize; i++){
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            int st = formSize/2;
            int ed = formSize/2;
            int h = 0;

            // 윗 부분 더함
            while(st >= 0 && ed < formSize && h <= formSize/2){
                for(int j = st; j <= ed; j++){
                    result += map[h][j];
                }

                h++;

                if(st - 1 >= 0 && ed + 1 < formSize){
                    st--;
                    ed++;
                }
            }

            st++;
            ed--;

            // 아랫 부분 더함
            while(st <= ed){
                for(int j = st; j <= ed; j++){
                    result += map[h][j];
                }

                h++;
                st++;
                ed--;
            }

            System.out.println("#" + tc + " "+result);
        }
    }
}
