import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Music_program_BOJ_2623 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M= sc.nextInt();
		ArrayList<Integer>[] arr= new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		int[] count = new int[N+1];
		for(int i=0;i<M;i++) {
			int num=sc.nextInt();
			int first= sc.nextInt();
			for(int j=0;j<num-1;j++) {
				int next= sc.nextInt();
				arr[first].add(next);
				count[next]++;
				first=next;
			}
		}
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(count[i]==0) {
	            if (count[i] == 0) {
	                queue.offer(i);
	            }
			}
		}
		
		ArrayList<Integer> an= new ArrayList<>();
		while (!queue.isEmpty()) {
			int now= queue.poll();
			an.add(now);
			for(int idx:arr[now]) {
				count[idx]--;
				if(count[idx]==0) {
					queue.add(idx);
				}
			}
		}
		if(an.size()!=N)System.out.println(0);
		else {
			for(int cnt : an ) {
				System.out.println(cnt);
			}
		}
	}
}
