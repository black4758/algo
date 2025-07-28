import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int max = 0;
        int[] score=new int[1000001];
        boolean[] visited = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
            visited[arr[i]] = true;
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]*2; j <=max; j=j+arr[i]) {
                if (visited[j]) {
                   score[arr[i]]++;
                   score[j]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
                sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }
}
