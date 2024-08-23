
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class sangho_SW_1873
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int H,W,x=0,y=0;
			H=sc.nextInt();
			W=sc.nextInt();
			char[][] map= new char[H][W];
			for(int i=0;i<H;i++){
				String s= sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j]=s.charAt(j);
					if (map[i][j] == '>' || map[i][j] == '^' || map[i][j] == '<' || map[i][j] == 'v') {
						x = i;
						y = j;
					}
				}
			}
			int moveCount =sc.nextInt();
			String inputString= sc.next();
			int nowCount=0;
			while (nowCount != moveCount) {
				int start = map[x][y];
				if (inputString.charAt(nowCount)== 'S') {
					if (start == '>') {
						for (int i = y+1; i < W; i++) {
							if (map[x][i] == '*') {
								map[x][i] = '.';
								break;
							}
							if (map[x][i] == '#') {
								break;
							}
						}
					}
					if (start == '<') {
						for (int i = y-1; i >= 0; i--) {
							if (map[x][i] == '*') {
								map[x][i] = '.';
								break;
							}
							if (map[x][i] == '#') {
								break;
							}
						}
					}
					if (start == 'v') {
						for (int i = x+1; i < H; i++) {
							if (map[i][y] == '*') {
								map[i][y] = '.';
								break;
							}
							if (map[i][y] == '#') {
								break;
							}
						}
					}
					if (start == '^') {
						for (int i = x-1; i >= 0; i--) {
							if (map[i][y] == '*') {
								map[i][y] = '.';
								break;
							}
							if (map[i][y] == '#') {
								break;
							}
						}
					}
				}
				else if (inputString.charAt(nowCount)== 'U') {
					if (x > 0 && map[x - 1][y] == '.') {
						map[x][y] = '.';
						x--;
					}
						map[x][y] = '^';
				}
				else if (inputString.charAt(nowCount) == 'D') {
					if (x < H-1 && map[x + 1][y] == '.') {
						map[x][y] = '.';
						x++;
					}
						map[x][y] = 'v';
				}
				else if (inputString.charAt(nowCount)== 'L') {
					if (y > 0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						y--;
					}
						map[x][y] = '<';
				}
				else if (inputString.charAt(nowCount)== 'R') {
					if (y < W-1 && map[x][y+1] == '.') {
						map[x][y] = '.';
						y++;
					}
						map[x][y] = '>';
				}
				nowCount++;
			}
			System.out.print("#"+test_case+" ");
			for(int i=0;i<H;i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}