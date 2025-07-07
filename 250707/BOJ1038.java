package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1038 {
    static List<Long> list = new ArrayList<Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            solution(i);
        }
        list.sort(Long::compareTo);
        if (list.size() <= N) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(N));
        }
    }
    public static void solution(long num) {
        list.add(num);

        long last = num %10;

        for (long i = 0; i < last; i++) {
            long newNum = (num*10)+i;
            solution(newNum);
        }
    }
}
