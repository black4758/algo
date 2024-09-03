
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class home_SWEA_2117 {
	static int N,M,map[][],dx[]= {1,-1,0,0},dy[]= {0,0,1,-1},an;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for (int tc = 1; tc <= T ; tc++) {
			N=sc.nextInt();
			M= sc.nextInt();
			map= new int[N][N];
			an=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//bfs 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i,j);
				}
			}
			System.out.println("#"+tc+" "+an);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		int k=1;
		int count=0;
		boolean[][] visited = new boolean[N][N]; 
		q.add(new Node(x,y));
		visited[x][y]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-- !=0) { //size 만큼 탐색후 k 증가
				Node now=q.poll();
				if(map[now.x][now.y]==1) count++; //집이 있을때 count 증가
				for(int i=0;i<4;i++) {
					int nx=now.x+dx[i];
					int ny=now.y+dy[i];
					if(nx>=0 && nx<N && ny<N && ny>=0 && !visited[nx][ny]) {
						q.add(new Node(nx, ny));
						visited[nx][ny]=true;
					}
				}
			}
			if(M*count>=k*k+(k-1)*(k-1)) { //수익이 나면 비교후 count를 정답으로
				if(an<count) {
					an=count;
				}
			}
			k++; //k증가
		}
		
	}
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
