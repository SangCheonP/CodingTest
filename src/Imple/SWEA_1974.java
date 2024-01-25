package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA_1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int tc = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tc; i++){
            int[][] arr = new int[9][9];
            int result = 1;
            Map<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < arr.length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < arr[j].length; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 검사
            for(int j = 0; j < arr.length; j++){
                if(result == 1){
                    for(int k = 0; k < arr[j].length; k++){
                        // 해당 숫자가 안 나왔으면
                        if(!map.containsKey(arr[j][k])){
                            map.put(arr[j][k], 1);
                        }else{ // 해당 숫자나 나왔었다면
                            result = 0;
                            break;
                        }
                    }
                    map.clear();
                }
            }


            // 세로 검사
            if(result == 1) {
                for (int j = 0; j < arr.length; j++) {
                    if (result == 1) {
                        for (int k = 0; k < arr[j].length; k++) {
                            if (!map.containsKey(arr[k][j])) {
                                map.put(arr[k][j], 1);
                            } else {
                                result = 0;
                                break;
                            }
                        }
                        map.clear();
                    }

                }
            }

            // 정사각형 검사
            if(result == 1) {
                // 큰 사각형
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        // 작은 사각형 안
                        for(int z = 0; z < 3; z++){
                            for(int x = 0; x < 3; x++){
                                if (!map.containsKey(arr[z][x])) {
                                    map.put(arr[z][x], 1);
                                } else {
                                    result = 0;
                                    break;
                                }
                            }
                        }
                        map.clear();
                    }
                }
            }

            System.out.println("#" + i +" " + result);
        }
    }
}
