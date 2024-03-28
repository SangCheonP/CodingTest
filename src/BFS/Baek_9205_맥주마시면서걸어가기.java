package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_9205_맥주마시면서걸어가기 {
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static class Point implements Comparable<Point>{
        int i, j, beerCnt, canMove, dis;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
            this.beerCnt = 20;
            this.canMove = 0;
            this.dis = 0;
        }

        public Point(int i, int j, int beerCnt, int canMove, int dis){
            this.i = i;
            this.j = j;
            this.beerCnt = beerCnt;
            this.canMove = canMove;
            this.dis = dis;
        }

        @Override
        public int compareTo(Point o){
            return this.dis - o.dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int martCnt = 0;
        List<Point> martList;
        Point start, end;

        for(int tc = 1; tc <= TC; tc++){
            martList = new ArrayList<>();
            martCnt = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int i = 0; i < martCnt; i++){
                st = new StringTokenizer(br.readLine());
                martList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            PriorityQueue<Point> queue = new PriorityQueue<>();
            queue.add(start);

            while(!queue.isEmpty()){
                Point cur = queue.poll();
                System.out.println("i: "+cur.i + ", j: " + cur.j);

                // 골인지점 도착
                if(cur.i == end.i && cur.j == end.j){
                    System.out.println("happy");
                    break;
                }

                // 편의점이면
                for(Point p : martList){
                    if(p.i == cur.i && p.j == cur.j){
                        queue.add(new Point(cur.i, cur.j, 19, 50, dis(cur.i, cur.j, end.i, end.j)));
                        break;
                    }
                }

                // 맥주를 마셔야 하면
                if(cur.canMove == 0){
                    // 맥주가 있으면
                    if(cur.beerCnt != 0){
                        queue.add(new Point(cur.i, cur.j, cur.beerCnt-1, 50, dis(cur.i, cur.j, end.i, end.j)));
                    }
                    // 맥주가 없으면
                    else{
                        System.out.println("sad");
                        break;
                    }
                    
                // 맥주를 안 마셔도 되면
                }else{
                    for(int d = 0; d < 4; d++){
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];

                        if(-32768 <= ni && ni <= 32767 && -32768 <= nj && nj <= 32767){
                            queue.add(new Point(ni, nj, cur.beerCnt, cur.canMove-1, dis(ni, nj, end.i, end.j)));
                        }
                    }
                }
            }
        }
    }

    public static int dis(int si, int sj, int ei, int ej){
        return Math.abs(si-ei) + Math.abs(sj-ej);
    }
}
