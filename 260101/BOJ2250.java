import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2250 {
    static class Node{
        int left, right;
        Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    static int col = 1;
    static int[] minCol, maxCol;
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new Node[N+1];
        boolean[] visited = new boolean[N+1];
        minCol = new int[N + 1];
        maxCol = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            minCol[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            node[a] = new Node(b,c);
            if(b != -1) visited[b] = true;
            if(c != -1) visited[c] = true;
        }
        int root =0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                root = i;
                break;
            }
        }
        inorder(root, 1);
        int ansLevel = 1;
        int ansWidth = 1;
        for (int i = 1; i <= N; i++) {
            if(minCol[i] != Integer.MAX_VALUE) {
                int nowWidth = maxCol[i]-minCol[i]+1;
                if(nowWidth > ansWidth) {
                    ansWidth = nowWidth;
                    ansLevel = i;
                }
            }
        }
        System.out.println(ansLevel+" "+ansWidth);
    }
    static void inorder(int cur, int level) {
        if (cur == -1) return;

        inorder(node[cur].left, level + 1);

        minCol[level] = Math.min(minCol[level], col);
        maxCol[level] = Math.max(maxCol[level], col);
        col++;

        inorder(node[cur].right, level + 1);
    }

}
