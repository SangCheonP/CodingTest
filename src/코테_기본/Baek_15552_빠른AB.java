package 코테_기본;

/**
 * BufferedReader / StringTokenizer / StringBuilder
 * String -> Int : Integer.parseInt()
 */

import java.io.*;
import java.util.*;

public class Baek_15552_빠른AB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            sb.append(n1 + n2).append("\n");
        }

        System.out.println(sb);
    }
}
