import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2239 {
    static boolean flag = false;
    static int[][] map;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';
                if(map[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }
        dfs(0);
    }
    private static void dfs(int cnt) {
        if(flag){
            return;
        }
        if(cnt==list.size()){
            flag=true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            int[] now=list.get(cnt);
            if(check(now[0],now[1],i)){
                map[now[0]][now[1]]=i;
                dfs(cnt+1);
                map[now[0]][now[1]]=0;
            }
        }
    }
    static boolean check(int x,int y,int num){
        for (int i = 0; i < 9; i++) {
            if(map[i][y]==num || map[x][i]==num){
                return false;
            }
        }
        int nx =(x/3)*3;
        int ny = (y/3)*3;
        for (int i = nx; i < nx+3; i++) {
            for (int j = ny; j < ny+3; j++) {
                if(map[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
