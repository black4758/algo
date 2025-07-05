import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961 {
    static int N;
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        ans=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        subset(0,1,0,0);
        System.out.println(ans);
    }
    public static void subset(int cnt,int score1, int score2,int choiceCnt) {
        if(cnt == N) {
            if(choiceCnt ==0){
                return;
            }
            else if(ans>Math.abs(score1-score2)){
                ans=Math.abs(score1-score2);
            }
            return;
        }
        subset(cnt+1, score1*arr[cnt][0], score2+arr[cnt][1],choiceCnt+1);
        subset(cnt+1, score1, score2, choiceCnt);

    }
}
