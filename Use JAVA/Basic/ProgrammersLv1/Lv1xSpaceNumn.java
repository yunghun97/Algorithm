package Basic.ProgrammersLv1;

public class Lv1xSpaceNumn {
    public static void main(String[] args) {
        int x= 100; int n = 50;
        long[] answer = new long[n];
        long num = x;
        for(int i=0; i<n; i++){
            answer[i] = num;
            num+=x;
        }
        for(long n2 : answer){
            System.out.print(n2+" ");
        }
    }
}
