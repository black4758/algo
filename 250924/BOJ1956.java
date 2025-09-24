import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader be = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(be.readLine());
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int[][] arr = new int[V+1][V+1];
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
                else arr[i][j]=100_000_000;
            }
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(be.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            arr[start][end]=cost;
        }
        for(int k=1;k<=V;k++){
            for(int i=1;i<=V;i++){
                if(arr[i][k]==100_000_000){
                    continue;
                }
                for(int j=1;j<=V;j++){
                    if(arr[k][j]!=100_000_000){
                        if(arr[i][j]>arr[k][j]+arr[i][k]){
                            arr[i][j]=arr[k][j]+arr[i][k];
                        }
                    }
                }
            }
        }
        int answer = 100_000_000;
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                if(i!=j){
                    if (arr[i][j] != 100_000_000 && arr[j][i] != 100_000_000) {
                        answer = Math.min(answer, arr[i][j] + arr[j][i]);
                    }
                }
            }
        }
        if(answer==100_000_000){
            System.out.println("-1");
        }
        else {
            System.out.println(answer);
        }
    }
}
