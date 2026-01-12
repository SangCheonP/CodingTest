package Greedy;

import java.util.*;
import java.io.*;

/**
 * 시간 : 최대 2중 for문, 50 * 50 = 2500 충분
 * 공간 : 배열 최대 50짜리 하나 사용해서 충분
 * 예외 : 첫 숫자 문단만 잘 설계해주면 뒤부터는 반복적인 패턴
 */

public class Baek_1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split("-");

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if(nums[i].contains("+")) {
                    for (String num : nums[i].split("\\+")) {
                        result += Integer.parseInt(num);
                    }
                } else {
                    result = Integer.parseInt(nums[i]);
                }
            } else {
                if(nums[i].contains("+")) {
                    int temp = 0;
                    for (String num : nums[i].split("\\+")) {
                        temp += Integer.parseInt(num);
                    }
                    result -= temp;
                } else {
                    result -= Integer.parseInt(nums[i]);
                }
            }
        }

        System.out.println(result);
    }
}
