import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        Long[] arr =new Long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        Long T  = Long.parseLong(st.nextToken());
        Long P = Long.parseLong(st.nextToken());

        Long sum = 0L;
        for(int i=0;i<6;i++){
            sum+=(arr[i]+T-1)/T;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        sb.append(N/P).append(" ").append(N%P);
        System.out.println(sb);
    }
}
