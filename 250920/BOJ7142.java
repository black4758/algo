public class BOJ7142 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("101\n");

        for (int i = 0; i < 101; i++) {
            sb.append("0\n");
        }

        sb.append("1\n");

        sb.append("0 1\n");

        System.out.print(sb.toString());
    }
}
