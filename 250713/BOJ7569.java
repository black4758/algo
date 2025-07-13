import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static class Position {
        int x;
        int y;
        int h;
        int cnt;
        Position(int x, int y, int h, int cnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] map=new int[N][M][H];
        int ans=0;
        Queue<Position> q=new LinkedList<>();
        int cnt0=0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                    if(map[j][k][i]==1){
                        q.add(new Position(j,k,i,0));
                    }
                    if(map[j][k][i]==0){
                        cnt0++;
                    }
                }
            }
        }
        if(cnt0==0){
            System.out.println(0);
            return;
        }
        int[]dx={1,-1,0,0,0,0};
        int[]dy={0,0,1,-1,0,0};
        int[]dh={0,0,0,0,1,-1};
        while(!q.isEmpty()){
            Position now=q.poll();
            ans=Math.max(now.cnt,ans);
            for(int i=0;i<6;i++){
                int nx=now.x+dx[i];
                int ny =now.y+dy[i];
                int nh=now.h+dh[i];
                if(nx>=0 && nx<N && ny >=0 && ny <M && nh>=0&& nh<H && map[nx][ny][nh]==0){
                    map[nx][ny][nh]=1;
                    q.add(new Position(nx, ny,nh,now.cnt+1));
                    cnt0--;
                }
            }
        }
        if(cnt0!=0){
            System.out.println(-1);
        }
        else System.out.println(ans);
    }
}
