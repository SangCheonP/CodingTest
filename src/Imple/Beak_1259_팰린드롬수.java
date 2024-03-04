package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1259 팰린드롬수
https://www.acmicpc.net/problem/1259
*/
public class Beak_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] tmp;
        while ((tmp = br.readLine().toCharArray())[0] != '0'){
            boolean canMake = true;
            for (int i = 0; i < tmp.length/2; i++) {
                if(tmp[i] != tmp[tmp.length-1-i]){
                    canMake = false;
                    break;
                }
            }
            System.out.println(canMake ? "yes" : "no");
        }


    }
}
