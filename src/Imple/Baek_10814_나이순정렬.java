package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 10814 나이순 정렬
https://www.acmicpc.net/problem/10814
 */
public class Baek_10814_나이순정렬 {
    static class People implements Comparable<People>{
        int age, time;
        String name;

        People(int age, int time, String name){
            this.age = age;
            this.time = time;
            this.name = name;
        }

        @Override
        public int compareTo(People o){
            if(this.age == o.age)
                return this.time - o.time;
            return Integer.compare(this.age, o.age);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<People> peopleList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            peopleList.add(new People(age, i, name));
        }

        Collections.sort(peopleList);

        for(People p : peopleList){
            System.out.println(p.age + " " + p.name);
        }
    }
}
