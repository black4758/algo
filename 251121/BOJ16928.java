import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] move = new int[101];

        for (int i = 1; i <= 100; i++) move[i] = i;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[101];

        q.add(new int[] {1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == 100) {
                System.out.println(now[1]);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = now[0] + dice;
                if (next > 100) continue;

                next = move[next];

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, now[1]+1});
                }
            }
        }
    }
}
