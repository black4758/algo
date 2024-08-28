import java.util.Scanner;

public class SWEA_7465 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			arr=new int [N+1];
			
			for(int i=0;i<M;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				union(a,b);
			}
			int an=0;
			for(int i=1;i<=N;i++) {
				if(arr[i]==0) an++;
			}
			System.out.println("#"+tc+" "+an);
		}

	}
	private static int find(int a) {
		if(arr[a]==0) return a;
		return arr[a]=find(arr[a]);
	}
	
	private static void union(int a, int b) {
		int aroot=find(a);
		int broot=find(b);
		if(!(aroot==broot)) {
			arr[broot]=aroot;
		}
	}
}
