package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_12919_A와B2 {
    static String T;
    static StringBuilder S;
    static boolean canMake = false;
    static char[] chars = {'A', 'B'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = new StringBuilder(br.readLine());
        T = br.readLine();

        // A: 맨 뒤에 추가
        // B: 맨 뒤에 추가 + 뒤집기
        // 1: 바O, 0: 바X

        BackTracking();

        if (canMake) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void BackTracking() {
        // 이미 만들 수 있으면
        if (canMake) {
            return;
        }

        // 목표 길이이면
        if (S.length() == T.length()) {
            if (S.toString().equals(T)) {
                canMake = true;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            // 맨 뒤에 추가
            S.append(chars[i]);

            // 추가한 문자가 B이면 뒤집기
            if (chars[i] == 'B') {
                S.reverse();
            }

            BackTracking();

            // 추가한 문자가 B이면 다시 뒤집기 (원상 복구)
            if (chars[i] == 'B') {
                S.reverse();
            }

            // 마지막 문자 제거
            S.deleteCharAt(S.length() - 1);
        }
    }
}
