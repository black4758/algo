import java.io.*;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        for(int i=4;i<=10;i++) {
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(arr[input]).append("\n");
        }
        System.out.println(sb);
    }
}
