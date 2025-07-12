import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16437 {
    static long [] cnt;
    static ArrayList<ArrayList<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cnt = new long[N+1];
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            if (c.equals("W")){
                number=number*-1;
            }
            cnt[i]=number;
            tree.get(parent).add(i);
        }

        System.out.println(dfs(1));

    }
    static long dfs(int parent){
        long sum = 0;
        for(int i : tree.get(parent)){
            sum+=dfs(i);
        }
        sum+=cnt[parent];

        return Math.max(sum, 0);
    }
}
