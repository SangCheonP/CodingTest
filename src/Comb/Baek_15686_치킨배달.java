package Comb;

import java.io.*;
import java.util.*;

public class Baek_15686_치킨배달 {
    static List<Point> homes, chks;
    static int N, M, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        chks = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1) {
                    homes.add(new Point(i, j));
                } else if (cur == 2) {
                    chks.add(new Point(i, j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        comb(new ArrayList<>(), 0);

        System.out.println(result);
    }

    static void comb(List<Point> sel, int start) {
        if (sel.size() == M) {
            int allChkLen = 0;
            for (Point home : homes) {
                int temp = Integer.MAX_VALUE;
                for (Point chk : sel) {
                    temp = Math.min(temp, Math.abs(home.i - chk.i) + Math.abs(home.j - chk.j));
                }
                allChkLen += temp;
            }

            result = Math.min(result, allChkLen);
            return;
        }

        for (int i = start; i < chks.size(); i++) {
            sel.add(chks.get(i));
            comb(sel, i + 1);
            sel.remove(sel.size() - 1);
        }
    }
}

class Point {
    int i, j;

    public Point(int i , int j) {
        this.i = i;
        this.j = j;
    }
}