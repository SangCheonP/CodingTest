package Theory.Permutation;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        // step0 : 정렬(오름차순)
        Arrays.sort(input);

        do {
            // 순열이용한 처리 로직
            System.out.println(Arrays.toString(input));
        }while (np(input));

    }

    public static boolean np(int[] p){ // 현순열의 사전순 다음 순열 생성 (p: 현 순열)
        final int N = p.length;

        // step1 : 교환위치(i-1) 찾기 (뒤쪽부터 꼭대기를 찾으면 꼭대기(i) 이전이 교환위치가 됨)
        int i = N - 1;
        // 오르막이면 계속 찾아봄
        while(i > 0 && p[i-1] >= p[i]) --i;

        // 끝이거나(i == 0), 내 앞이 나보다 작을 때 (p[i-1] < p[i])
        if(i == 0) return false; // 현순열의 상태가 가장 큰 순열이므로 np 없음

        // step2 : 교환위치(i-1)에 넣을 값 뒤쪽부터 찾기 (큰 값 중 최소값)
        int j = N - 1;
        while(p[i-1] >= p[j]) --j; // 큰 j위치를 찾으면 멈춤

        // step3 : 교환위치(i-1) 값과 찾은 위치(j) 값 교환
        swap(p, i-1, j);

        // step4 : 꼭대기(i) 위치부터 맨뒤까지 오름차순 정렬
        int k = N - 1;
        while(i < k) swap(p, i++, k--); // i == k일때 멈춤

        return true;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
