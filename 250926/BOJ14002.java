import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] parent= new int[N];
        Arrays.fill(parent, -1);
        int[] index = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int length = 0;
        for (int i = 0; i < N; i++) {
            int pos= Arrays.binarySearch(dp, 0, length, arr[i]);
            if (pos < 0) {pos = -pos - 1;}
            dp[pos] = arr[i];
            index[pos]=i;
            if (pos> 0) {
                parent[i]=index[pos-1];
            }
            if (pos == length ) {length++;}
        }
        Stack<Integer> stack = new Stack<>();
        int idx = index[length-1];
        while (idx != -1) {
            stack.push(arr[idx]);
            idx = parent[idx];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
