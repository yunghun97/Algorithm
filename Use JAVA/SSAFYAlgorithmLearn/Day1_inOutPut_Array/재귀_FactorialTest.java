package SSAFYAlgorithmLearn.Day1_inOutPut_Array;

public class 재귀_FactorialTest {
    private static int factorial(int n){
        if(n==1) return n;
        
        return n * factorial(n-1);
    }
    private static int factorial2(int n){
        int answer =1;
        for(int i=10; i>0; i--){
            answer *= i;
        }
        return answer;
    }
    private static int res = 1;
    private static void factorial3(int i){
        if(i==1) {return;}
        res *=i;
        factorial3(i-1);
    }
    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        System.out.println(factorial(10));
        long b2 = System.currentTimeMillis();
        System.out.println(factorial2(10));
        System.out.println(b2-a1);
        long c3 = System.currentTimeMillis();
        System.out.println(c3-b2);
    }
}
