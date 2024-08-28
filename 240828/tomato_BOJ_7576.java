import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomato_BOJ_7576 {
	static class position{
		int x;int y;
		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M=sc.nextInt();
		int N= sc.nextInt();
		int[][] arr= new int[N][M];
		int count=0;
		Queue<position> q= new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==1) {
					q.add(new position(i, j));
				}
				if(arr[i][j]==0) count++;
			}
		}
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		int changeCont=0;
		int an=-1;
		while(!q.isEmpty()) {
			int total=q.size();
			System.out.println(total);
			for(int i=0;i<total;i++) {
				position now =q.poll();
				for(int j=0;j<4;j++) {
					int nx=now.x+dx[j];
					int ny=now.y+dy[j];
					if(nx>=0&&nx<N&&ny>=0&&ny<M) {
						if(arr[nx][ny]==0) {
							changeCont++;
							arr[nx][ny]=1;
							q.add(new position(nx, ny));
						}

					}
				}
			}
			an++;
		}
		if(changeCont==count) System.out.println(an);
		else System.out.println(-1);
	}	
}
