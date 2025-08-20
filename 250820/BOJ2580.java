import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2580 {
    static int[][] map;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
    }
    static void dfs(int cnt) {
        if (list.size() == cnt) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }
        int[] now=list.get(cnt);
        for (int i = 1; i <=9; i++) {
            if(check(now[0],now[1],i)){
                map[now[0]][now[1]]=i;
                dfs(cnt+1);
                map[now[0]][now[1]]=0;
            }
        }
    }
    static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == val || map[i][y] == val) return false;
        }
        int nx =(x/3)*3;
        int ny =(y/3)*3;
        for (int i = nx; i <nx+3; i++) {
            for (int j = ny; j < ny+3; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
