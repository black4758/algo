import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {
    static class  Position{
        int x;
        int y;
        int cnt;
        int k;
        Position(int x,int y,int k,int cnt){
            this.x=x;
            this.y=y;
            this.k =k;
            this.cnt=cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][K+1];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(""+s.charAt(j));
            }
        }
        Queue<Position> q = new LinkedList<>();
        int ans=-1;
        q.add(new Position(0,0,K,1));
        visited[0][0][K]=true;
        while(!q.isEmpty()){
            Position now = q.poll();
            if(now.x==N-1&&now.y==M-1){
                ans=now.cnt;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<M && !visited[nx][ny][now.k]){
                    if(map[nx][ny]==0){
                        q.add(new Position(nx,ny, now.k, now.cnt+1));
                        visited[nx][ny][now.k]=true;
                    }
                    else if(now.k>0&&!visited[nx][ny][now.k-1]){
                        q.add(new Position(nx,ny, now.k-1, now.cnt+1));
                        visited[nx][ny][now.k-1]=true;
                    }

                }

            }
        }
        System.out.println(ans);
    }
}
