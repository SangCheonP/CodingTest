package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
백준 2615 오목(실버1)
https://www.acmicpc.net/problem/2615
 */
public class Baek_2615_오목_2 {
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                // 오목 체크
                if(map[i][j] != 0 && check5(i, j)){
                    System.out.println(i + " " + j);
                    // 육목 체크
//                    if(!check6(i, j)){
//                        System.out.println(map[i][j]);
//                        System.out.println(i + " " + j);
//                    }
                }
            }
        }
    }

    public static boolean check5(int i, int j){
        int cnt = 0;
        int ni = i, nj = j;

        // 아래
        while(true){
            // 5개 연속으로 같은 돌이면
            if(cnt == 4){
                // 육목이 아니라면
                // 위 변에서 시작
                if(i == 0 && map[ni][nj] != map[ni+1][nj]){
                    return true;
                }
                // 아래변에 도착
                else if (ni == 18 && map[i][j] != map[i-1][j]) {
                    return true;
                }
                // 이외
                else if (map[i][j] != map[i-1][j] && map[ni][nj] != map[ni+1][nj]){
                    return true;
                }
                break;
            }
            ++ni;
            // 다음 것이랑 같으면
            if(0 <= ni && ni < 19 && 0 <= nj && nj < 19 && map[i][j] == map[ni][nj]){
                cnt++;
            }else{
                break;
            }
        }

        cnt = 0;
        ni = i;
        nj = j;

        // 우하
        while (true){
            // 5개 연속으로 같은 돌이면
            if(cnt == 4){
                // 육목이 아니라면
                // 위 변에서 시작
                if(i == 0 && map[ni][nj] != map[ni+1][nj]){
                    return true;
                }
                // 아래변에 도착
                else if (ni == 18 && map[i][j] != map[i-1][j]) {
                    return true;
                }
                // 이외
                else if (map[i][j] != map[i-1][j] && map[ni][nj] != map[ni+1][nj]){
                    return true;
                }
                break;
            }
            ++ni;
            ++nj;
            // 다음 것이랑 같으면
            if(0 <= ni && ni < 19 && 0 <= nj && nj < 19 && map[i][j] == map[ni][nj]){
                cnt++;
            }else{
                break;
            }
        }

        cnt = 0;
        ni = i;
        nj = j;

        // 우
        while (true){
            // 5개 연속으로 같은 돌이면
            if(cnt == 4){
                return true;
            }
            ++nj;
            // 다음 것이랑 같으면
            if(0 <= ni && ni < 19 && 0 <= nj && nj < 19 && map[i][j] == map[ni][nj]){
                cnt++;
            }else{
                break;
            }
        }

        cnt = 0;
        ni = i;
        nj = j;

        // 우상
        while (true){
            // 5개 연속으로 같은 돌이면
            if(cnt == 4){
                return true;
            }
            --ni;
            ++nj;
            // 다음 것이랑 같으면
            if(0 <= ni && ni < 19 && 0 <= nj && nj < 19 && map[i][j] == map[ni][nj]){
                cnt++;
            }else{
                break;
            }
        }

        return false;
    }

    public static boolean check5(int i, int j, int ni, int nj){
        
        
        return false;
    }
    
    
    private static void print(int[][] map) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
