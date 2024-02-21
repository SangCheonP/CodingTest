package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1717 집합의 표현(골드5)
https://www.acmicpc.net/problem/1717
 */
public class Baek_1717_집합의표현 {
    public static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0 ~ n까지 사용
        p = new int[n+1];

        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a가 있는 집합과 b가 있는 집합을 합침
            if(cmd == 0){
                union(a, b);
            }else{
                // a와 b가 같은 집합이면
                if(check_res(a) == check_res(b)){
                    sb.append("yes").append("\n");
                // 다른 집합이라면
                }else{
                    sb.append("no").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    // y 집합의 대표를 x 집합의 대표로 바꿈
    public static boolean union(int x, int y){
        int x_res = check_res(x);
        int y_res = check_res(y);

        if(x_res == y_res)
            return false;

        p[y_res] = x_res;

        return true;
    }

    // 조상을 찾는 함수
    public static int check_res(int x){
        if(x == p[x])
            return x;
        else
            return p[x] = check_res(p[x]);
    }
}
