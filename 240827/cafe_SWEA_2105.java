import java.util.Scanner;

public class cafe_SWEA_2105 {
    static int[][] arr;
    static boolean[] KindDesert= new boolean[101];;
    static int an,N,fisrtx, fisrty;
    static int[] dx = { 1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            N= sc.nextInt();
            an=0;
            arr= new int[N][N];
            
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                	
                    arr[i][j]=sc.nextInt();
                }
            }
            
            for(int i=0;i<N-2;i++) {
                for(int j=0;j<N;j++) {
                	
                	fisrtx=i;
                	fisrty=j;
                    dfs(i,j,0,1);
                }
            }
            if(an==0) an=-1;
            System.out.println("#"+tc+" "+an);
        }
    }
    private static void dfs(int x, int y, int dir, int cnt) {
        KindDesert[arr[x][y]]=true;
        for(int i=0;i<2;i++) {
            if(dir+i==4) break;
            int nx=x+dx[dir+i];
            int ny=y+dy[dir+i];
            if(nx==fisrtx&&ny==fisrty) {
                an=Math.max(an, cnt);
            }
            if (nx >= 0 && nx < N && ny>= 0 && ny < N &&KindDesert[arr[nx][ny]]==false) {
                dfs(nx,ny,dir+i,cnt+1);
            }
        }
        KindDesert[arr[x][y]]=false;
        // TODO Auto-generated method stub
        
    }
}