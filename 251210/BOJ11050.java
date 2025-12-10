import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050 {
    static int N,K,ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dfs(1,0);
        System.out.print(ans);
    }
    public static void dfs(int cnt, int now){
        if(now ==K){
            ans++;
            return;
        }
        if(cnt>N){
            return;
        }
        dfs(cnt+1,now);

        dfs(cnt+1,now+1);
    }
}
