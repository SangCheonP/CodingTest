package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. idx와 그 값으로 이동할 위치를 저장(하나의 배열 사용)
 * 2. A지점을 통과하고, 이후에 재방문했을 때 이후의 진행 결과는 이미 확인 했으니까 진행할 필요 없음(재방문X)
 */

/**
 * 주사위 1~6
 * 보드판 1~100
 * i , 4 -> i + 4
 * 100이 넘으면 이동X
 * 사다리 -> 따라 올라감(원래 칸 번호보다 큼)
 * 뱀 -> 따라 내려감(원래 칸 번호보다 작음)
 * 1 -> 100 도착이 목표
 * 주사위의 최솟값
 *
 * 1 <= 사다리의 수 N <= 15
 * 1 <= 뱀의 수 M <= 15
 *
 * 1, 100번 칸은 뱀과 사다리의 시작 or 끝X
 * 모든 칸은 최대 1개 뱀 or 사다리
 * 동시에 가지는 것은 X
 */
public class Baek_16928_뱀과사다리게임 {
    static class Node{
        int idx, cnt;

        Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N: 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // M: 뱀의 수

        // 사다리와 뱀을 하나의 배열로 관리
        int[] board = new int[101];
        Arrays.fill(board, -1);

        // 사다리와 뱀 Map 넣기
        for(int i = 0; i < N + M; i++){
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken()); // 시작
            int des = Integer.parseInt(st.nextToken()); // 도착

            board[str] = des;
        }

        // 위치를 저장할 큐
        Queue<Node> queue = new ArrayDeque<>();

        // 방문 여부를 저장할 배열
        boolean[] visited = new boolean[101];

        queue.offer(new Node(1, 0));
        visited[1] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for(int dice = 1; dice <= 6; dice++){
                int nextIdx = cur.idx + dice;
                int nextCnt = cur.cnt + 1;

                if(nextIdx > 100) continue;
                
                // 목적지 도달
                if(nextIdx == 100){
                    System.out.println(nextCnt);
                    return;
                }

                // 사다리나 뱀이 있는 경우
                if(board[nextIdx] != -1){
                    nextIdx = board[nextIdx];
                }

                // 아직 방문하지 않은 경우(한번 방문하면 다음에 방문해도 이후는 같으니까)
                if(!visited[nextIdx]){
                    visited[nextIdx] = true;
                    queue.offer(new Node(nextIdx, nextCnt));
                }
            }
        }
    }
}
