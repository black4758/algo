import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum1 = new int[n*n];
        int[] sum2 = new int[n*n];
        int temp =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1[temp] = a[i]+b[j];
                sum2[temp] = c[j]+d[i];
                temp++;
            }
        }
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        long ans = 0;
        int start=0;
        int end=n*n-1;
        while (start<n*n && end>=0) {
            int sum = sum1[start] + sum2[end];
            if(sum==0){
                long cnt1=0, cnt2=0;
                temp = sum1[start];
                while (start<n*n && temp==sum1[start]) {
                    start++;
                    cnt1++;
                }
                temp = sum2[end];
                while (end>=0 && temp==sum2[end]) {
                    cnt2++;
                    end--;
                }
                ans+= cnt2 * cnt1;
            }else if(sum<0){
                start++;
            }else {
                end--;
            }
        }
        System.out.println(ans);
    }
}
