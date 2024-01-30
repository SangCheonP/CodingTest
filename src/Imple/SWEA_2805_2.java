package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2805_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            int formSize = Integer.parseInt(br.readLine());

            int[][] map = new int[formSize][formSize];

            for(int i = 0; i < map.length; i++){
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            int st = formSize/2;
            int ed = formSize/2;

            int result = 0;

            for(int i = 0; i < map.length; i++){
                for(int j = st; j <= ed; j++){
                    result += map[i][j];
                }
                if(i < formSize/2){
                    st--;
                    ed++;
                }else{
                    st++;
                    ed--;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}

