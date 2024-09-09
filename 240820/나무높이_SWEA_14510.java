import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

import java.util.LinkedList;

import java.util.StringTokenizer;

public class 나무높이_SWEA_14510 {
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N= Integer.parseInt(br.readLine());
			int[] map = new int[N];
			int max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i]=Integer.parseInt(st.nextToken());
				if(map[i]>max) {
					max=map[i];
				}
			}
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				if(max != map[i]) {
					list.add(map[i]);
				}
			}
			int day=0;
			Collections.sort(list,Collections.reverseOrder());
			while(!list.isEmpty()) {	
				day++;
				for (int i = 0; i < list.size(); i++) {
					if(day%2 ==0 && max -list.get(i) !=1) {
						int now= list.get(i)+2;
						list.remove(i);
						if(now != max) list.add(now);
						break;
					}
					if( day%2 ==1 &&(max- list.get(i) !=2 || list.size()>=2)) {
						int now= list.get(i)+1;
						list.remove(i);
						if(now != max) list.add(now);
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+day);
		}
	}
}
