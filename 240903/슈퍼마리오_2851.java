import java.util.Scanner;

public class 슈퍼마리오_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr=new int[11];
		int sw=0;
		for(int i=0;i<10;i++) {
			if(i==0)arr[i]=sc.nextInt();
			else arr[i]=arr[i-1]+sc.nextInt();
			if(arr[i]>=100&& sw==0) sw=i;
		}
		int an=0;
		if(sw !=0) {
			if(arr[sw]==100) an=100;
			else {
				if(100-arr[sw-1]==arr[sw]-100) an=arr[sw];
				else if(100-arr[sw-1]<arr[sw]-100) an=arr[sw-1];
				else an=arr[sw];
			}
		}
		else an=arr[9];
		System.out.println(an);
		
	}
}
