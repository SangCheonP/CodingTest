package Theory.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 입력: 10 1 4 3 5 1 6 5 7 3 8 5 9 6 10 8 11 2 13 12 14

public class MeetingRoomTest {
    static class Meeting implements Comparable<Meeting>{
        int start, end;

        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }


        // 종료 시간이 다르면 먼저 끝나는 것
        // 종료 시간이 같으면 시작 시간이 빠른 것 선택
        @Override
        public int compareTo(Meeting o) {
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        // 종료 시간이 빠른 순서대로 정렬
        Arrays.sort(meetings);

        List<Meeting> list = new ArrayList<>();

        // 가장 처음 시작하는 회의 추가
        list.add(meetings[0]);
        
        // list 마지막 회의의 끝나는 시간보다 늦거나 같은 회의 선택
        for (int i = 1; i < N; i++) {
            if(list.get(list.size()-1).end <= meetings[i].start){
                list.add(meetings[i]);
            }
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
