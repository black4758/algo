import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int num =1;
        int ans = 0;
        int sum1 = a;
        int sum2 = b;
        while (num<=Math.min(a,b)) {
            if(a%num == 0 && b%num == 0 ) {
                ans=num;
            }
            num++;
        }
        while (sum1!=sum2){
            if(sum1>sum2){
                sum2+=b;
            }
            else {
                sum1+=a;
            }
        }
        System.out.println(ans);
        System.out.println(sum1);
    }
}
