import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        int max=0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a<0){
                left.add(a*-1);
            }
            else right.add(a);
            max=Math.max(max, Math.abs(a));
        }
        right.sort((a,b)->b-a);
        left.sort((a,b)->b-a);


        int ans=0;
        for (int i = 0; i < right.size(); i+=m) {
            ans+=right.get(i)*2;
        }
        for (int i = 0; i < left.size(); i+=m) {
            ans+=left.get(i)*2;
        }
        System.out.println(ans-max);

    }
}
