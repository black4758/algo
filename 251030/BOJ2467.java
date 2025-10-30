import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int minAbsSum = Math.abs(arr[left] + arr[right]);
        int leftAns =arr[left];
        int rightAns = arr[right];
        while (left < right) {
            int sum=arr[right]+arr[left];
            if (Math.abs(sum)< minAbsSum) {
                minAbsSum =Math.abs( arr[right]+arr[left]);
                leftAns = arr[left];
                rightAns = arr[right];
            }
            if(sum<0){
                left++;
            }
            else if(sum>0){
                right--;
            }
            else break;
        }
        System.out.println(leftAns + " " + rightAns);
    }
}
