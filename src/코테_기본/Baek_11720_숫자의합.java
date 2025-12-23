package 코테_기본;

import java.io.*;
import java.util.*;

public class Baek_11720_숫자의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int result = 0;

        String sNums = br.readLine();
        for (int i = 0; i < c; i++) {
            result += sNums.charAt(i) - '0';
        }

        System.out.println(result);
    }
}