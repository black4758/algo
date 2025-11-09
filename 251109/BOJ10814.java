package main.java._2025_11_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10814 {
    static class Name {
        int id;
        String name;
        public Name(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        List<Name> names = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            names.add(new Name(id,name));
        }
        names.sort((o1, o2) -> o1.id-o2.id);
        StringBuilder sb = new StringBuilder();
        for (Name name : names) {
            sb.append(name.id).append(" ").append(name.name).append("\n");
        }
        System.out.println(sb.toString());
    }

}
