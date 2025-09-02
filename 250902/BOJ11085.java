import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11085 {
    static Position[] input;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        input = new Position[w];
        arr = new int[p];
        for (int i = 0; i < p ; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < w ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            input[i]=new Position(start,end,cost);
        }
        Arrays.sort(input,((o1, o2) -> o2.cost - o1.cost));
        for (Position now : input) {
            union(now.start,now.end);
            if (find(c)==find(v)){
                System.out.println(now.cost);
                return;
            }
        }
    }
    static int find (int x){
        if (arr[x] == x){
            return x;
        }
        return arr[x]=find(arr[x]);
    }

    static void union (int a , int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB){
            arr[rootB]=rootA;
        }
    }
    static class Position{
        int start;
        int end;
        int cost;
        public Position(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
