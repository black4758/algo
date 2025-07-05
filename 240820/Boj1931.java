package main.java._2025_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1931 {
    static class Time{
        int start;
        int end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        Time[] times = new Time[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i]=new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(times,(o1,o2)->o1.end!=o2.end ? o1.end-o2.end:o1.start-o2.start);
        int cnt=0;
        int end=0;
        for (int i = 0; i < N; i++) {
            if(end<=times[i].start) {
                cnt++;
                end=times[i].end;
            }
        }
        System.out.println(cnt);
    }
}
