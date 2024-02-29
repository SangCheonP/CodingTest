package Print_Star;

import java.util.Scanner;

public class Baek_2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String star = "*";
        String clear = " ";

        for(int i = 1; i <= n; i++){
            //System.out.print(clear.repeat(n - i));
            //System.out.print(star.repeat(2 * i - 1));
            System.out.println();
        }
        for(int i = n-1; i > 0; i--){
            int tmp = n;
            //System.out.print(clear.repeat(tmp - i));
            //System.out.println(star.repeat(2 * i - 1));
        }
    }
}
