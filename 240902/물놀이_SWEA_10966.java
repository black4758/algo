import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 물놀이_SWEA_10966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			char[][] map= new char[N][M];
			int[][] visited= new int[N][M];
			Queue<positon> q= new LinkedList<>();
			for(int i=0;i<N;i++) {
				String input =sc.next();
				for(int j=0;j<M;j++) {
					map[i][j]=input.charAt(j);
					if(map[i][j]=='W') {
						q.add(new positon(i, j)); //W 인것을 리스트에 모두 삽입
					}
				}
			}
			int dx[]= {1,-1,0,0};
			int dy[]= {0,0,1,-1};
			int total= N*M-q.size();
			int lCount=0;
			int answer=0;
			while(!q.isEmpty()) {
				positon now = q.poll();
				int x= now.x;
				int y= now.y;
				if(lCount==total) {
					break;
				}
				for(int i=0;i<4;i++) { //모든 w를 bfs를 돌려 탐색
					int nx= x+dx[i];
					int ny= y+dy[i];
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&map[nx][ny]=='L'&&visited[nx][ny]==0) {
						q.add(new positon(nx, ny));
						visited[nx][ny]=visited[x][y]+1;
						answer+=visited[nx][ny];
						lCount++;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
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
