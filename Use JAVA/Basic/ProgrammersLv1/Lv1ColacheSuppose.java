package Basic.ProgrammersLv1;
import java.util.Scanner;
public class Lv1ColacheSuppose {
    public static void main(String[] args) {
        Colache colache = new Colache();
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();
        int answer = colache.solution(n);
        System.out.println(answer);

    }
}
class Colache{
    int solution(Long input){
        int count =0;
        int answer ;
        while(input!=1){
            if(count==500){
                count=-1;
                break;}
            if(input%2==0){
                input/=2;
                count++;
            }
            else{
                input = input*3+1;
                count++;
            }
            
        }
        answer = count;
        return answer;
    }
}
