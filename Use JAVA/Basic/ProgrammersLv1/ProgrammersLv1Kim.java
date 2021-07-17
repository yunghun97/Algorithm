public class ProgrammersLv1Kim {
    public static void main(String[] args) {
        String[] seoul = {"asdas","131","Gwon","Kim"};
        String answer = "";
        String Kim = "Kim";
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals(Kim))
                answer = "김서방은 " +i+"에 있다";
        }
        System.out.println(answer);
    }
}
