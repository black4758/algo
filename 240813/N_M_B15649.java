

import java.util.Scanner;

public class N_M_B15649 {
	//순열 이용
	static int[] arr;
	static boolean [] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr= new int[M];
		ch= new boolean[N];
		sunyal(N,M,0);
	}
	private static void sunyal(int N,int M, int tm) {
		if(tm==M) {
			for(int i=0;i<M;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!ch[i]) {
				ch[i]=true;
				arr[tm]=i+1;
				sunyal(N,M,tm+1);
				ch[i]=false;
			}
		}
	}
	
}
