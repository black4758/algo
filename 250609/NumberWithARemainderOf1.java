class NumberWithARemainderOf1 {
    public int solution(int n) { // 1. 올바른 메서드 시그니처로 변경
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        // 1. 테스트할 Solution 객체를 생성합니다.
        NumberWithARemainderOf1 sol = new NumberWithARemainderOf1();
        System.out.println(sol.solution(3));

    }
}