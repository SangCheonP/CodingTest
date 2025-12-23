package Map;

import java.util.*;

class Programmers_전화번호목록 {
    public boolean solution(String[] phone_book) {
        // 1. Map 생성 및 모든 전화번호 저장
        Map<String, Integer> map = new HashMap<>();
        for(String phone : phone_book){
            map.put(phone, null);
        }
        
        // 2. 각 수를 돌아가며 접두사가 있는지 체크
        for(String phone : phone_book){
            for(int i = 1; i < phone.length(); i++){
                if(map.containsKey(phone.substring(0, i))){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}
