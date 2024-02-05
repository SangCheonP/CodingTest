package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
SWEA 1228 암호문1 (D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&problemLevel=3&contestProbId=AV14w-rKAHACFAYD&categoryId=AV14w-rKAHACFAYD&categoryType=CODE&problemTitle=1228&orderBy=RECOMMEND_COUNT&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1
 */
public class SWEA_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 0;

        for(int t = 1; t <= 10; t++){
            tc += 1;
            List<Integer> arr = new LinkedList<>();
            // 원본 암호문 길이
            int N = Integer.parseInt(br.readLine());

            // 원본 암호문
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            // 명령어 개수
            int commandCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < commandCnt; i++){
                String command = st.nextToken();
                if(command.equals("I")){
                    // 앞에서부터 x위치 바로 다음
                    int x = Integer.parseInt(st.nextToken());
                    // y개의 숫자
                    int y = Integer.parseInt(st.nextToken());
                    // s는 덧붙일 숫자
                    for(int j = 0; j < y; j++){
                        arr.add(x + j, Integer.parseInt(st.nextToken()));
                    }
                }
            }

            System.out.print("#" + tc);
            for(int i = 0; i < arr.size(); i++){
                if(i == 10)
                    break;
                System.out.print(" " + arr.get(i));
            }
            System.out.println();
        }
    }
}
