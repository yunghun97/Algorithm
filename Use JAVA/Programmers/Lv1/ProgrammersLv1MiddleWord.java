package Programmers.Lv1;
public class ProgrammersLv1MiddleWord {
    public static void main(String[] args) {
        // String s = "abcde";
        String s = "1a2a3a4a";
        int a = s.length();
        int i = s.length()/2;
        String answer;
        if(a%2==0){
            answer = s.substring(i-1,i+1);
        }
        else{
            answer = s.substring(i,i+1);
        }
        System.out.println(answer);
    }
    
}
