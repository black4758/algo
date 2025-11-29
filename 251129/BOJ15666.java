import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15666 {
    static int M;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = new int[set.size()];
        int i=0;
        for(int now : set){
            arr[i++]=now;
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    public static void dfs(int st,int cnt){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=st;i<arr.length;i++){
            ans[cnt]=arr[i];
            dfs(i,cnt+1);
        }
    }
}
