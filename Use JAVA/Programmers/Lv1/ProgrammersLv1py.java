package Programmers.Lv1;
public class ProgrammersLv1py {
    public static void main(String[] args) {
        String s = "P";
        String temp1;
        String temp2;
        boolean answer = true;
        int yCount =0;
        int pCount =0;
        temp1 = s.replace("P","p");
        temp2 = temp1.replace("Y","y");
        for(int i=0; i<temp2.length(); i++){
            if(temp2.charAt(i) =='p')
                ++pCount;
            else if(temp2.charAt(i)=='y')
                ++yCount;
        }
        System.out.println(pCount);
        if(pCount!=yCount)
            answer = false;
        else
            answer = true;
        System.out.println(answer);
    }
}
