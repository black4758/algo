import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;


public class pass_SW_1225
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            T=sc.nextInt();
			Queue<Integer> qu =new LinkedList<>();
			for(int i=0;i<8;i++) {
				qu.add(sc.nextInt());
			}
			int pop=-1;
			int ma=-1;
			while(pop !=0) {
				pop=qu.poll();
				if(ma%6==0) { //5까지 하고 6에 -1로 리셋
					ma=-1;	
				}
				pop=pop+ma;
				ma--;
				if(pop<0)pop=0; //0보다 작으면 0으로
				qu.add(pop);
			}
			System.out.print("#"+test_case+" ");
			while(!qu.isEmpty()) {
				System.out.print(qu.poll()+" ");
			}
			System.out.println();
		}
	}
}