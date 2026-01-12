import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1432 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            list.add(new ArrayList<>());
        }
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j)=='1'){
                    list.get(j+1).add(i);
                    arr[i]++;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 1; i <= n; i++) {
            if(arr[i]==0){
                pq.add(i);
            }
        }
        int [] ans = new int [n+1];
        int idx = n;
        while(!pq.isEmpty()){
            int now = pq.poll();
            ans[now] = idx--;
            for(int next:list.get(now)){
                arr[next]--;
                if(arr[next]==0){
                    pq.add(next);
                }
            }
        }
        if (idx !=0){
            System.out.println(-1);
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
