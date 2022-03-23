package Programmers.Lv1;

public class Lv1HarShadNum {
    public static void main(String[] args) {
        
    
    int x = 13;
    boolean answer = false;
    int nSum =0;
    int input = x;
    while(input>0){
        nSum += input%10;
        input/=10;
    }
    if(x%nSum==0){
        answer = true;
    }
    System.out.println(answer);
    }
}
