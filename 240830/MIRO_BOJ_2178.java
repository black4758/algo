import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MIRO_BOJ_2178 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map= new int [N+1][M+1];
		int[][] visited= new int [N+1][M+1];
		int[] dx= {1,-1,0,0};
		int[] dy= {0,0,1,-1};
		
		for(int i=1;i<=N;i++) {
			String input = sc.next();
			for(int j=1;j<=M;j++) {
				map[i][j]=input.charAt(j-1)-'0';
			}
		}
		Queue<positon> q=new  LinkedList<>();
		q.add(new positon(1, 1));
		visited[1][1]=visited[0][0]+1;
		while (!q.isEmpty()) {
			positon nowPosition =q.poll();
			int x=nowPosition.x;
			int y=nowPosition.y;
			if(x==N&&y==M) {
				System.out.println(visited[x][y]);
				break;
			}
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>0&&nx<=N&&ny>0&&ny<=M&&visited[nx][ny]==0&&map[nx][ny]==1) {
					visited[nx][ny]+=visited[x][y]+1;
					q.add(new positon(nx, ny));
				}
			}
		}
		
	}
	static class positon{
		int x, y;

		public positon(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
