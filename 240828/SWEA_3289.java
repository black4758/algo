import java.util.Scanner;

public class SWEA_3289 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int Tc=sc.nextInt();
		for(int t=1;t<=Tc;t++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			arr= new int[n+1];
			System.out.print("#"+t+" ");
			for(int i=0;i<m;i++) {
				int st=sc.nextInt();
				int a=sc.nextInt();
				int b=sc.nextInt();
				if(st==0) {
					union(a,b);
				}
				if(st==1) {
					
					if(findeSet(a)==findeSet(b)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	 static int  findeSet(int a){
		if(arr[a]==0)return a;
		return arr[a]=findeSet(arr[a]);
	}
	static boolean union(int a, int b) {
		int aroot=findeSet(a);
		int broot=findeSet(b);
		if(aroot==broot) return false;
		arr[broot]=aroot;
		return true;
	}
}
