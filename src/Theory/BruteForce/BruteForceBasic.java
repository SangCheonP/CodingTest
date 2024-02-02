package Theory.BruteForce;
/*
순, 조, 부 연습코드
 */


import java.util.Arrays;

public class BruteForceBasic {
    static String[] cards = {"A","B","C", "D","E"};
    static int N=5, R=3;
    static boolean[] isSelected = new boolean[N];
    static String[] result = new String[R];
    
    public static void main(String[] args) {
        // 여기서 아래 4개의 실행을 모두 테스트 하시오!!!
        //perm(0);
        //subset(0);
        comb1(0, 0);
        //comb2(0, 0);
    }
    
    // 5개중에 3개 뽑아 순서 나열하는 순열 구현(원소 비중복)
    static void perm(int idx) {
        if(idx == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i = 0; i < N; i++){
            if(isSelected[i] == true)
                continue;
            isSelected[i] = true;
            result[idx] = cards[i];
            perm(idx + 1);
            isSelected[i] = false;
        }
    }
    
    // 5개의 재료중 그 무엇이든 상관없이 부분 원소로 구현된 모든 부분집합 구현
    static void subset(int idx) {
        if(idx == N){
            for(int i = 0; i < N; i++){
                if(isSelected[i] == true){
                    System.out.print(cards[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        isSelected[idx] = true;
        subset(idx + 1);
        isSelected[idx] = false;
        subset(idx + 1);
    }
    
    // 5개중에 3개 뽑은 순서 상관없는 조합 구현 : 태희쌤 버전 반복문 사용 (비중복 조합)
    static void comb1(int idx, int cnt) {
        if(cnt == R){
            System.out.println(Arrays.toString(result));
            return;
        }
        if(idx == N)
            return;

        for(int i = idx; i < N; i++){
            result[cnt] = cards[i];
            comb1(i + 1, cnt + 1);
        }
    }
    
    // 5개중에 3개 뽑은 순서 상관없는 조합 구현 : 양유 버전 반복문 사용금지!!(부분집합 버전) 
    static void comb2(int idx, int cnt) {
        if(cnt == R){
            for(int i = 0; i < isSelected.length; i++){
                if(isSelected[i]){
                    System.out.print(cards[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if(idx == cards.length){
            return;
        }

        isSelected[idx] = true;
        comb2(idx + 1, cnt + 1);
        isSelected[idx] = false;
        comb2(idx + 1, cnt);
    }
}