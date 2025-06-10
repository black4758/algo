import java.util.Arrays;

public class SortIntegersDescending {
    public long solution(long n) {
        String nAsString=Long.toString(n);
        char[] arr = nAsString.toCharArray();
        Arrays.sort(arr);
        String answer="";
        for(int i=arr.length-1;i>=0;i--){
            answer+=arr[i];
        }

        return Long.parseLong(answer);
    }
}
