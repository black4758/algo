import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{A, 1});
        while (!q.isEmpty()) {
            long[] now = q.poll();
            if(now[0]==B){
                System.out.println(now[1]);
                return;
            }
            long sum1 = now[0]*2;
            long sum2 = now[0]*10+1;
            if(sum1<=B){
                q.add(new long[]{sum1, now[1]+1});
            }
            if(sum2<=B){
                q.add(new long[]{sum2, now[1]+1});
            }
        }
        System.out.println(-1);
    }
}
