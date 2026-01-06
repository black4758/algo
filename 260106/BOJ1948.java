import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<int[]>> list = new ArrayList<>();
        List<List<int[]>> reverseList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
        int[] arr = new int[n+1];
        StringTokenizer st = null;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, c});
            reverseList.get(b).add(new int[]{a, c});
            arr[b]++;
        }
        int[] maxTime = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int[] next : list.get(now)) {
                if (maxTime[next[0]]<maxTime[now]+next[1]) {
                    maxTime[next[0]]=maxTime[now]+next[1];
                }
                arr[next[0]]--;
                if (arr[next[0]]==0) {
                    queue.add(next[0]);
                }
            }
        }
        int count = 0;
        boolean [] visited = new boolean[n+1];
        queue.add(end);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int[] pre : reverseList.get(now)) {
                if (maxTime[now]==maxTime[pre[0]]+pre[1]) {
                    count++;
                    if (!visited[pre[0]]) {
                        visited[pre[0]] = true;
                        queue.add(pre[0]);
                    }
                }
            }
        }
        System.out.println(maxTime[end]);
        System.out.println(count);
    }
}
