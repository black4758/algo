import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Safe_BOJ_2468 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N= sc.nextInt();
		int max=0;
		int [][] arr= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
				max=Math.max(max, arr[i][j]);
			}
		}
		Queue<postion> q= new LinkedList<>();
		int an=0;int count=0;
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		boolean[][] visited;
		for(int i=0;i<max;i++) {
			count=0;
			visited =new boolean[N][N];
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					if(arr[x][y]>i&&!visited[x][y]) {
						q.add(new postion(x, y));
						visited[x][y]=true;
						while(!q.isEmpty()) {
							postion now_q= q.poll();
							for(int z=0;z<4;z++) {
								int nx=now_q.x+dx[z];
								int ny=now_q.y+dy[z];
								if(nx>=0&&nx<N&&ny<N&&ny>=0&& !visited[nx][ny]&&arr[nx][ny]>i) {
									visited[nx][ny]=true;
									q.add(new postion(nx, ny));
								}
							}
						}
						count++;
						}
					}
				}
			an=Math.max(an, count);
			}
		System.out.println(an);
	}
	
	static class postion{
		int x,y;

		public postion(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
