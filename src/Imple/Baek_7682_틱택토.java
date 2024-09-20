package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_7682_틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String str = br.readLine();

            // end가 들어오면 종료
            if(str.equals("end"))
                break;

            char[] chars = str.toCharArray();
            int x_cnt = 0;
            int o_cnt = 0;

            // x와 o의 입력 개수 세기
            for (int i = 0; i < 9; i++) {
                if(chars[i] == 'X')
                    x_cnt++;
                else if(chars[i] == 'O')
                    o_cnt++;
            }

            // 턴순서 검증
            // x의 개수가 o보다 한 개 많아야함
            if(o_cnt > x_cnt || x_cnt - o_cnt > 1){
                System.out.println("invalid");
                continue;
            }

            // 승리 조건 확인
            boolean x_win = isWinner(chars, 'X');
            boolean o_win = isWinner(chars, 'O');

            // 두 플레이어가 모두 승리한 경우 무효
            if(x_win && o_win){
                System.out.println("invalid");
                continue;
            }

            // X가 승리한 경우, X의 개수는 O의 개수보다 정확히 하나 더 많아야 함
            if(x_win){
                if(x_cnt == o_cnt +1){
                    System.out.println("valid");
                    continue;
                }else{
                    System.out.println("invalid");
                    continue;
                }
            }

            // O가 승리한 경우, X와 O의 개수가 동일해야 함
            if(o_win){
                if(x_cnt == o_cnt){
                    System.out.println("valid");
                    continue;
                }else{
                    System.out.println("invalid");
                    continue;
                }
            }

            // 승자가 없을 경우, 보드가 가득 찬 상태여야 유효
            if(x_cnt + o_cnt == 9){
                System.out.println("valid");
            }else{
                System.out.println("invalid");
            }
        }
    }

    // 특정 플레이가 승리했는지 확인하는 메서드
    static boolean isWinner(char[] board, char player){
        // 모든 가능한 승리 조합 정의
        int[][] winPositions = {
                {0,1,2}, // 1번째 가로줄
                {3,4,5}, // 2번째 가로줄
                {6,7,8}, // 3번째 가로줄
                {0,3,6}, // 1번째 세로줄
                {1,4,7}, // 2번째 세로줄
                {2,5,8}, // 3번째 세로줄
                {0,4,8}, // 대각선 (좌상 -> 우하)
                {2,4,6}  // 대각선 (우상 -> 좌하)
        };

        for (int[] pos : winPositions){
            if(board[pos[0]] == player &&
                    board[pos[1]] == player &&
                    board[pos[2]] == player)
                return true;
        }
        return false;
    }
}
