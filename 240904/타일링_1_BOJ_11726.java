import java.util.Scanner;

public class 타일링_1_BOJ_11726 {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr= new int[N+3];
		arr[1]=1;
		arr[2]=2;
		for (int i = 3; i <= N; i++) {
			arr[i]=(arr[i-2]+arr[i-1])%10007;
			
		}
		System.out.println(arr[N]);
	}
}