package BFS;

/**
 * 불에 타기 전에 탈출할 수 있는 지 + 얼마나 빨리 탈출
 * 지훈, 불 -> 한 칸씩, 수평 or 수직
 * 불은 각 지점에서 네 방향
 * 지훈 -> 미로의 가장자리에 접한 공간에서 탈출
 * 지훈, 불 -> 벽 통과X
 *
 * 1 <= R, C <= 1000
 * 
 * #: 벽
 * .: 지나갈 수 있는 공간
 * J: 지훈
 * F: 불
 * 
 * 탈출X -> IMPOSSIBLE
 * 탈출O -> 가장 빠른 탈출 시간
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS ->
 * 맵에는 #, ., J, V를 사용
 * V는 방문 표시
 * 지훈의 위치는 따로 가지고 있음
 */
public class Baek_4179_불 {
    static int R, C;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static char[][] map;
    static Queue<Node> person, fire;

    static class Node{
        int i, j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        person = new ArrayDeque<>();
        fire = new ArrayDeque<>();


        for(int i = 0; i < R; i++){
            int j = 0;
            for(char c : br.readLine().toCharArray()){
                map[i][j] = c;
                if(c == 'J'){
                    if(i == 0 || j == 0 || i == R - 1 || j == C - 1){
                        System.out.println(1);
                        return;
                    }
                    person.offer(new Node(i, j));
                }
                if(c == 'F')
                    fire.offer(new Node(i, j));
                j++;
            }
        }

        int t = 0;
        int result = -1;


        out: while(!person.isEmpty()){
            t++;

            int fSize = fire.size();
            while(--fSize >= 0){
                Node cur = fire.poll();

                for(int d = 0; d < 4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                    if(map[ni][nj] == '#' || map[ni][nj] == 'F') continue;

                    map[ni][nj] = 'F';
                    fire.offer(new Node(ni, nj));
                }
            }

            int pSize = person.size();
            while(--pSize >= 0){
                Node cur = person.poll();

                for(int d = 0; d < 4; d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d];

                    if(ni < 0 || nj < 0 || ni >= R || nj >= C){
                        result = t + 1;
                        break out;
                    }

                    if(map[ni][nj] == '#' || map[ni][nj] == 'J' || map[ni][nj] == 'F') continue;

                    map[ni][nj] = 'J';
                    person.offer(new Node(ni, nj));
                }
            }
        }

        if(result != -1)
            System.out.println(result);
        else
            System.out.println("IMPOSSIBLE");
    }
}
