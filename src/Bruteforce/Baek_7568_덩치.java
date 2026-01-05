package Bruteforce;

/**
 * 시간 : 최대 50 * 50이라 문제X
 * 공간 : 최대 50인 리스트와 배열이니까 문제X
 * 예외 :
 */

import java.util.*;
import java.io.*;

public class Baek_7568_덩치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people[i] = new Person(w, h);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if (i == j) continue;
                if (people[i].w < people[j].w && people[i].h < people[j].h) rank++;
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

class Person {
    int w;
    int h;

    public Person(int w, int h) {
        this.w = w;
        this.h = h;
    }
}