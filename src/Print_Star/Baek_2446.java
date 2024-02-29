package Print_Star;

import java.util.Scanner;

public class Baek_2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String star = "*";
        String clear = " ";

        for(int i = 0; i < n; i++){
            //System.out.print(clear.repeat(i));
            //System.out.println(star.repeat(2 * (n - i) - 1));
        }

        for(int i = n - 2; i >= 0; i--){
            int tmp = n;
            //System.out.print(clear.repeat(i));
            //System.out.println(star.repeat(2 * (tmp - i) - 1));
        }
    }
}
