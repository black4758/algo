import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Position[] visited;
    static ArrayList<Position> chStore = new ArrayList<>();
    static ArrayList<Position> customer = new ArrayList<>();
    static int M,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited=new Position[M];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    customer.add(new Position(i, j));
                }
                if (input == 2) {
                    chStore.add(new Position(i, j));
                }
            }
        }
        solution(0,0);
        System.out.println(ans);
    }
    static void solution(int st, int cnt) {
        if (cnt == M) {
            int sum=0;
            for(Position nowC:customer){
                int minDistance=Integer.MAX_VALUE;
                for(Position store:visited){
                    int distance = Math.abs(nowC.x-store.x)+Math.abs(nowC.y-store.y);
                    minDistance=Math.min(minDistance,distance);
                }
                sum+=minDistance;
            }
            ans=Math.min(ans,sum);
            return;
        }
        for (int i = st; i < chStore.size(); i++) {
            visited[cnt]=chStore.get(i);
            solution(i+1,cnt+1);
        }
    }

}
