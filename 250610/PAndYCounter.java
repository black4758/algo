public class PAndYCounter {
    boolean solution(String s) {
        s=s.toLowerCase();
        boolean answer = true;
        int pcnt=0;
        int ycnt=0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='p') {
                pcnt++;
            }
            else if(s.charAt(i)=='y') {
                ycnt++;
            }
        }
        if(pcnt!=ycnt) {
            answer = false;
        }
        return answer;
    }
}
