import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N_M_B15649 { //순열 이용
	static int [] selected;
	static boolean[] isSelected;
	static int N;
	static int M;
	static StringBuffer answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer= new StringBuffer();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected =new int[M];
		isSelected = new boolean[N];
		peremutation(0);
		System.out.println(answer);
	}

	private static void peremutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				answer.append(selected[i] + " ");
			}
			answer.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}
			selected[cnt] = i+1;
			isSelected[i] = true;
			peremutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	
}
