package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
백준 11286 절댓값 힙 (실버1)
https://www.acmicpc.net/problem/11286
 */
public class Baek_11286 {
    public static class Num implements Comparable<Num> {
        public int abs;
        public int origin;

        public Num(int abs, int origin){
            this.abs = abs;
            this.origin = origin;
        }

        @Override
        public int compareTo(Num o) {
            // 오름차순 정렬
            if(this.abs == o.abs)
                // 절댓값이 같으면 작은 수가 우선 순위
                return this.origin - o.origin;
            return this.abs - o.abs;
        }
    }

    // Comparator 객체를 넣어주는 경우
    public static void main(String[] args) throws IOException {
        PriorityQueue<Num> pq = new PriorityQueue<>((n1, n2) -> {
            if(n1.abs == n2.abs)
                return n1.origin - n2.origin;
            return n1.abs - n2.abs;
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc++){
            int cur = Integer.parseInt(br.readLine());

            if(cur == 0){
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(pq.poll().origin).append('\n');
                }
            }else{
                pq.offer(new Num(Math.abs(cur), cur));
            }
        }
        System.out.println(sb);
    }
    
//    Comparable을 구현하는 방법
//    public static void main(String[] args) throws IOException {
//        PriorityQueue<Num> pq = new PriorityQueue<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int TC = Integer.parseInt(br.readLine());
//
//        for(int tc = 0; tc < TC; tc++){
//            int cur = Integer.parseInt(br.readLine());
//
//            if(cur == 0){
//                if(pq.isEmpty()){
//                    sb.append(0).append('\n');
//                }else{
//                    sb.append(pq.poll().origin).append('\n');
//                }
//            }else{
//                pq.offer(new Num(Math.abs(cur), cur));
//            }
//        }
//        System.out.println(sb);
//    }
}
