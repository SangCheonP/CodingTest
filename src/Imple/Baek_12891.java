package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 12891 DNA 비밀번호 (실버2)
https://www.acmicpc.net/problem/12891
 */
public class Baek_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S: 문자열의 길이, P: 부분 문자열의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 문자열
        String[] str = br.readLine().split("");

        // 각각의 DNA의 최소 개수
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 체크한 DNA를 저장할 배열
        int[] have = new int[4];

        // 결과, 부분 문자열 시작과 끝
        int result = 0, sr = 0, ed = 0;

        for(int i = 0; i < P; i++){
            ed = i;
            if(str[i].equals("A"))
                have[0] += 1;
            else if (str[i].equals("C")) {
                have[1] += 1;
            } else if (str[i].equals("G")) {
                have[2] += 1;
            }else{
                have[3] += 1;
            }
        }

        if(A <= have[0] && C <= have[1] && G <= have[2] && T <= have[3])
            result += 1;

        while(ed < S){
            if(++ed == S)
                break;
            // 끝 지점 뒤로 한 칸
            if(str[ed].equals("A"))
                have[0] += 1;
            else if (str[ed].equals("C")) {
                have[1] += 1;
            } else if (str[ed].equals("G")) {
                have[2] += 1;
            }else{
                have[3] += 1;
            }

            // 시작 지점 한 칸 뒤로
            if(str[sr].equals("A"))
                have[0] -= 1;
            else if (str[sr].equals("C")) {
                have[1] -= 1;
            } else if (str[sr].equals("G")) {
                have[2] -= 1;
            }else{
                have[3] -= 1;
            }
            ++sr;

            // 현재 부분 문자열이 만들 수 있는 부분 문자열인지 검사
            if(A <= have[0] && C <= have[1] && G <= have[2] && T <= have[3])
                result += 1;
        }

        System.out.println(result);
    }
}
