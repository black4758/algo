import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int ans1=0;
        int ans2=0;
        int minSum = Integer.MAX_VALUE;
        while (left < right) {
            int sum=arr[left]+arr[right];
            if(Math.abs(sum)< minSum){
                minSum = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }
            if(sum<0){
                left++;
            }else {
                right--;
            }
        }
        System.out.println(ans1+" "+ans2);
    }
}
