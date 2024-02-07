package Theory.BFS;

// 트리, 이진 트리, bfs, dfs
public class CompleteBinaryTreeTest {
    public static void main(String[] args) {
        CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(10);
        for(int i = 0; i < 10; i++){
            tree.add((char)(65 + i));
        }
//        tree.bfs();
//        tree.bfs2();
//        tree.bfs3();
//        tree.dfsByPreorder();
//        tree.dfsByInorder();
//        tree.dfsByPostorder();
    }
}
