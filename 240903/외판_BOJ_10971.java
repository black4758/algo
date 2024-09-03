import java.util.Scanner;

public class 외판_BOJ_10971 {
	static int[][] map;
	static boolean [] visited;
	static int N,an;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		map= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		an=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			visited= new boolean[N];
			visited[i]=true;
			dfs(i,i,0,1);
			
		}
		System.out.println(an);
	}

	private static void dfs(int st, int now, int cost,int cnt) {
		if(cnt==N) {
			if(map[now][st] !=0) {
				an=Math.min(an, cost+map[now][0]);
				return;
			}

			
		}
		for(int i=1;i<N;i++) {
			if(!visited[i]&&map[now][i]!=0) {
				visited[i]=true;
				dfs(st,i,cost+map[now][i],cnt+1);
				visited[i]=false;

				
			}
		}
		
	}
}
