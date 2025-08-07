import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1068 {
    static LinkedList<LinkedList<Integer>> list;
    static int del,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(new LinkedList<>());
        }
        int root=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now == -1) {
                root=i;
                continue;
            }
            list.get(now).add(i);
        }
        del = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(ans);
    }

    static void  dfs(int root){
        if(root == del){
            return;
        }

        int cnt=0;
        for(int now : list.get(root)){
            if(now!=del){
                dfs(now);
                cnt++;
            }
        }
        if(cnt==0){
            ans++;
        }
    }
}
