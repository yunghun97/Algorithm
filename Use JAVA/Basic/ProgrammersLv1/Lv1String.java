package Basic.ProgrammersLv1;

public class Lv1String {
    public static void main(String[] args) {
        String s= "1a654";
        boolean answer = true;
        if(s.length()==4||s.length()==6){
        try{int a = Integer.parseInt(s);
        }catch(NumberFormatException e){
            answer = false;
            throw e;
        }finally{
            System.out.println(answer);
        }
        }
        else{
            answer = false;
            System.out.println(answer);
        }
    }
}
