package Print_Star;

import java.util.Scanner;

public class Baek_2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String star = "*";
        String clear = " ";

        for (int i = 1; i <= n; i++) {
            System.out.print(clear.repeat(n - i));
            System.out.print(star.repeat(2*i - 1));
            System.out.println();
        }
    }
}
