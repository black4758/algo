import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new char[M][K];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= M-8; i++) {
            for (int j = 0; j <= K-8; j++) {
                ans=Math.min(solution(i,j), ans);
            }
        }
        System.out.println(ans);
    }
    public static int solution(int x,int y){
        int ans1 = 0;
        int ans2 = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                char ch = map[i][j];
                if ((j+i)%2==0) {
                    if(ch !='W'){
                        ans1++;
                    }
                    else ans2++;
                }
                else {
                    if(ch !='B'){
                        ans1++;
                    }
                    else ans2++;
                }
            }
        }
        return Math.min(ans1,ans2);

    }
}
