package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 4153 직각삼각형
https://www.acmicpc.net/problem/4153
 */
public class Baek_4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        while (a != 0 && b != 0 & c!= 0){
            if(a >= b){
                if(a >= c){
                    System.out.println(Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2)) ? "right" : "wrong");
                // c > a
                }else{
                    System.out.println(Math.pow(c, 2) == (Math.pow(b, 2) + Math.pow(a, 2)) ? "right" : "wrong");
                }
            // b > a
            }else {
                if(b >= c){
                    System.out.println(Math.pow(b, 2) == (Math.pow(a, 2) + Math.pow(c, 2)) ? "right" : "wrong");
                    // c > b
                }else{
                    System.out.println(Math.pow(c, 2) == (Math.pow(b, 2) + Math.pow(a, 2)) ? "right" : "wrong");
                }
            }

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}
