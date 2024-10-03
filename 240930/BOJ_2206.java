import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] map= new int[N+1][M+1];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
		boolean[][][] visited= new boolean[N+1][M+1][2];
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j]=Integer.parseInt(input.charAt(j-1)+"");
			}
		}
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(1,1,1));
		int cnt=0;
		visited[1][1][0]=true;
		visited[1][1][1]=true;
		while(!q.isEmpty()) {
			cnt++;
			int size= q.size();
			for (int i = 0; i <size; i++) {
				Position now= q.poll();
				if(now.x==N && now.y==M) {
					System.out.println(cnt);
					return ;
				}
				for (int j = 0; j <4; j++) {
					int nx = now.x+ dx[j];
					int ny = now.y+ dy[j];
					if(nx>=1 && nx<=N &&ny>=1 &&ny<=M ) {
						if(map[nx][ny]==0) {
							 if(now.shoot==1&&!visited[nx][ny][0]) {
									q.add(new Position(nx, ny,1));
									visited[nx][ny][0]=true;
								}
								else if(now.shoot==0 &&!visited[nx][ny][1]) {
									q.add(new Position(nx, ny,0));
                                    visited[nx][ny][1]=true;
								}
						}
						else {
							if(now.shoot==1) {
								q.add(new Position(nx, ny,0));
								visited[nx][ny][1]=true;
							}
						}

					}
				}
			}
			
		}
		System.out.println(-1);
	}
	static class Position{
		int x,y, shoot;

		public Position(int x, int y, int shoot) {
			super();
			this.x = x;
			this.y = y;
			this.shoot=shoot;
		}
		
	}
}