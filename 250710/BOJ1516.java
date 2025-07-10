import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] time = new int[N+1];
        int [] cnt = new int[N+1];
        int [] resultTime = new int[N+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int input= Integer.parseInt(st.nextToken());
            while (input != -1) {
                list.get(input).add(i);
                cnt[i]++;
                input = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++){
            if (cnt[i] == 0){
                queue.add(i);
                resultTime[i] = time[i];
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int next : list.get(now)){
                cnt[next]--;
                resultTime[next] = Math.max(resultTime[next], time[next]+resultTime[now]);
                if (cnt[next] == 0){
                    queue.add(next);
                }
            }
        }
        for (int i =1; i<=N; i++){
            sb.append(resultTime[i]).append("\n");
        }
        System.out.println(sb);

    }
}
