import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int L,C;
    static char[] input;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        sb = new StringBuilder();
        Arrays.sort(input);
        dfs(0,0,0,0,"");
        System.out.println(sb);

    }
    static void dfs(int cnt,int idx ,int mCnt, int jCnt, String ans) {
        if (cnt == L) {
            if(jCnt >=2 && mCnt >=1) {
                sb.append(ans).append("\n");
            }
            return;
        }
        if(idx >= C) {
            return;
        }
        if(check(input[idx])) {
            dfs(cnt+1,idx+1,mCnt+1,jCnt,ans+input[idx]);
        }else {
            dfs(cnt+1,idx+1,mCnt,jCnt+1,ans+input[idx]);
        }
        dfs(cnt,idx+1,mCnt,jCnt,ans);

    }
    static boolean check(char ch) {
        if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;

    }
}
