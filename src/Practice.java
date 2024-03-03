import java.util.Arrays;
/*
순조부
 */

public class Practice {
    static char[] cards = {'A', 'B', 'C', 'D', 'E'};
    static char[] result = new char[5];
    static char[] combResult = new char[3];
    static boolean[] isSelected = new boolean[5];
    public static void main(String[] args) {
        //순열
        //perm(0);

        // 특정 idx가 고정된 순열(A를 중간에 배치)
//        isSelected[0] = true;
//        result[2] = cards[0];
//        perm2(0);
        
        // 조합 5개중 3개 뽑음
        //comb(0, 0);

        // 공집합을 제외한 부분집합
        subset(0);
        
    }

    static void perm(int idx){
        if(idx == 5){
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < 5; i++) {
            if(isSelected[i])
                continue;

            isSelected[i] = true;
            result[idx] = cards[i];
            perm(idx + 1);
            isSelected[i] = false;
        }
    }

    static void perm2(int idx){
        if(idx == 5){
            System.out.println(Arrays.toString(result));
            return;
        }

        if(idx == 2){
            perm2(3);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if(isSelected[i])
                continue;

            isSelected[i] = true;
            result[idx] = cards[i];
            perm2(idx + 1);
            isSelected[i] = false;
        }
    }

    static void comb(int idx, int cnt){
        if(cnt == 3){
            System.out.println(Arrays.toString(combResult));
            return;
        }

        if(idx == 5){
            return;
        }

        // 선택O
        combResult[cnt] = cards[idx];
        comb(idx + 1, cnt + 1);
        // 선택X
        comb(idx + 1, cnt);
    }

    static void subset(int idx){
        if(idx == 5){
            for (int i = 0; i < 5; i++) {
                if(isSelected[i]){
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
}
