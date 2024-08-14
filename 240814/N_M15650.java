import java.util.Scanner;

public class N_M15650 {
	static int[] inputarr;
	static int M;
	static int N;
	//풀이법 조합을 이용하여 풀이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		inputarr = new int[N];
		johab(0,1);
	}
	private static void johab(int cnt, int st) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				System.out.print(inputarr[i]+" ");
			}
			System.out.println();
			return ;
		}
		for(int i=st;i<=N;i++) {
			inputarr[cnt]=i;
			johab(cnt+1,i+1);
		}
		
	}
}
