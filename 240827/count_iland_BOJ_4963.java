import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class position{
	int x,y;

	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class count_iland_BOJ_4963 {
	static int w,h;
	static int [][] arr;
	static boolean [][] visited;
	static int[] dx = {-1, 0, 1, 0 , 1, -1, 1, -1};
	static int[] dy = {0, -1, 0, 1 , 1, 1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w= sc.nextInt();
		h=sc.nextInt();
		while(w!=0&&h!=0) {
			arr= new int [h][w];
			visited= new boolean [h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			int an=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(arr[i][j]==1&&visited[i][j]==false) {
						bfs(i,j);
						an++;
					}
				}
			}
			System.out.println(an);
			w= sc.nextInt();
			h=sc.nextInt();
		}
	}
	private static void bfs(int x, int y) {
		Queue<position> q = new LinkedList<>(); 
		visited[x][y]= true;
		q.add(new position(x, y));
		 while(!q.isEmpty()) {
			 position now= q.poll();
			 x=now.x;
			 y=now.y;
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < h && ny>= 0 && ny < w && arr[nx][ny]==1 &&!visited[nx][ny]) {
						visited[nx][ny]= true;
						q.add(new position(nx, ny));
					}
				}
		 }

	}

}
