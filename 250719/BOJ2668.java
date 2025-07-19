import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2668 {
    static int [] input;
    static boolean[] visited;
    static boolean [] cycle;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        input = new int[N+1];
        visited = new boolean[N+1];
        cycle = new boolean[N+1];
        list= new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }
        list.sort(((o1, o2) -> o1-o2 ));
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(Integer integer : list) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int i) {
        visited[i] = true;
        int next =input[i];
        if(!visited[next]) {
            dfs(next);
        }
        else {
            if (!cycle[next]) {
                list.add(i);
                while (next != i) {
                    list.add(next);
                    next = input[next];
                }
            }
        }
        cycle[i]= true;
    }
}
