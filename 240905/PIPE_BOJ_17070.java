import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PIPE_BOJ_17070 {
	static int N,map[][],an=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());

		map= new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,1);
		System.out.println(an);
	}
	private static void dfs(int x, int y, int dir) {
		// dir 가로 1 세로 2 대각선 3
		if(x==N-1&&y==N-1) {
			an++;
			return ;
		}
		if(dir==1||dir==3) {
			if(y+1<N && map[x][y+1]!=1) {
				dfs(x,y+1,1);
			}
		}
		if(dir==2||dir==3) {
			if(x+1<N && map[x+1][y]!=1) {
				dfs(x+1,y,2);
			}
		}
		if(x+1<N &&y+1<N && map[x+1][y+1]!=1 && map[x+1][y]!=1&& map[x][y+1]!=1)  {
			dfs(x+1,y+1,3);
		}
	}
}
