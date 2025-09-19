import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] costArr = new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            costArr[i]=Integer.parseInt(st.nextToken());
        }
        int[][] arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    arr[i][j]=0;
                }else{
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<r;i++){
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start][end]=cost;
            arr[end][start]=cost;
        }
        for(int k = 1; k <=n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE){
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int currentItems = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] <= m) {
                    currentItems += costArr[j];
                }
            }
            ans = Math.max(ans, currentItems);
        }

        System.out.println(ans);
    }
}
