import java.util.ArrayList;
import java.util.Collections;
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
public class danji_BOJ_2667 {
	static int N,an;
	static int [][] arr;
	static boolean [][] visited;
	static int[] dx = {-1, 0, 1, 0 , 1, -1, 1, -1};
	static int[] dy = {0, -1, 0, 1 , 1, 1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();

		arr= new int [N][N];
		visited= new boolean [N][N];
		for(int i=0;i<N;i++) {
			String input =sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j]=input.charAt(j)-'0';
			}
		}
		int sw=0;
		ArrayList<Integer> list =new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sw=0;
				an=0;
				if(arr[i][j]==1&&visited[i][j]==false) {
					bfs(i,j);
					list.add(an);
					
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
	}
	private static void bfs(int x, int y) {
		Queue<position> q = new LinkedList<>(); 
		visited[x][y]= true;
		an++;
		q.add(new position(x, y));
		 while(!q.isEmpty()) {
			 position now= q.poll();
			 x=now.x;
			 y=now.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx >= 0 && nx < N && ny>= 0 && ny < N && arr[nx][ny]==1 &&!visited[nx][ny]) {
						visited[nx][ny]= true;
						an++;
						q.add(new position(nx, ny));
					}
				}
		 }

	}

}
