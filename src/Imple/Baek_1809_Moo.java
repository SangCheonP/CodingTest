package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1809_Moo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
    }
}
