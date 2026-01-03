import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {
    static int[] dz={1,-1,0,0,0,0};
    static int[] dx={0,0,-1,1,0,0};
    static int[] dy={0,0,0,0,1,-1};
    static int L,R,C;
    static char [][][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[L][R][C];
            if(L==0 && R==0 && C==0){
                break;
            }
            Queue<int[]> q = new ArrayDeque<>();
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String input = br.readLine();
                    for(int k=0; k<C; k++){
                        map[i][j][k] = input.charAt(k);
                        if(map[i][j][k]=='S'){
                            q.offer(new int[]{i,j,k,0});
                            map[i][j][k] = '-';
                        }
                    }
                }
                br.readLine();
            }
            int ans=bfs(q);

            if (ans==-1){
                sb.append("Trapped!").append("\n");
            }
            else{
                sb.append("Escaped in").append(" ").append(ans).append(" minute(s).").append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
    public static int bfs(Queue<int[]> q){
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i=0 ;i<6;i++){
                int nz =now[0]+dz[i];
                int nx =now[1]+dx[i];
                int ny = now[2]+dy[i];
                if(nz>=0 && nx>=0 && ny>=0 &&nz<L && nx<R && ny<C){
                    if(map[nz][nx][ny]=='.'){
                        q.offer(new int[]{nz,nx,ny,now[3]+1});
                        map[nz][nx][ny] = '-';
                    }
                    else if(map[nz][nx][ny]=='E'){
                        return now[3]+1;
                    }
                }
            }
        }
        return -1;
    }
}
