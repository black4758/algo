
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class SW_1218
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		//구동 방법 열리는 괄호는 스택에 저장 후 열리는 괄호가 오면 스택에서 꺼내 비교를 한다
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			Stack<Character> stack = new Stack<>();
			 int N= sc.nextInt();
			 String input=sc.next();
			 int sw=0; // 정답을 출력하기 위한 인자
			 for(int i=0;i<N;i++) {
				
				 if(input.charAt(i)=='<'||input.charAt(i)=='('||input.charAt(i)=='['||input.charAt(i)=='{') {
					 stack.add(input.charAt(i)); // 열리는 괄호 스택 추가
				 }
				 else { //닫히는 괄호가 오면 스택에서 꺼내 비교
					 int out=stack.pop();
					 if(input.charAt(i)=='>') {
						 if(out !='<') {
							 sw=1;
							 break;
						 }
					 }
					 if(input.charAt(i)=='}') {
						 if(out !='{') {
							 sw=1;
							 break;
						 }
					 }
					 if(input.charAt(i)==')') {
						 if(out !='(') {
							 sw=1;
							 break;
						 }
					 }
					 if(input.charAt(i)==']') {
						 if(out !='[') {
							 sw=1;
							 break;
						 }
					 }
				 }
			 }
			 System.out.print("#"+test_case+" ");
			 if(sw==1) System.out.println(0); //SW가 0이면 정상
			 else System.out.println(1);
		}
		
	}
}