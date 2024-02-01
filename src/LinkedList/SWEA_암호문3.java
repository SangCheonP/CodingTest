package LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class SWEA_암호문3 {
    static int NODE_MAX = 5000;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList{
        Node head;
        Node tail;
        Node[] nodeArr;
        int nodeCnt;

        public LinkedList(){
            head = null;
            nodeArr = new Node[NODE_MAX];
            nodeCnt = 0;
        }

        Node getNewNode(int data){ // data를 값으로 갖는 새로운 node 생성하고, 생성된 node를 return
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }

        void insert(int idx, int[] nums){ // 앞에서 idx 개 이후에 nums 들을 추가하기
            int st = 0;
            if(idx == 0){ // 맨 앞에 붙여야 하는 경우
                // 먼저, 한개만 추가 후 head 재조정
                if(head != null){
                    Node newNode = getNewNode(nums[0]);
                    newNode.next = head;
                    head = newNode;
                }else{
                    head = getNewNode(nums[0]);
                }

                // 나음 수들을 head 뒤에 차례로 이어 붙이기
                idx = 1;
                st = 1;
            }

            Node cur = head;
            // idx개 만큼 이동
            for(int i = 1; i<idx; i++){
                cur = cur.next;
            }

            //nums 추가
            for(int i = st; i < nums.length; i++){
                Node newNode = getNewNode(nums[i]);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode;
            }

            if(cur.next == null){
                tail = cur;
            }
        }

        void delete(int idx, int cnt){ // idx번 인덱스부터 cnt개 만큼 삭제
            Node cur = head;

            if(idx == 0){ // 맨 앞이 삭제되는 경우 (head 재조정 필요)
                for(int i=0; i<cnt; i++){
                    cur = cur.next;
                }
                head = cur;
                return;
            }

            for(int i = 1; i < idx; i++){
                cur = cur.next;
            }

            Node anchor = cur; // 삭제되기 직전 위치 기억하기;

            for(int i = 0; i < cnt; i++){
                cur = cur.next;
            }

            anchor.next = cur.next;

            if(anchor.next == null){
                tail = anchor;
            }
        }

        void add(int data){ // 제일 뒤에 data 추가하기
            Node cur = tail;
            Node newNode = getNewNode(data);
            cur.next = newNode;
            tail = newNode;
        }

        void print() throws Exception{
            int cnt = 10;
            Node cur = head;
            while(--cnt >= 0){
                bw.write(cur.data + " ");
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 10;

        StringTokenizer stk;
        for (int t = 1; t <= T; t++) {
            LinkedList list = new LinkedList();
            bw.write("#");
            bw.write(t + " ");
            int N = Integer.parseInt(br.readLine());
            int[] initArr = new int[N];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                initArr[i] = Integer.parseInt(stk.nextToken());
            }
            list.insert(0, initArr);

            int M = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                char cmd = stk.nextToken().charAt(0);
                int x, y;
                switch (cmd) {
                    case 'I':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        int[] temp = new int[y];
                        for (int j = 0; j < y; j++) {
                            temp[j] = Integer.parseInt(stk.nextToken());
                        }
                        list.insert(x, temp);
                        break;
                    case 'D':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        list.delete(x, y);
                        break;
                    case 'A':
                        y = Integer.parseInt(stk.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.add(Integer.parseInt(stk.nextToken()));
                        }
                        break;
                }
            }
            list.print();
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
