import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class gi_SW_6808 {
	static int gArr[];
	static int win;
	static int lose;;
	static boolean isVisited[];
	static int iArr[];
	static int iVisitedArr[]; //순열에 사용될 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			gArr = new int[9];
			iArr=new int[9];
			iVisitedArr=new int[9];
			win=0;
			lose=0;
			isVisited = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				isVisited[gArr[i]] = true;
			}
			int cnt=0;
			for (int i = 1; i < 19; i++) {
				if (!isVisited[i]) {
					iArr[cnt++]=i;
				}
			}
			permutation(0);
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}
	private static void permutation(int cnt) {
		if (cnt==9) {
			int iScore=0;
			int gScore=0;
			for (int i = 0; i < 9; i++) {
				if(gArr[i]>iVisitedArr[i]) {
					gScore+=gArr[i]+iVisitedArr[i];
				} else if (gArr[i]<iVisitedArr[i]) {
					iScore+=gArr[i]+iVisitedArr[i];
				}
			}
			if(gScore>iScore) {
				win++;
			}
			else if(gScore<iScore) {
				lose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isVisited[iArr[i]]) {
				continue;
			}
			isVisited[iArr[i]] = true;
			iVisitedArr[cnt]=iArr[i];
			permutation(cnt+1);
			isVisited[iArr[i]] = false;
		}
	}
}
