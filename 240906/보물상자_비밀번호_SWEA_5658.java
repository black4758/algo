
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 보물상자_비밀번호_SWEA_5658 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N= Integer.parseInt(st.nextToken());
			int K= Integer.parseInt(st.nextToken());
			LinkedList<Integer> list = new LinkedList<>();
			
			String input =br.readLine();
			for (int i = 0; i < N/4; i++) {
				for (int j = 0; j < 4; j++) {
					String now= input.substring((N/4)*j,(N/4)*(j+1));
					int notToint=Integer.parseInt(now,16);
					if(!(list.contains(notToint))) {
						list.add(notToint);
					}
				}
				input=input.charAt(N-1)+input.substring(0,N-1);
			}
			Collections.sort(list,Collections.reverseOrder());
			
			System.out.println("#"+ tc+" "+list.get(K-1));
		}
	}
}
