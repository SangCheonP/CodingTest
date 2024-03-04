package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2920 음계
https://www.acmicpc.net/problem/2920
 */
public class Beak_2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[8];

        for (int i = 0; i < 8; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if(input[0] == 1){
            int str = 1;
            for (int n : input) {
                if(str++ != n)
                    break;
            }
            if (str == 9){
                System.out.println("ascending");
            }else{
                System.out.println("mixed");
            }
        }else if(input[0] == 8){
            int str = 8;
            for (int n : input) {
                if(str-- != n)
                    break;
            }
            if (str == 0){
                System.out.println("descending");
            }else{
                System.out.println("mixed");
            }
        }else{
            System.out.println("mixed");
        }

    }
}
