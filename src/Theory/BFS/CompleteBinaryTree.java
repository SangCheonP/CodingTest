package Theory.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 너비 변수를 가지고 동일 너비 처리
 */
public class CompleteBinaryTree<T> {

    private Object[] nodes;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int SIZE){
        this.SIZE = SIZE;
        this.nodes = new Object[SIZE + 1];
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(T e){
        if(isFull()){
            System.out.println("포화상태입니다.");
            return;
        }
        nodes[++lastIndex] = e;
    }

    public void bfs(){
        if(isEmpty())
            return;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 방문할 루트 노드 넣기

        // 방문할 대상이 있는 동안 반복
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(nodes[current]); // 노드 처리로직

            // 왼쪽 자식
            if(current*2 <= lastIndex) queue.offer(current*2);
            // 오른쪽 자식
            if(current*2 + 1 <= lastIndex) queue.offer(current*2+1);
        }
    }

    // 큐를 탐색할 노드 번호와 너비를 함께 넣기
    public void bfs2(){
        if(isEmpty())
            return;

        Queue<int[]> queue = new ArrayDeque<>();
        // 루트 노드의 데이터와 너비를 저장
        queue.offer(new int[] {1, 0});

        int[] info;
        while(!queue.isEmpty()) {
            info = queue.poll();
            // 데이터
            int current = info[0];
            // 너비
            int breadth = info[1];
            System.out.println(nodes[current] + "(" + breadth + ")");
            // 왼쪽 자식
            if(current*2 <= lastIndex) queue.offer(new int[] {current*2, breadth+1});
            // 오른쪽 자식
            if(current*2 + 1 <= lastIndex) queue.offer(new int[] {current*2+1, breadth+1});
        }
    }

    // 동일 너비 단위로 처리
    public void bfs3(){
        if(isEmpty())
            return;

        Queue<Integer> queue = new ArrayDeque<>();
        // 루트 노드 넣음
        queue.offer(1);

        int current = 0, size = 0, breadth = 0;

        // 큐가 있는 동안
        while(!queue.isEmpty()){
            size = queue.size();
            System.out.println("breadth" + breadth + " : ");
            // 같은 너비의 것들을
            while(--size >= 0){
                current = queue.poll();
                System.out.print(nodes[current] + "\t");
                if(current*2 <= lastIndex) queue.offer(current*2);
                if(current*2+1 <= lastIndex) queue.offer(current*2+1);
            }
            System.out.println();
            // 너비 증가
            ++breadth;
        }

    }

    public void dfs(){
        if(isEmpty())
            return;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 방문할 루트 노드 넣기

        // 방문할 대상이 있는 동안 반복
        while(!queue.isEmpty()){

        }
    }

    // 전위 순회
    public void dfsByPreorder(){
        if(isEmpty()) return;
        System.out.println("===Preorder===");
        dfsByPreorder(1);
        System.out.println();
    }

    public void dfsByPreorder(int current){
        System.out.print(nodes[current] + " ");

        // 왼쪽 자식
        if(current*2 <= lastIndex) dfsByPreorder(current*2);
        // 오른쪽 자식
        if(current*2+1 <= lastIndex) dfsByPreorder(current*2+1);
    }

    // 중위 순회
    public void dfsByInorder(){
        if(isEmpty()) return;
        System.out.println("===Inorder===");
        dfsByInorder(1);
        System.out.println();
    }

    public void dfsByInorder(int current){
        // 왼쪽 자식
        if(current*2 <= lastIndex) dfsByInorder(current*2);
        System.out.print(nodes[current] + " ");
        // 오른쪽 자식
        if(current*2+1 <= lastIndex) dfsByInorder(current*2+1);
    }

    // 후위 순회
    public void dfsByPostorder(){
        if(isEmpty()) return;
        System.out.println("===Postorder===");
        dfsByPostorder(1);
        System.out.println();
    }

    public void dfsByPostorder(int current){
        // 왼쪽 자식
        if(current*2 <= lastIndex) dfsByPostorder(current*2);
        // 오른쪽 자식
        if(current*2+1 <= lastIndex) dfsByPostorder(current*2+1);
        System.out.print(nodes[current] + " ");
    }
}
