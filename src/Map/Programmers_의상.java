package Map;
/**
* 1. Map을 선언해서 같은 의상 종류끼리 묶어 개수를 셈
* 2. 각 종류에 입지 않는 선택지 +1 하여 모든 선택지를 곱하여 조합 수를 계산
* 3. 아무것도 입지 않는 것은 없으니 -1 함
**/

import java.util.*;

class Programmers_의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        
        int answer = 1;
        
        for(int n : map.values()){
            answer *= n + 1;
        }
        
        return answer - 1;
    }
}
