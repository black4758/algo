import java.util.Scanner;

public class bac_B3040 {
	static int[] arr,rearr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		rearr=new int[7];
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		johab(0,0);
	}
	//풀이법 조합으로 모든 경우의 수를 구한 뒤 합이 100인 것을 구하기
	private static void johab(int cnt, int st) {
		if(cnt==7) {
			int answer=0;
			for(int i=0; i<7;i++) {
				answer=answer+rearr[i];
			}
			if(answer==100) { //합이 100이면 출력
				for(int i=0; i<7;i++) {
					System.out.println(rearr[i]);
				}
			}
			return;
		}
		for(int i=st; i<9;i++) {
			rearr[cnt]=arr[i];
			johab(cnt+1,i+1);
		}
	}
}
