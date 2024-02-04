package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
SWEA 1218 괄호 짝짓기 (D4)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD
 */
public class SWEA_1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1;  tc <= 1; tc++){
            int len = Integer.parseInt(br.readLine());
            int result = 1;

            String[] stack = new String[len];

            int top = -1;

            for(String s : br.readLine().split("")){
                // 열린 기호면
                if(s.equals("(") || s.equals("[") || s.equals("{") || s.equals("<")){
                    // stack에 추가
                    stack[++top] = s;
                    // 닫힌 기호면
                }else{
                    // 가진 게 있으면
                    if(top > -1) {
                        String pop = stack[top--];

                        if(pop.equals("(") && s.equals(")")){
                            continue;
                        } else if (pop.equals("[") && s.equals("]")) {
                            continue;
                        }
                        else if (pop.equals("<") && s.equals(">")) {
                            continue;
                        }
                        else if (pop.equals("{") && s.equals("}")) {
                            continue;

                            // top과 s가 같지 않으면
                        }else{
                            result = 0;
                            break;
                        }
                    }else{
                        result = 0;
                        break;
                    }

                }
            }



            System.out.println("#" + tc + " " + result);
        }
    }
}
