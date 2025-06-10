public class SumBetweenTwoIntegers {
    public long solution(int a, int b) {
        int min=0;
        int max=0;
        if(a>b){
            min=b;
            max=a;
        }
        else if(a<b){
            min=a;
            max=b;
        }
        else return a;
        long answer = 0;
        for(int i=min;i<=max;i++){
            answer+=i;
        }
        return answer;
    }
}
