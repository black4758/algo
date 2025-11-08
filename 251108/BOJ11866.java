package main.java._2025_11_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11866  {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        sb.append("<");
        int now=0;
        while (!list.isEmpty()) {
            now=(now+k-1)%list.size();
            sb.append(list.remove(now));
            if(!list.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.print(sb.toString());
    }
}
