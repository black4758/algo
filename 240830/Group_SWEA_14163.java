import java.util.Scanner;

public class Group_SWEA_14163 {
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N=sc.nextInt();
			int M= sc.nextInt();
			arr= new int[N+1];
			for(int i=0;i<M;i++) {
				union(sc.nextInt(),sc.nextInt());
			}
			int count=0;
			for(int i=1;i<=N;i++) {
				if(arr[i]==0) count++;
			}
			System.out.println("#"+tc+" "+count);
		}
	}
	private static void union(int a, int b) {
		int aRoot= find(a);
		int bRoot= find(b);
		if(aRoot!=bRoot) {
			arr[bRoot]=aRoot;
		}
		
	}
	static int find(int a) {
		if(arr[a]==0) return a;
		return arr[a]=find(arr[a]);
		
	}
}
