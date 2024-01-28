package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315 {
    public static boolean check(String[][] map){
        
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tc; i++)
        {
            int N = Integer.parseInt(br.readLine());
            String[][] map = new String[N][];

            for(int j = 0; j < N; j++){
                map[j] = br.readLine().split("");
            }

            if(check(map))
                // 5개 연속 있으면 
                System.out.println("#" + i + " YES");
            else
                // 5개 연속 없으면
                System.out.println("#" + i + " NO");


            for(String[] strs : map) {
                for (String str : strs)
                    System.out.print(str + " ");
                System.out.println();
            }
        }
    }
}
