package BackTracking;
/**
*  1. 완전 탐색 재귀로 모든 경우의 수 체크
*  2. 리스트에 저장하고, 해당 단어의 위치를 반환
**/

import java.util.*;

class Programmers_모음사전 {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        generateWords("", 0);
        return list.indexOf(word);
    }
    
    void generateWords(String cur, int dep){
        if(dep > 5) return; // 최대 5글자
        list.add(cur);
        
        for(String vowel : vowels){
            generateWords(cur + vowel, dep + 1);
        }
    }
}
