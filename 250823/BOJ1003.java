import java.io.*;

public class BOJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[41][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        for(int i=2;i<=40;i++) {
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(arr[input][0]).append(" ").append(arr[input][1]).append("\n");
        }
        System.out.println(sb);
    }
}
