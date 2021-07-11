public class ProgrammersLv1DotProduct {
    public static void main(String[] args){
            Solution4 soul4 = new Solution4();
            int[] a = {1,2,3,4};
            int[] b = {-3,-1,0,2};
            int answer = 0;
            answer = soul4.solution4(a, b);
            System.out.print(answer);
    }
}
class Solution4 {
    public int solution4(int[] a, int[] b) {
        int answer = 0;
        for(int i =0; i<a.length;i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}