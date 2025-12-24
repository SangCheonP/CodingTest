package 코테_기본;

import java.util.*;

public class Programmers_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            if(n % divisor == 0) list.add(n);
        }

        Collections.sort(list);

        if(list.size() < 1) {
            return new int[] {-1};
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
