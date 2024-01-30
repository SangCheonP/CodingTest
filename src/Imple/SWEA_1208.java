package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int bump = Integer.parseInt(br.readLine());
            int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 현재 덤프 횟수
            int cur = 0;
            int max = Integer.MIN_VALUE, maxIdx, min = Integer.MAX_VALUE, minIdx;

            while(cur++ < bump){
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                maxIdx = -1;
                minIdx = -1;

                for(int i = 0; i < map.length; i++){
                    if(map[i] > max) {
                        max = map[i];
                        maxIdx = i;
                    }
                    if(map[i] < min) {
                        min = map[i];
                        minIdx = i;
                    }
                }

                map[maxIdx]--;
                map[minIdx]++;
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            for(int i = 0; i < map.length; i++){
                if(map[i] > max) {
                    max = map[i];
                }
                if(map[i] < min) {
                    min = map[i];
                }
            }

            System.out.println("#" + tc + " " + (max - min));
        }
    }
}
