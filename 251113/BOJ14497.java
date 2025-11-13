import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14497 {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] start = new int [2];
        start [0] = Integer.parseInt(st.nextToken())-1;
        start [1] = Integer.parseInt(st.nextToken())-1;
        int [] end = new int [2];
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;
        int ans=0;
        char[][] map = new char[N][M];
        for(int i=0;i<N;i++){
            String input=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j);
            }
        }
        while (true) {
            ans++;
            if (bfs(map, start)) break;
        }
        System.out.println(ans);
    }
    public static boolean bfs(char[][] map,int[] start){
        int[]dx={1,-1,0,0};
        int[]dy={0,0,-1,1};
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];
                if(nx>=0 && ny>=0 && nx<map.length && ny<map[0].length && !visited[nx][ny]){
                    if(map[nx][ny]=='1'){
                        map[nx][ny]='0';
                        visited[nx][ny]=true;
                    }
                    else if(map[nx][ny]=='0'){
                        visited[nx][ny]=true;
                        queue.offer(new int[]{nx,ny});
                    }
                    else if(map[nx][ny]=='#'){
                        return  true;
                    }
                } ;
            }
        }
        return false;
    }
}