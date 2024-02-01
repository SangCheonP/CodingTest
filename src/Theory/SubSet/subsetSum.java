package Theory.SubSet;

import java.util.Scanner;

public class subsetSum {
    static int N;
    static int target;
    static int [] arr;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        arr = new int[N];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        generatedSubSet(0, 0);
    }

    private static void generatedSubSet(int cnt, int sum){
        if(cnt == N){ // 모든 원소가 고려되었다면 부분집합을 구성하는 원소들의 합이 목표합인지 검사
            if(sum == target) {
                for(int i = 0; i < isSelected.length; i++){
                    if(isSelected[i]) System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        isSelected[cnt] = true; //  부분집합에 포함
        generatedSubSet(cnt + 1, sum + arr[cnt]);
        isSelected[cnt] = false; //  부분집합에 미포함
        generatedSubSet(cnt + 1, sum);
    }
}