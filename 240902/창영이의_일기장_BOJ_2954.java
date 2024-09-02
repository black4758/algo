import java.util.Scanner;

public class 창영이의_일기장_BOJ_2954 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input =sc.nextLine();

        input = input.replaceAll("apa", "a").replaceAll("epe", "e")
                .replaceAll("ipi", "i").replaceAll("opo", "o").replaceAll("upu", "u");
		System.out.println(input);

	}
}
