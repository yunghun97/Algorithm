package Programmers.Lv3;

public class n2타일링 {
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        if(n<=3){
            return arr[n];
        }else{
            for(int i=4; i<=n; i++){
                arr[i] = (arr[i-1]+arr[i-2]) % 1000000007;
            }
            return arr[n];
        }                
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/12900