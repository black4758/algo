import java.util.Scanner;

public class jibhab_B_11723 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M=sc.nextInt();
		String giho;
		StringBuilder br = new StringBuilder();
		int num=0;
		int s=0;
		for(int i=0;i<M;i++) {
			 giho=sc.next();
			 if(giho.equals("all")) {
				 s= s|(1<<21)-1; //모든 숫자가 1이니 1을 21한 쉬프트 한뒤 1뺀다
			 }
			 else if(giho.equals("empty")) {
				 s=0;
			 }
			 else {
					num=sc.nextInt();
					if(giho.equals("add")) {
						s= s|(1<<num);
					}
					else if(giho.equals("check")) {
						br.append((s&(1<<num)) !=0 ? 1:0).append("\n");
					}
					else if(giho.equals("remove")) {
						s= s&~(1<<num);
					}
					else if(giho.equals("toggle")) {
						s= s^(1<<num);
					}
			 }

		}
		System.out.println(br);
	}
}
