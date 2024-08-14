package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Baby_Gin {
	static int arrre[];
	static boolean ch[];
	static int cl=0;
	public static void main(String[] args) {
		//순열로 모든 걍우의 수를 구한 후 베이비진 인지 구하기
		Scanner sc= new Scanner(System.in);
		arrre= new int[6];
		ch= new boolean[6];
		int[] arr= new int[6];
		String input =sc.next();
		for(int i=0;i<6;i++) {
			arr[i]=input.charAt(i)-'0';
		}
		sun(arr,0);
		if(cl==2)
			System.out.println("true");
		else {
			System.out.println("no");
		}
	}
	static	void Baby_gin(int[] arr ) {
		cl=0;
		if(arr[0]== arr[1] &&arr[1]==arr[2]) {
			cl++;
		}
		if(arr[3]== arr[4] &&arr[4]==arr[5]) {
			cl++;
		}
		if(arr[0]== arr[1]-1 &&arr[1]==arr[2]-1) {
			cl++;
		}
		if(arr[3]== arr[4]-1 &&arr[4]==arr[5]-1) {
			cl++;
		}

		
	}
	static void sun(int[] arr,int temp) {
		if(temp==6) {
			Baby_gin(arrre);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!ch[i]) {
				ch[i]=true;
				arrre[temp]=arr[i];
				sun(arr,temp+1);
				ch[i]=false;
			}
		}
	}
}
