package Basic.ProgrammersLv1;

public class Lv1FindDemical {
    public static void main(String[] args) {
        SolutionDemical Sol = new SolutionDemical();
        int number = 10;
        System.out.printf("소수의 갯수는 %d개 입니다.",Sol.solution(number));
    }
}
class SolutionDemical {
    public int solution(int n) {
      int answer = 0;
      int[] numbers = new int[n+1];
   
      for(int i=2; i<=n; i++) numbers[i]=i;
   
        for(int i=2; i<n; i++) {
   
          if(numbers[i] == 0) continue;
   
          for(int j=2*i; j<=n; j+=i) numbers[j] = 0;
        }
   
        for(int i=0; i<numbers.length; i++) {
   
          if(numbers[i] != 0) answer++;
        }
   
      return answer;
    }
  }