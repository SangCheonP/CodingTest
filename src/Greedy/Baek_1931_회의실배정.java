package Greedy;

import java.util.*;
import java.io.*;

/**
 * 아이디어 : 회의가 끝나는 시간으로 정렬, 끝나는 시간이 같으면 시작하는 시간이 빠른 순으로 정렬 그럼, 회의 끝나는 시간이 같으면 먼저 나오는 것은 먼저 회의 시작하는 것이 나옴
 * 시간 : 정렬 + 리스트 한 번 돌기 -> 충분
 * 공간 : 리스트 하나 사용 -> 충분
 * 예외 : (2, 2), (1, 2) -> (1, 2), (2, 2) 순으로 되야함
 */

public class Baek_1931_회의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Room> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Room(s, e));
        }

        Collections.sort(list);

        int result = 0;
        Room cur = new Room(0, 0);

        for (Room r : list) {
            if (r.s >= cur.e) {
                cur = r;
                result++;
            }
        }

        System.out.println(result);
    }
}

class Room implements Comparable<Room> {
    int s, e;

    public Room(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Room o) {
        if(this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }
}

