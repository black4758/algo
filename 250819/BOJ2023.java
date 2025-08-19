import java.io.*;

public class BOJ2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs("");
        System.out.println(sb);
    }
    static void dfs(String ans) {
        if (ans.length() == N) {
            sb.append(ans).append("\n");
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (ans.isEmpty() && i == 0) continue;

            if(check(ans+i)) {
                dfs(ans+i);
            }

        }
    }
    static boolean check(String s) {
        int num =Integer.parseInt(s);
        if(num<2){
            return false;
        }
        for(int k=2;k*k<=num;k++){
            if(num%k==0){
                return false;
            }
        }

        return true;
    }
}
