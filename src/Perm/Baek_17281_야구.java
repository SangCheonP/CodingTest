package Perm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 17281 야구(골드4)
https://www.acmicpc.net/problem/17281
 */
public class Baek_17281_야구 {
    static int score, inning;
    static int[] turn;
    static boolean[] selected;
    static int[][] inningResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        inning = Integer.parseInt(br.readLine());
        inningResult = new int[10][inning+1];

        for (int in = 1; in <= inning; in++) {
            st = new StringTokenizer(br.readLine());
            for (int pn = 1; pn <= 9; pn++) {
                inningResult[pn][in] = Integer.parseInt(st.nextToken());
            }
        }

        // 해당 선수 선택했는지
        selected = new boolean[10];
        // 타순 저장 배열
        turn = new int[10];

        perm(1);

        System.out.println(score);
    }

    static void perm(int idx){
        // 타순이 만들어지면
        if(idx == turn.length){
            // 4번째 타자가 1번 선수가 아니면
            if(turn[4] != 1) return;

            // tmpScore: 현재 타순으로 만들어내는 점수
            int tmpScore = 0;
            int outCnt = 0;
            int turnIdx = 1;
            int curInning = 1;
            
            // 1 ~ 3 베이스 사용
            boolean[] base = new boolean[4];

            while (true){
                // 주어진 이닝이 끝나면
                if(curInning > inning) {
                    score = Math.max(score, tmpScore);
                    break;
                }
                
                // 이닝이 끝나지 않고 다 쳤으면 처음 타자부터
                turnIdx = turnIdx % 10;
                if(turnIdx == 0)
                    turnIdx = 1;
                
                // 현재 순서의 타자의 결과
                int state = inningResult[turn[turnIdx]][curInning];

                switch (state){
                    // 아웃
                    case 0:
                        outCnt += 1;
                        turnIdx += 1;
                        break;
                    // 안타
                    case 1:
                        if(base[3])
                            tmpScore += 1;
                        base[3] = base[2];
                        base[2] = base[1];
                        base[1] = true;
                        turnIdx += 1;
                        break;
                    // 2루타
                    case 2:
                        if(base[3])
                            tmpScore += 1;
                        if(base[2])
                            tmpScore += 1;
                        base[3] = base[1];
                        base[2] = true;
                        base[1] = false;
                        turnIdx += 1;
                        break;
                    // 3루타
                    case 3:
                        if(base[3])
                            tmpScore += 1;
                        if(base[2])
                            tmpScore += 1;
                        if(base[1])
                            tmpScore += 1;
                        base[3] = true;
                        base[2] = false;
                        base[1] = false;
                        turnIdx += 1;
                        break;
                    // 홈런
                    case 4:
                        for (int i = 1; i <= 3; i++) {
                            if(base[i]) {
                                tmpScore += 1;
                                base[i] = false;
                            }
                        }
                        tmpScore += 1;
                        turnIdx += 1;
                        break;
                }

                // 삼진아웃이면
                if(outCnt == 3){
                    curInning += 1;
                    outCnt = 0;
                    base = new boolean[4];
                }
            }
            return;
        }

        // 순열 생성
        for (int i = 1; i <= 9; i++) {
            if(selected[i])
                continue;
            selected[i] = true;
            turn[idx] = i;
            perm(idx + 1);
            selected[i] = false;
        }
    }
}
