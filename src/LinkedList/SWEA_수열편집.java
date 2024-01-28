package LinkedList;

import java.util.Scanner;

// Node
class ListNode{
    public int data;
    public ListNode next;

    public ListNode(){
        this.next = null;
    }

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }

    public ListNode(ListNode next, int data){
        this.data = data;
        this.next = next;
    }
}

public class SWEA_수열편집 {
    // LinkedList
    private static ListNode head;
    private static int len = 0;

    public SWEA_수열편집(){
        this.head = null;
    }

    // 삽입
    public static void insertNode(int insertNodeIdx, int data){
        ListNode newNode = new ListNode(data);

        // 길이 체크로 하는 것이 중요
        if(len == 0){
            head = newNode;
        }else{
            ListNode tmpNode = head;

            int curIdx = 1;

            while(curIdx < insertNodeIdx){
                tmpNode = tmpNode.next;
                curIdx++;
            }

            newNode.next = tmpNode.next;
            tmpNode.next = newNode;
        }

        len++;
    }

    // 삭제
    public static void deleteNode(int deleteNodeIdx){

        ListNode tmpNode = head;

        int curIdx = 1;

        while(curIdx < deleteNodeIdx){
            tmpNode = tmpNode.next;
            curIdx++;
        }

        if(tmpNode.next.next != null)
            tmpNode.next = tmpNode.next.next;
        else
            tmpNode.next = null;

        len--;
    }

    // 교환
    public static void changeNode(int nodeIdx, int data){
        ListNode tmpNode = head;

        int curIdx = 0;

        while(curIdx < nodeIdx){
            tmpNode = tmpNode.next;
            curIdx++;
        }

        tmpNode.data = data;
    }

    // 탐색
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int tc = sc.nextInt();

         for(int i = 1; i <= tc; i++){
             head = null;
             len = 0;

             int N = sc.nextInt(); // 수열의 길이
             int M = sc.nextInt(); // 추가 횟수
             int L = sc.nextInt(); // 출력할 인덱스 번호

             len += N;

             // 수열 입력 받아 Linked List 생성
             for(int j = 0; j < N; j++){
                 if(head != null){
                     ListNode newNode = new ListNode(sc.nextInt());
                     ListNode tmpNode = head;

                     while(tmpNode.next != null){
                         tmpNode = tmpNode.next;
                     }

                     tmpNode.next = newNode;

                 }else{
                     head = new ListNode(sc.nextInt());
                 }
             }

             // 명령어 입력받음
             for(int j = 0; j < M; j++){
                 String command = sc.next();

                 if(command.equals("I")){
                     insertNode(sc.nextInt(), sc.nextInt());

                 }else if(command.equals("D")){
                     deleteNode(sc.nextInt());

                 }else{
                     changeNode(sc.nextInt(), sc.nextInt());

                 }
             }

             ListNode printNode = head;
             int curIdx = 0;

             System.out.print("#" + i);
             if(len - 1 < L){
                 System.out.println(" " + -1);
                 continue;
             }
             while(true){
                 if(curIdx != L && printNode.next != null){
                     printNode = printNode.next;
                     curIdx++;
                 }else if(curIdx == L){
                     System.out.println(" " + printNode.data);
                     break;
                 }else{
                     System.out.println(" " + -1);
                     break;
                 }
             }
         }
    }
}
