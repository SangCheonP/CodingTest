package Imple;

import java.util.*;
import java.io.*;

public class Baek_3190_뱀 {
    static int[] di = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // 1: 사과, 2: 뱀
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        List<Integer> time = new ArrayList<>();
        List<Character> dir = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            time.add(Integer.parseInt(st.nextToken()));
            dir.add(st.nextToken().charAt(0));
        }

        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[] {1, 1});
        map[1][1] = 2;

        int t = 0, d = 1;
        while (true) {
            t++;
            int[] cur = deque.peekFirst();

            int ni = cur[0] + di[d];
            int nj = cur[1] + dj[d];

            if (ni == 0 || ni == N + 1 || nj == 0 || nj == N + 1 || map[ni][nj] == 2) break;

            if (map[ni][nj] != 1) {
                int[] del = deque.pollLast();
                map[del[0]][del[1]] = 0;
            }
            map[ni][nj] = 2;
            deque.offerFirst(new int[]{ni, nj});

            if (time.size() > 0 && t == time.get(0)) {
                if (dir.get(0) == 'L') {
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
                time.remove(0);
                dir.remove(0);
            }
        }

        System.out.println(t);
    }
}
