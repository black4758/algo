import java.util.Scanner;

public class roll_BJ3985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L=sc.nextInt();
		int N=sc.nextInt();
		int[] arr = new int[L+1];
		int max=0,pep=0,finalp=0;
		for(int i=1;i<=N;i++) {
			int st= sc.nextInt();
			int fn= sc.nextInt();
			if(max<fn-st+1) {
				max=fn-st+1;
				pep=i;
			}
			if(max==fn-st+1) {
				pep=Math.min(pep, i);
			}
			for(int j=st;j<=fn;j++) {
				if(arr[j]==0) {
					arr[j]=i;
				}
			}
		}
		max=0;
		for(int i=1;i<=N;i++) {
			int cnt=0;
			for(int j=1;j<=L;j++) {
				if(arr[j]==i) {
					cnt++;
				}
			}
			if(cnt>max) {
				max=cnt;
				finalp=i;
			}
			if(cnt==max) {
				finalp=Math.min(finalp, i);
			}
		}

		System.out.println(pep);
		System.out.println(finalp);
	}

}
