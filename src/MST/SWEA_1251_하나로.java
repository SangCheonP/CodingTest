package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
SWEA 1251 하나로(D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
 */
public class SWEA_1251_하나로 {
    static int N;
    static double[] x, y;
    static double E;
    static List<Edge> edges;
    static int[] parent;

    static class Point{
        double x, y;

        Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Edge implements Comparable<Edge>{
        Point p1, p2;
        double dis;

        Edge(Point p1, Point p2, double dis){
            this.p1 = p1;
            this.p2 = p2;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "p1=" + p1 +
                    ", p2=" + p2 +
                    ", dis=" + dis +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            x = new double[N];
            y = new double[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Double.parseDouble(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Double.parseDouble(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            edges = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    edges.add(new Edge(new Point(x[i], y[i]), new Point(x[j], y[j]), Math.round(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2))));
                }
            }

            Collections.sort(edges);

            makeSet();

            int cnt = 0;
            double result = 0;

            for (Edge e: edges){
                int i1 = find_idx(e.p1);
                int i2 = find_idx(e.p2);

                if(find_res(i1) != find_res(i2)){
                    result += e.dis;
                    cnt += 1;

                    union(i1, i2);

                    if(cnt == N -1)
                        break;
                }
            }

            System.out.println("#" + tc + " " + (long)result);
        }
    }

    static int find_idx(Point point){
        for (int i = 0; i < N; i++) {
            if(point.x == x[i] && point.y == y[i])
                return i;
        }
        return 0;
    }

    static void makeSet(){
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    static int find_res(int x){
        if(x != parent[x]){
            return parent[x] = find_res(parent[x]);
        }
        return x;
    }

    static boolean union(int x, int y){
        int x_res = find_res(x);
        int y_res = find_res(y);

        // 같은 집합이면
        if(x_res == y_res)
            return false;

        parent[y_res] = x_res;

        return true;
    }
}

