package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    public Node(Node next, int data){
        this.next = next;
        this.data = data;
    }
}

public class SWEA_암호문3 {
    static Node head = null;
    static int len = 0;

    // 삽입
    // x: 앞에서부터 x번째 암호문 바로뒤
    // y: y개의 암호문 삽입
    // s: 덧붙일 암호문
    public static void insertNode(int x, int y, String[] s){
        Node curNode = head;

        for(int i = 0; i < x - 1; i++){
            curNode = curNode.next;
        }

        // 나중에 삽입후 연결해야 할 Node
        Node destNode = curNode.next;

        for(int i = 0; i < y; i++){
            Node newNode = new Node(Integer.parseInt(s[i]));

            curNode.next = newNode;
            curNode = curNode.next;

        }

        curNode.next = destNode;
    }
    
    // 삭제
    // x: 앞에서부 x번째 암호문 바로 다음부터
    // y: y개의 암호문 삭제
    public static void deleteNode(int x, int y){
        Node startNode = null;
        Node deleteNode = head;

        System.out.println("deleteNode");

        for(int i = 0; i < x + y - 1; i++){
            if(deleteNode.next != null)
                deleteNode = deleteNode.next;

            if(i == x){
                startNode = deleteNode;
            }
        }

        startNode.next = deleteNode.next;
        deleteNode.next = null;
    }
    // 추가


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;

        while ((st = new StringTokenizer(br.readLine())) != null) {

            int textCount = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            head = null;
            len = textCount;

            Node curNode = head;

            // 원본 암호문 뭉치를 받아 Linked List로 연결
            for(int i = 0; i < textCount; i++){
                Node newNode = new Node(Integer.parseInt(st.nextToken()));

                if(head == null){
                    head = newNode;
                    curNode = newNode;
                }else{
                    curNode.next = newNode;
                    curNode = newNode;
                }
            }

            // 명령어 갯수
            int commandCount = Integer.parseInt(br.readLine());
            int curCommandCount = 0;
            st = new StringTokenizer(br.readLine());


            while(curCommandCount < commandCount){
                String command = st.nextToken();
                System.out.println("command: " + command);
                if(command.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    String[] s = new String[y];

                    for(int i = 0; i < y; i++){
                        s[i] = st.nextToken();
                    }

                    System.out.println(" x:" + x);
                    System.out.println(" y:" + y);
                    System.out.println(" s:" + Arrays.toString(s));

                    insertNode(x, y, s);

                    curCommandCount++;
                    len += y;
                } else if (command.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    System.out.println(" x:" + x);
                    System.out.println(" y:" + y);

                    deleteNode(x, y);

                    commandCount++;
                    len -= y;
                } else {

                }
            }



            System.out.print("#" + tc);

            Node newNode = head;
            while(true){
                System.out.print(" " + newNode.data);
                if(newNode.next != null)
                    newNode = newNode.next;
                else
                    break;
            }
            System.out.println(" len: " + len);
        }
    }
}
