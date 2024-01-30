package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1244 {
    // 1: 켜져있음, 0: 꺼져 있음
    // 남(1): 자기가 받은 수의 배수들의 상태를 바꿈
    // 여(2): 자기가 받은 수의 좌우가 대칭인 그 구간의 모든 스위치 바꿈

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        int switchN = Integer.parseInt(br.readLine());
        int[] switchs = new int[switchN + 1];
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 1; i < switchs.length; i++){
            switchs[i] = tmp[i - 1];
        }

        // 학생수
        int stdN = Integer.parseInt(br.readLine());
        // 성별, 받은 스위치 번호
        int[][] stdArr = new int[stdN][2];

        for(int i = 0; i < stdN; i++){
            String[] ns = br.readLine().split(" ");
            stdArr[i][0] = Integer.parseInt(ns[0]);
            stdArr[i][1] = Integer.parseInt(ns[1]);
        }

        for(int i = 0; i < stdN; i++){
            int gen = stdArr[i][0];
            int num = stdArr[i][1];

            if(gen == 1){
                int mul = 1;
                while(mul * num < switchs.length){
                    if(switchs[mul * num] == 1){
                        switchs[mul * num] = 0;
                    }else{
                        switchs[mul * num] = 1;
                    }
                    mul++;
                }
            }else{
                int idx = 0;
                while(true){
                    if(num - idx < 1 || num + idx > switchs.length - 1){
                        break;
                    }
                    if(switchs[num - idx] == switchs[num + idx]){
                        if(switchs[num - idx] == 0){
                            switchs[num - idx] = 1;
                            switchs[num + idx] = 1;
                            idx++;
                        }else{
                            switchs[num - idx] = 0;
                            switchs[num + idx] = 0;
                            idx++;
                        }
                    }else
                        break;
                }
            }
        }

        for(int i = 1; i < switchs.length; i++){
            System.out.print(switchs[i] + " ");
            if(i % 20 == 0)
                System.out.println();
        }
    }
}
