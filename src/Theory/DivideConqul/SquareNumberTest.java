package Theory.DivideConqul;

/*
분할 정복
 */
import java.util.Scanner;

public class SquareNumberTest {
    public static int callCnt1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt(); // 최대 10억까지 가능

        System.out.println(exp1(x, n));
        System.out.println("callCnt1: " + callCnt1);
    }

    // x를 n번 곱한 결과
    static long exp1(long x, int n){
        callCnt1++;
        if (n==1) return x;
        int half = n/2;
        long res = exp1(x, half);
        res *= res;
        return n%2==0? res : res * x;
    }
}
