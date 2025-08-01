import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] input = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            input[i]=input[i-1]+Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MIN_VALUE;
        int cnt = 0, end = 0;
        for(int i=X; i<=N; i++) {
            int sum=input[i]-input[end];
            end++;
            if(sum>ans) {
                ans=sum;
                cnt=1;
            }
            else if(sum==ans) {
                cnt++;
            }
        }
        if(ans==0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(ans);
        System.out.println(cnt);
    }
}

