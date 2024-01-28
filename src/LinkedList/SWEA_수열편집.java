package LinkedList;

import Imple.SWEA_11315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Node
class ListNode{
    private int data;
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
    private ListNode head;
    private ListNode tail;

    public SWEA_수열편집(){
        this.head = null;
        this.tail = null;
    }

    // 중간에 삽입
    public void insertNode(ListNode preNode, int data){
        ListNode newNode = new ListNode(preNode.next, data);

        preNode.next = newNode;
    }

    // 마지막에 삽입
    public void insertNode(int data){
        ListNode newNode = new ListNode(data);

        // 데이터가 없으면
        if(this.head == null){
            this.head = newNode;
        }else{ // 데이터가 있으면

            ListNode tmpNode = head;

            // 마지막 노드 까지 검색
            while(tmpNode.next != null){
                tmpNode = tmpNode.next;
            }

            // 마지막 노드에 추가
            tmpNode.next = newNode;
        }
        // tail 업데이트
        this.tail = newNode;
    }

    // 중간 노드 삭제


    // 마지막 노드 삭제


    // 노드 탐색
}
