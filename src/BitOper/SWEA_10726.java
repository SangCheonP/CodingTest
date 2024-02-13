package BitOper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tc; i++){
            int N = Integer.parseInt(br.readLine());
            // 나온 숫자 저장 변수
            int visited = 0;
            // 센 양의 수
            int result = 1;

            while (true) {
                int tmp = result * N;
                for (String s : String.valueOf(tmp).split("")) {
                    visited |= (1 << Integer.parseInt(s));
                }
                if (visited == ((1 << 10) - 1)) {
                    System.out.println("#" + i + " " + tmp);
                    break;
                }

                result += 1;
            }
        }
    }
}
