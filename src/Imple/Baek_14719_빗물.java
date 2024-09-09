package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] hights = new int[W];
        for (int i = 0; i < W; i++) {
            hights[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        // 높이 1부터 체크
        for (int h = 1; h <= H; h++) {
            
            // 시작 벽이 막혀있는지
            boolean left = false;
            int tmp = 0;
            for (int w = 0; w < W; w++) {
                if(hights[w] >= h){ // 해당 위치에 쌓이 높이가 지금 기준 높이보다 높거나 같으면
                    // 시작벽이 없으면
                    if(!left){
                        left = true;
                    }else{ // 시작벽이 있으면 고인물 추가
                        result += tmp;
                        tmp = 0;
                    }
                }else{ // 기준 높이보다 낮으면
                    if(left){  // 시작벽이 있으면
                        tmp += 1;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
