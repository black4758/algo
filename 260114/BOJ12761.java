import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int[] arr = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        arr[N] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == M) {
                System.out.println(arr[now]);
                break;
            }
            int[] moves = {now+1,now-1,now+A,now-A,now+B,now-B,now*A,now*B};
            for (int next : moves) {
                if(next>=0 && next<=100000 && !visited[next]) {
                    visited[next] = true;
                    arr[next] = arr[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
