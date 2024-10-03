import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		for (int tc = 1; tc < 10; tc++) {
			Queue<Position> q = new LinkedList<>();
			int T= sc.nextInt();
			int[][] map = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String input = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt(""+input.charAt(j));
					if(map[i][j]==2) {
						visited[i][j]= true;
						q.add(new Position(i, j));
					}
					
				}
			}
			int an=-1;

			while(!q.isEmpty()) {
				Position now = q.poll();
				if(map[now.x][now.y]==3) {
					an=1;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x+dx[i];
					int ny = now.y+dy[i];
					if(nx>=0 && nx<16 && ny>=0 && ny<16 && !visited[nx][ny] && map[nx][ny]!=1) {
						q.add(new Position(nx, ny));
						visited[nx][ny]=true;
					}
				}
				
			}
			System.out.println("#"+T+" "+an);
		}
	}
	
	
	static class Position {
		int x,y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}

