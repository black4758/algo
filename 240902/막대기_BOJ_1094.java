import java.util.Scanner;

public class 막대기_BOJ_1094 {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N= sc.nextInt();
		 int now=64;
		 int count=1;
		 while(!(N==now)) {
			 if(now>N) {
				 now=now/2;
			 }
			 if(now<N) {
				 N=N-now;
				 count++;
			 }
		 }
		 System.out.println(count);
	}
}
