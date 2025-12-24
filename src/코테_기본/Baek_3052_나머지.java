package 코테_기본;

import java.io.*;
import java.util.*;

public class Baek_3052_나머지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(Integer.parseInt(br.readLine()) % 42);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size());
        System.out.println(sb);
    }
}
