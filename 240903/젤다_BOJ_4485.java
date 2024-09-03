import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 젤다_BOJ_4485 {
	public static void main(String[] args) {
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int count=0;
		int[][] map;
		int [][] visited;
		Queue<position> q;
		while(N !=0) {
			count++;
			visited = new int[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					map[i][j]=sc.nextInt();
					visited[i][j]=Integer.MAX_VALUE;
				}
			}

			q = new LinkedList<position>();
			q.add(new position(0, 0));
			visited[0][0]=map[0][0];
			while(!q.isEmpty()) {
				position now = q.poll();
				int x=now.x;
				int y=now.y;
				for(int i=0;i<4;i++) {
					int nx = now.x+dx[i];
					int ny = now.y+dy[i];
	    			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
	    			int nValue = map[nx][ny]  + visited[x][y];

		    		if(visited[nx][ny] <= nValue) continue; 
		      		visited[nx][ny] = nValue;
		    		q.offer(new position(nx, ny));
					
				}
			}
			System.out.println("Problem "+count+": "+visited[N-1][N-1]);
			N=sc.nextInt();
		}
		
	}
	 static class position{
		int x,y;

		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}