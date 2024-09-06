import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이_SWA_1600 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		int mx[]= {-1,-2,-2,-1,1,2,2,1};
		int my[]= {-2,-1,1,2,2,1,-1,-2};
		int an=0;
		boolean [][][] visited=new boolean[K+1][H][W];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, K));
		visited[K][0][0]=true;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node now = q.poll();
				if(now.x==H-1 && now.y==W-1) {
					System.out.println(an);
					return;
				}
				for (int j = 0; j < 4; j++) {
					int nx= now.x+dx[j];
					int ny= now.y+dy[j];
					if(nx >=0 && nx <H && ny >= 0 && ny<W && ! visited[now.k][nx][ny] && map[nx][ny]==0) {
						 visited[now.k][nx][ny] = true;
						 q.add(new Node(nx, ny, now.k));
					}
				}
				if(now.k >0) {
					for (int j = 0; j < 8; j++) {
						int nx= now.x+mx[j];
						int ny= now.y+my[j];
						if(nx >=0 && nx <H && ny >= 0 && ny<W && ! visited[now.k-1][nx][ny] && map[nx][ny]==0) {
							 visited[now.k-1][nx][ny] = true;
							 q.add(new Node(nx, ny, now.k-1));
						}
					}
				}
			}
			an++;
		}
		System.out.println(-1);
		
	}
	static class Node{
		int x,y,k;

		public Node(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
		
	}
}
