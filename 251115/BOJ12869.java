import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12869 {
    public static void main(String[] args) throws Exception {
        int[][] turn = {
                {9, 3, 1}, {9, 1, 3},
                {3, 9, 1}, {3, 1, 9},
                {1, 9, 3}, {1, 3, 9}
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][][] visited  = new boolean[61][61][61];
        int[] input = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {input[0], input[1],input[2]});
        visited[input[0]][input[1]][input[2]] = true;
        int ans=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[]  now  = queue.poll();
                if(now[0]==0 && now[1]==0 && now[2]==0){
                    System.out.println(ans);
                    return;
                }
                for(int[] num :turn){
                    int n1 = Math.max(now[0] - num[0],0);
                    int n2 = Math.max(now[1] - num[1],0);
                    int n3 = Math.max(now[2] - num[2],0);

                    if(!visited[n1][n2][n3]){
                        queue.add(new int[] {n1, n2, n3});
                        visited[n1][n2][n3] = true;
                    }

                }
            }
            ans++;
        }
    }
}
