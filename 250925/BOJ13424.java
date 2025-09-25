import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13424 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i ==j) {
                        arr[i][j] = 0;
                    } else {
                        arr[i][j]=100_000_000;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                arr[start][end]=cost;
                arr[end][start]=cost;
            }
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    if(arr[i][k]==100_000_000){
                        continue;
                    }
                    for (int j = 1; j <= N; j++) {
                        if(arr[k][j]==100_000_000){
                            continue;
                        }
                        if(arr[i][j]>arr[k][j]+arr[i][k]){
                            arr[i][j]=arr[k][j]+arr[i][k];
                        }
                    }
                }
            }
            int friendCount = Integer.parseInt(br.readLine());
            int[] friendArr = new int[friendCount];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < friendCount; i++) {
                friendArr[i] = Integer.parseInt(st.nextToken());
            }
            int totalSum = 100_000_000;
            int ans = 1;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int fr : friendArr) {
                    sum+=arr[i][fr];
                }
                if(sum<totalSum){
                    totalSum=sum;
                    ans=i;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
