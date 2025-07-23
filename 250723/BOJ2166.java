import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] arr = new long [N+1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Long.parseLong(st.nextToken());
            arr[i][1]=Long.parseLong(st.nextToken());
        }
        arr[N]=arr[0];
        long sum1=0;
        long sum2=0;
        for (int i = 0; i < N; i++) {
            sum1+=arr[i][0]*arr[i+1][1];
            sum2+=arr[i][1]*arr[i+1][0];
        }
        double an=Math.abs(sum1-sum2)/2.0;
        System.out.printf("%.1f\n",an);
    }
}
