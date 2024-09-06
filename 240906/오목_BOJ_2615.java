import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_BOJ_2615 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int map[][] = new int[19][19];
		for (int y = 0; y < 19; y++) {
			st= new StringTokenizer(br.readLine());
			for (int x = 0; x < 19; x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}

		}
		int dx[]= {1,0,1,1};
		int dy[]= {0,1,1,-1};
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(map[i][j]!=0) {
					for (int z = 0; z < 4; z++) {
						int nx=i;
						int ny=j;
						int cnt=1;
						while(true) {
							ny= ny+dy[z];
							nx= nx+dx[z]; 
							if(nx>=0 && nx<19 && ny<19 && ny>=0 && map[i][j]==map[nx][ny]) {
								cnt++;
							}
							else break;
						}

						nx=i;
						ny=j;
						while(true) {
							ny= ny-dy[z];
							nx= nx-dx[z]; 
							if(nx>=0 && nx<19 && ny<19 && ny>=0 && map[i][j]==map[nx][ny]) {
								cnt++;
							}
							else break;
						}
						if(cnt==5) {
							System.out.println(map[i][j]);
							if(dx[z]==1&&dy[z]==-1) {
								System.out.println((i+1+4)+" "+(j+1-4));
								return;
							}
							System.out.println((i+1)+" "+(j+1));
							return ;
						}
					}
				}
			}
		}
		System.out.println(0);
	
	}
}