package 코테_기본;

import java.io.*;
import java.util.*;

public class Baek_1152_단어의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        while(st.hasMoreTokens()) {
            result++;
            st.nextToken();
        }

        System.out.println(result);
    }
}
