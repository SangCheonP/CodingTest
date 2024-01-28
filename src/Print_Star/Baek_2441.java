package Print_Star;

import java.util.Scanner;

public class Baek_2441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String star = "*";
        String clear = " ";

        for (int i = 0; i < n; i++) {
            System.out.print(clear.repeat(i));
            System.out.print(star.repeat(n - i));
            System.out.println();
        }
    }
}
