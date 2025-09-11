import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ans = 0;
        for (int i = 0; i < N; i++) {
//            if (check(i)) {
//                ans++;
//            }
            check2(i);
        }
        System.out.println(ans);


    }
    //이분탐색
    static boolean check(int now) {
        for (int i = 0; i < arr.length; i++) {
            if(i==now){
                continue;
            }
            int target = arr[now]-arr[i];
            int left =0;
            int right = arr.length-1;
            while(left <= right){
                int mid = (left + right) /2;
                if (mid == now || mid == i) {
                    if (mid < now) left = mid + 1;
                    else right = mid - 1;
                    continue;
                }
                if(arr[mid]==target){
                    return true;
                }
                else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    //투포인터
    static void check2(int now) {
        int start = 0;
        int end = arr.length-1;
        int target = arr[now];
        while(start < end){
            if(start == now){
                start++;
                continue;
            }
            else if(end == now){
                end--;
                continue;
            }
            int sum = arr[start] + arr[end];
            if(sum == target){
                ans++;
                break;
            }
            else if(sum < target){
                start++;
            }
            else{
                end--;
            }
        }
    }
}
