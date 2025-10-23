import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ6858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            list.add(new ArrayList<>());
        }
        int[] cnt = new int[8];
        int[][] first = {{1,7},{1,4},{2,1},{3,4},{3,5}};
        for (int[] now :first) {
            list.get(now[0]).add(now[1]);
            cnt[now[1]]++;
        }
        while (true) {
            int input1 =Integer.parseInt(br.readLine());
            int input2 = Integer.parseInt(br.readLine());
            if(!(input1== 0 && input2==0)) {
                list.get(input1).add(input2);
                cnt[input2]++;
            }
            else break;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= 7; i++) {
            if(cnt[i]==0) {
                pq.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int now = pq.poll();
            ans.add(now);
            for (int next : list.get(now)) {
                cnt[next]--;
                if(cnt[next]==0) {
                    pq.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (ans.size() == 7) {
            for (int now : ans) {
                sb.append(now).append(" ");
            }
        }
        else sb.append("Cannot complete these tasks. Going to bed.");
        System.out.print(sb);
    }
}
