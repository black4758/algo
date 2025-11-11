package main.java._2025_11_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans = queue.poll();
            if (!queue.isEmpty()) {
                int next = queue.poll();
                queue.add(next);
            }
        }
        System.out.println(ans);
    }
}
