package Bruteforce;

import java.util.*;
import java.io.*;

/**
 * 시간 : 1억 안에 끝날 듯 하니, OK
 * 공간 : 변수만 사용해서 문제없음
 * 예외 :
 */

public class Baek_1436_영화감독숌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0, cur = 665;

        while(cnt < N) {
            cur++;
            if(Integer.toString(cur).contains("666")) {
                cnt++;
            }
        }

        System.out.println(cur);
    }
}
