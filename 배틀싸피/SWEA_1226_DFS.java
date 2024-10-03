import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226_DFS {
	static Position st,fn;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static int[][] map;
	static boolean[][] visited;
	static int an;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			int T= sc.nextInt();
			an=0;
			map = new int[16][16];
			visited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String input = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt(""+input.charAt(j));
					if(map[i][j]==2) {
						
						st=new Position(i, j);
					}
				}
			}
			DFS(st.x,st.y);

			System.out.println("#"+T+" "+an);
		}
	}
	
	
	private static void DFS(int x, int y) {
		visited[x][y]= true;
		if(map[x][y]==3) {
			an=1;
			return ;
		}
		for (int i = 0; i <4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<16 && ny>=0 && ny<16 && !visited[nx][ny] && map[nx][ny]!=1) {
				DFS(nx,ny);
			}
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

