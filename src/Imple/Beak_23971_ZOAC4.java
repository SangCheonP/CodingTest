package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준 23971 브3 ZOAC4
 *
 */
public class Beak_23971_ZOAC4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // H: 높이, W: 폭
        // N: 세로, M: 가로
        double H = Integer.parseInt(st.nextToken());
        double W = Integer.parseInt(st.nextToken());
        double N = Integer.parseInt(st.nextToken());
        double M = Integer.parseInt(st.nextToken());

        int ci = (int)Math.ceil(H/(N+1));
        int cj = (int)Math.ceil(W/(M+1));

        System.out.println(ci * cj);
    }
}
