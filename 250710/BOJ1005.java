import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int [] resultTime = new int[N+1];
            int[] time = new int[N+1];
            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> inputList= new  ArrayList<>();
            for (int i = 0; i <= N; i++) {
                inputList.add(new ArrayList<>());
            }
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int first= Integer.parseInt(st.nextToken());
                int second= Integer.parseInt(st.nextToken());
                inputList.get(first).add(second);
                arr[second]++;
            }
            int W = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (arr[i] == 0) {
                    queue.add(i);
                    resultTime[i] = time[i];
                }
            }
            while (!queue.isEmpty()) {
                int now=queue.poll();

                for(int next:inputList.get(now)){
                    arr[next]--;
                    resultTime[next]=Math.max(resultTime[next],resultTime[now]+time[next]);
                    if(arr[next]==0){
                        queue.add(next);
                    }
                }
            }
            System.out.println(resultTime[W]);
        }
    }
}
