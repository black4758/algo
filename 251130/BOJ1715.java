import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(br.readLine());
            pq.add(a);
        }
        int ans =0;

        if (pq.size() == 1) {
            System.out.println(0);
            return;
        }
        int sum=0;
        while(pq.size()>1){
            sum=pq.poll()+pq.poll();
            ans+=sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}
