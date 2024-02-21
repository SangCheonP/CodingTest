package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 3289 서로소 집합(D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
 */
public class SWEA_3289_서로소집합 {
    public static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();

            // n: 1 ~ n까지 n개의 집합 / m: 연산 수
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 1 ~ n까지 사용
            p = new int[n+1];

            // 대표를 자기 자신으로 설정
            for (int i = 1; i < n+1; i++) {
                p[i] = i;
            }

            // m번 연산
            for (int i = 0; i < m; i++) {
                // cmd: 연산 형태 / a, b: 연산에 사용되는 원소
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // a가 속한 집합과 b가 속한 집합을 합침
                if(cmd == 0){
                    union(a, b);
                }else{
                    // a와 b의 대표가 같으면(같은 집합이면)
                    if(find_res(a) == find_res(b)){
                        sb.append(1);
                    }else
                        sb.append(0);
                }
            }

            System.out.println("#" + tc + " " + sb);

        }
    }
    
    // x가 속한 집합과 y가 속한 집합을 합침
    // y가 속한 집합의 대표를 x가 속한 집합의 대표로 설정
    public static boolean union(int x, int y){
        int x_res = find_res(x);
        int y_res = find_res(y);

        if(x_res == y_res)
            return false;

        p[y_res] = x_res;

        return true;
    }
    
    // x가 속한 집합의 대표를 찾는 함수
    public static int find_res(int x){
        if(x == p[x])
            return x;
        else
            return p[x] = find_res(p[x]);
    }
}
