package SubSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 1759 암호 만들기 (골드5)
https://www.acmicpc.net/problem/1759
 */
public class Baek_1759_암호만들기 {
    public static int L, C;
    public static List<Character> vowel, conso, result;
    public static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // L: 암호의 길이 / C: 암호로 사용했을 법한 문자의 종류
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        // vowel: 모음 / conso: 자음
        vowel = new ArrayList<>();
        conso = new ArrayList<>();

        // 자음과 모음 분리
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            char tmp = st.nextToken().charAt(0);
            if(tmp == 'a' || tmp == 'e' || tmp == 'i' ||tmp == 'o' || tmp == 'u'){
                vowel.add(tmp);
            }else{
                conso.add(tmp);
            }
        }

        list = new ArrayList<>();

        // 자음을 먼저 채움
        for (int goal = 2; goal <= L-1; goal++) {
            result = new ArrayList<>();
            combCon(0, goal, 0);
        }

        // 만들어진 문자열들의 모임을 사전순으로 정렬
        Collections.sort(list);

        for (String str: list){
            System.out.println(str);
        }
    }

    // 자음 조합
    public static void combCon(int idx, int goal, int curCnt){
        if(goal == curCnt){
            combVow(0, L-goal, 0);
            return;
        }

        if(idx == conso.size()){
            return;
        }

        // 해당 자음 넣음
        result.add(conso.get(idx));
        combCon(idx+1, goal, curCnt+1);
        
        // 해당 자음 안 넣음
        result.remove(result.size()-1);
        combCon(idx+1, goal, curCnt);
    }

    // 모음 조합
    public static void combVow(int idx, int goal, int curCnt){
        if(goal == curCnt){
            Object[] cp = result.toArray();
            // 한 String에 대해서 알파벳 순으로 정렬  
            Arrays.sort(cp);
            // [a, b, c] -> abc로 바꿈
            String str = Arrays.toString(cp).replaceAll("[\\[ \\] \\,]", "");
            list.add(str);
            return;
        }

        if(idx == vowel.size()){
            return;
        }

        // 해당 모음 넣음
        result.add(vowel.get(idx));
        combVow(idx+1, goal, curCnt+1);

        // 해당 모음 안 넣음
        result.remove(result.size()-1);
        combVow(idx+1, goal, curCnt);
    }
}
