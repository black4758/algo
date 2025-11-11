package main.java._2025_11_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int now: list) {
            sb.append(now).append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}
