package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
정올 1828 냉장고 (골드4)
https://www.jungol.co.kr/problem/1828?cursor=eyJwcm9ibGVtc2V0Ijo4LCJmaWVsZCI6MiwiaWR4IjozfQ%3D%3D
 */
public class Jungol_1828 {
    public static class Chemi implements Comparable<Chemi>{
        int str;
        int ed;

        public Chemi(int str, int ed){
            this.str = str;
            this.ed = ed;
        }

        // 시작 지점 오름차순 정렬, 같으면 ed가 최대한 큰 것(내림 차순 정렬) 
        @Override
        public int compareTo(Chemi o){
            return this.str != o.str ? this.str - o.str : o.ed - this.ed;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result = 0, curEd;

        List<Chemi> chemis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            chemis.add(new Chemi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(chemis);

        for (int i = 0; i < N; i++) {
            System.out.println(chemis.get(i).str + ", " + chemis.get(i).ed);
        }

        // 첫 냉장고와 끝지점 지정
        result += 1;
        curEd = chemis.get(0).ed;

        for (int i = 1; i < N; i++) {
            // 새 화학물질의 시작 온도가 전 끝 온도보다 크면(안 겹치면)
            if(chemis.get(i).str > curEd){
                result += 1;
                curEd = chemis.get(i).ed;
            // 새 화학물질의 시작 온도가 전 끝 온도보다 작으면(겹치면)
            }else if(chemis.get(i).str <= curEd){
                curEd = Math.min(curEd, chemis.get(i).ed);
            }
        }

        System.out.println(result);
    }
}
