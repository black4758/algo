import java.util.Scanner;

public class 등산_SWE_1949 {
	static int map[][],N,K,an;
	static boolean [][] visited;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int max=-1;
			N= sc.nextInt();
			K= sc.nextInt();
			map= new int[N][N];
			an=0;
			visited= new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
					if(max<map[i][j]) max=map[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max==map[i][j]) {
						visited[i][j]=true;
						dfs(i,j,1,max,0);
						visited[i][j]=false;
					}
				}
			}
			System.out.println("#"+tc+" "+an);
		}
	}
	private static void dfs(int x, int y, int count,int height, int kSwitch) {
		for(int i=0;i<4;i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			if(an<count) an=count;
			if(nx>=0 && nx<N && ny>=0 && ny<N && visited[nx][ny]==false) {
				if(map[nx][ny]<height) {
					visited[nx][ny]=true;
					dfs(nx, ny, count+1, map[nx][ny], kSwitch);
					visited[nx][ny]=false;
				}
				if(height<=map[nx][ny] && kSwitch==0) {
					if(map[nx][ny]-K<height) {
						visited[nx][ny]=true;
						dfs(nx, ny, count+1, height-1, kSwitch+1);
						visited[nx][ny]=false;
					}
				}
			}
		}
	}

}
