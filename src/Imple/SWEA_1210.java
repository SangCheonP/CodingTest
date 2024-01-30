package Imple;

import java.util.Scanner;

public class SWEA_1210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 10; i++){
            int tc = sc.nextInt();

            int[][] map = new int[100][100];
            int x = 0, y = 99;

            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++){
                    map[j][k] = sc.nextInt();
                }
            }

            // 도착 지점을 찾음
            for(int j = 0; j < 100; j++){
                if(map[99][j] == 2) {
                    x = j;
                }
            }

            while(y != 0){
                // 왼쪽으로 계속 감
                if(0 <= x - 1 && x - 1 <= 99 && map[y][x - 1] == 1){
                    while(0 <= x - 1 && map[y][x - 1] == 1){
                        x--;
                    }
                    // 왼쪽으로 가는 것이 끝나면 위로
                    y--;
                } else if (0 <= x + 1 && x + 1 <= 99 && map[y][x + 1] == 1){
                    while( x + 1 <= 99 && map[y][x + 1] == 1){
                        x++;
                    }
                    // 오른쪽으로 가는 것이 끝나면 위로
                    y--;
                }else{
                    y--;
                }
            }

            System.out.println("#" + tc + " " + x);
        }
    }
}
