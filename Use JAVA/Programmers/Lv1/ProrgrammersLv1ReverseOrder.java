package Programmers.Lv1;
import java.util.*;
public class ProrgrammersLv1ReverseOrder{
    public static void main(String[] args) {
        Long n = 12378945678L;
        List<Character> lc = new ArrayList<Character>();
        long answer;
        String a= "";
        String i = String.valueOf(n); 
        char[] cs = i.toCharArray();
        for(int x=0; x<cs.length; x++){
            lc.add(cs[x]);
        }
        Collections.sort(lc, Collections.reverseOrder());
        for(int x=0; x<lc.size(); x++){
            a +=lc.get(x);    
        }
        answer = Long.parseLong(a);
        System.out.println(answer);
    }
}