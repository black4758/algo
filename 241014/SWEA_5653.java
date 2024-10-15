import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class SWEA_5653 {
	static int dx[]= {1,-1,0,0},N,K,M;
	static int dy[]= {0,0,1,-1};
	static boolean [][]visited;
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			arr= new int[N+K+2][M+K+2];
			visited= new boolean[N+K+2][M+K+2];
			Queue<position>q = new LinkedList<>();
			for (int i = K/2+1; i <N+K/2+1; i++) {
				 st = new StringTokenizer(br.readLine());
				for (int j = K/2+1; j <M+K/2+1; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j] != 0) {
						q.add(new position(i, j, arr[i][j]));
						visited[i][j]=true;
					}
				}
			}
			
			while(K-->0) {
				int cnn= q.size();
				for (position now : q ) {
					if(now.temp==0) {
						check(now);
					}
				}
				
				for (int i = 0; i < cnn; i++) {
					position now = q.poll();
					if(now.temp==0) {
						for (int j = 0; j < 4; j++) {
							int nx= now.x+dx[j];
							int ny= now.y+dy[j];
							if(visited[nx][ny]) continue;
							q.add(new position(nx, ny,arr[nx][ny]));
							visited[nx][ny]= true;
						}
					}
					now.temp--;
					if(now.temp==now.value*-1) continue;

					else q.add(now);
					}
			
				}
			System.out.println("#"+tc + " "+ q.size());
			}
			
		}
	private static void check(position now) {
		for(int i=0;i<4;i++) {
			int x=now.x+dx[i];
			int y=now.y+dy[i];
			if(visited[x][y]) continue;
			if(arr[x][y]<now.value) {
				arr[x][y]=now.value;
			}
		}
		
	}
	static class position{
		int x,y,value,temp;

		public position(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
			temp=value;
		}
		
	}
}
