import java.util.Scanner;

public class dong_JO1183 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
       
        
  		int n = in.nextInt();
  
  		int[] coins = new int[6];
  		for(int i = 0; i < 6; i++) {
  			coins[i] = in.nextInt();
  		}
	
  		int[] money = { 500, 100, 50, 10, 5, 1 };

  		int max = 0;

  		for(int i = 0; i < 6; i++ ) {
  			max += money[i] * coins[i];
  		}

  		max -= n;

  		int index = 0;

  		while(true) {
  			if(max <= 0) {
  				break;
  			}

  			if(coins[index] == 0 || max < money[index]) {
  				index++;

  				continue;

  			}

  			max -= money[index];
  			coins[index]--;
  		}
  		int sum = 0;
  		for(int i=0;i<6;i++) {
  			sum += coins[i];
  		}
  		System.out.println(sum);

  		
  		for(int i=0;i<6;i++) {
  			System.out.printf("%d ", coins[i]);
  		}
	}

}
