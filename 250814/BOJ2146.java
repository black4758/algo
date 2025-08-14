import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {
    static int N,ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num=0;
        visited=new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num++;
                bfs(i, j,num);
            }
        }
        ans=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num = map[i][j];
                if(num==0){
                    continue;
                }
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] != num) {
                        bfs2(i,j); // 주변에 바다가 있으면 bfs 탐색
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static void bfs(int x, int y ,int num){  // 같은 섬 번호 매기기
        if(map[x][y]==1 &&  !visited[x][y]) {
            Queue<int[]> q=new LinkedList<>();
            map[x][y]=num;
            q.add(new int[]{x, y});
            visited[x][y]=true;
            while(!q.isEmpty()){
                int[] now=q.poll();
                for(int k=0;k<4;k++){
                    int nx=now[0]+dx[k];
                    int ny=now[1]+dy[k];
                    if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny]==1 ){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny]=true;
                        map[nx][ny]=num;
                    }
                }
            }
        }
    }
    static void bfs2(int x, int y){ // 다리 만들기
        int num=map[x][y];
        visited=new boolean[N][N];
        if(!visited[x][y]) {
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{x, y,0});
            visited[x][y]=true;
            while(!q.isEmpty()){
                int[] now=q.poll();
                for(int k=0;k<4;k++){
                    int nx=now[0]+dx[k];
                    int ny=now[1]+dy[k];
                    if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                        if(map[nx][ny]==0){
                            q.add(new int[]{nx,ny,now[2]+1});
                            visited[nx][ny]=true;
                        }
                        else if(map[nx][ny]!=num){
                            ans=Math.min(ans,now[2]);
                            return;
                        }

                    }
                }
            }
        }
    }
}
