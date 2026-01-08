package Comb;

import java.io.*;
        import java.util.*;

/**
 * 시간 : 도시의 개수 * 치킨집 총 개수 C m = 100 * 13 C m -> 1억 미만이라 충붖ㄴ
 * 공간 : 리스트 2개 및 변수만 사용해서 충분
 * 예외 :
 */

public class Baek_15686_치킨배달 {
    static List<Point> homes, chickens;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int minCkLen = Integer.parseInt(st.nextToken());
                if (minCkLen == 1) {
                    homes.add(new Point(i, j));
                } else if (minCkLen == 2){
                    chickens.add(new Point(i, j));
                }
            }
        }

        result = Integer.MAX_VALUE;

        comb(M, 0, new ArrayList<>());

        System.out.println(result);
    }

    public static void comb(int M, int start, List<Integer> cur) {
        if(cur.size() == M) {
            int cityCkLen = 0;
            for (Point home : homes) {
                int minCkLen = Integer.MAX_VALUE;
                for (int ckIdx : cur) {
                    Point ck = chickens.get(ckIdx);
                    int len = Math.abs(home.i - ck.i) + Math.abs(home.j - ck.j);
                    minCkLen = Math.min(minCkLen, len);
                }

                cityCkLen += minCkLen;
            }

            result = Math.min(result, cityCkLen);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            cur.add(i);
            comb(M, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}


class Point {
    int i, j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}