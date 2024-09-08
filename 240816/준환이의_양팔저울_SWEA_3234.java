import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 준환이의_양팔저울_SWEA_3234 {
	static int map[],solArr[],N,answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			N= Integer.parseInt(br.readLine());
			map = new int[N];
			solArr= new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i]=Integer.parseInt(st.nextToken());
			}
			answer=0;
			sunyal(0,new boolean[N]);
			System.out.println("#"+tc+ " "+answer);
		}
	}
	private static void sunyal(int cnt, boolean[] visited) {
		
		if(cnt==N) {
			unSet(0,0,0);
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				solArr[cnt]=map[i];
				sunyal(cnt+1, visited);
				visited[i]=false;
			}
		}
	}
	private static void unSet(int cnt, int left, int right) {
		if(right>left) {
			return;
		}
		if(cnt==N) {
			answer++;
			return;
		}
		unSet(cnt+1, left+solArr[cnt], right);
		unSet(cnt+1, left, right+solArr[cnt]);
	}
}