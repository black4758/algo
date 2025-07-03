import java.util.Scanner;

public class Number_SW4008 {
    static int[] operatorCounts;
    static int[] numbers;
    static int max, min, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();

            operatorCounts = new int[4]; // 0:+, 1:-, 2:*, 3:/
            numbers = new int[N];

            for (int i = 0; i < 4; i++) {
                operatorCounts[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                numbers[i] = sc.nextInt();
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            // 3. 새로운 방식의 재귀 함수 호출
            solve(numbers[0], 1);

            System.out.println("#" + t + " " + (max - min));
        }
    }

    public static void solve(int currentResult, int numberIndex) {
        if (numberIndex == N) {
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }

        for (int op_type = 0; op_type < 4; op_type++) {
            if (operatorCounts[op_type] > 0) {
                operatorCounts[op_type]--;

                int nextResult = 0;
                if (op_type == 0)      nextResult = currentResult + numbers[numberIndex];
                else if (op_type == 1) nextResult = currentResult - numbers[numberIndex];
                else if (op_type == 2) nextResult = currentResult * numbers[numberIndex];
                else if (op_type == 3) nextResult = currentResult / numbers[numberIndex];

                // 다음 숫자를 계산하기 위해 재귀 호출
                solve(nextResult, numberIndex + 1);

                // 백트래킹: 사용했던 연산자 원상 복구
                operatorCounts[op_type]++;
            }
        }
    }
}
