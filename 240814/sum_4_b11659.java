import java.util.Scanner;

public class sum_4_b11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int [] sumarr= new int[N+1];
		for(int i=1;i<=N;i++) {
			sumarr[i]=sumarr[i-1]+sc.nextInt();  //누적 합을 배열로 입력
		}
		for(int k=0;k<M;k++) {
			int i=sc.nextInt(); //시작 지점
			int j=sc.nextInt();//끝 지점
			System.out.println(sumarr[j]-sumarr[i-1]);// 마지막 지점 누적 합- 시작 지점 전(i-1)의 누적 합 
		}
		
	}
}
