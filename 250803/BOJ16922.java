import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ16922 {
    static int[] arr ={1,5,10,50};
    static Set<Integer> set = new HashSet<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dfx(0,0,0);
        System.out.println(set.size());
    }
    static void dfx(int cnt,int st, int sum){
        if(cnt==N){
            set.add(sum);
            return;
        }
        for(int i=st;i<4;i++){
            dfx(cnt+1,i,sum+arr[i]);
        }
    }
}
