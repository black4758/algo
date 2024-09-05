import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 젤다_다익스트라_BOJ4485 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N=Integer.parseInt(br.readLine());
		int cn=0;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int[][] map;
		while (N !=0) {
			map= new int[N][N];
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int[][] minArr= new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					minArr[i][j]=Integer.MAX_VALUE;
				}
			}
			int an=0;
			Queue<Node> q= new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
			minArr[0][0]=map[0][0];
			q.add(new Node(0, 0, minArr[0][0]));
			
			boolean[][] visited = new boolean[N][N];
			while(!q.isEmpty()) {
				Node now = q.poll();
				if (now.x == N - 1 && now.y == N - 1) {
					an= now.cost;
					break;
				}

				if (visited[now.x][now.y]) {
					continue;
				}
				visited[now.x][now.y]= true;
				for (int i = 0; i < 4; i++) {
					int nx=now.x+dx[i];
					int ny=now.y+dy[i];
					if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
						if(minArr[nx][ny]>minArr[now.x][now.y]+map[nx][ny]) {
							minArr[nx][ny]=minArr[now.x][now.y]+map[nx][ny];
							q.add(new Node(nx, ny, minArr[nx][ny]));
						}
					}
				}

			}
			cn++;
			System.out.println("Problem "+cn+": "+an);
			N=Integer.parseInt(br.readLine());
		}
	}
	static class Node{
		int x,y,cost;

		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
	}
}
