package 코테_기본;

import java.io.*;
import java.util.*;

public class Baek_10818_최대최소 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (n < min) min = n;
            if (n > max) max = n;
        }

        System.out.println(min + " " + max);
    }
}