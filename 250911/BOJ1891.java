import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1891 {
    static long size;

    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String number = st.nextToken();
        st = new StringTokenizer(br.readLine());
        long dy = Long.parseLong(st.nextToken());
        long dx = Long.parseLong(st.nextToken());

        size= (long)Math.pow(2,number.length());
        long[] now = find(number);
        long nx=now[0]+dx*-1;
        long ny=now[1]+dy;
        if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
            System.out.println(-1);
        } else {
            System.out.println(find2(nx, ny, d));
        }
    }
    static long[] find(String number) {
        long x = 0, y = 0;
        long half = size / 2;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '1') {
                y += half;
            } else if (c == '2') {

            } else if (c == '3') {
                x += half;
            } else if (c == '4') {
                x += half;
                y += half;
            }
            half = half / 2;
        }
        return new long[] {x, y};
    }
    static String find2(long x, long y, int d) {
        StringBuilder sb = new StringBuilder();
        if (d == 0) return "";

        long half = (long)Math.pow(2,d-1);
        for (int i = 0; i < d; i++) {
            char num;
            if (x < half && y < half) num = '2';
            else if (x < half && y >= half) {
                num = '1';
                y -= half;
            }
            else if (x >= half && y < half) {
                num = '3';
                x -= half;
            }
            else {
                num = '4';
                x -= half;
                y -= half;
            }
            sb.append(num);
            half /= 2;
        }
        return sb.toString();
    }
}
