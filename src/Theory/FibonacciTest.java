package Theory;
/*
메모이제이션 VS 사용X 재귀 비교
피보나치 수열
 */
import java.util.Scanner;

public class FibonacciTest {
    static long callCnt1, callCnt2;
    static long[] memo;

    static long fibo1(int n){
        callCnt1++;

        if(n<2)
            return n;

        return fibo1(n-1) + fibo1(n-2);
    }

    static long fibo2(int n){
        callCnt2++;

        // 메모 안되어 있다면 계산 후 메모
        if(n>=2 && memo[n] == 0)
            memo[n] = fibo2(n-1) + fibo2(n-2);

        // 메모된 값 리턴
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        memo = new long[N+1]; // 0으로 자동 초기화 (메모되지 않은 상태)
        memo[0] = 0;
        memo[1] = 1;

        System.out.println("fibo2 " + fibo2(N) + ", 함수 호출 횟수 : " + callCnt2);
        System.out.println("fibo1 " + fibo1(N) + ", 함수 호출 횟수 : " + callCnt1);
    }
}
