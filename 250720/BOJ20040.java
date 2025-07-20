import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040 {
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if(!union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }
    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        parents[rootY] = rootX;
        return true;
    }
}
