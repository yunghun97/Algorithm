package SSFAlgorithmLearn.Day5;
import java.util.*;
public class NextCombinationTest{
    public static void main(String[] args) {
        int[] input = {7,1,4,2,3};
        int N= input.length;
        int R = 2;
        int[] p = new int[N];
        //Arrays.sort(input);
        /*for(int i=p.length-1; i>p.length-R;i--){    //뒤에서 부터 뽑을 갯수 만큼 1넣기
            p[i] = 1;
        }*/
        int cnt = 0; while(++cnt<=R) p[N-cnt] =1;
        Arrays.sort(input);
        do{
            for(int i=0; i<N; i++){
                if(p[i]==1){System.out.print(input[i]+" ");}
            }
            System.out.println();
        }while(np(p));  // 0,1로 채워진 배열을 매개변수로 사용한다.!
    }
    //다음 큰 순열이 있으면 true 없으면 false;
    private static boolean np(int[] numbers){
        int N = numbers.length;
        
        // step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
        int i = N-1;
        while(i>0&& numbers[i-1]>=numbers[i]){
            --i;}
        if(i==0){return false;} // -> 맨 앞 절벽이므로 false 리턴

        // step2. i-1 위치값과 교환할 큰 값을 찾는다.
        int j = N-1;
        while(numbers[i-1]>=numbers[j]){
            --j;}
        
        //step3 i-1위치값과 j 위치값 교환
        swap(numbers,i-1, j);
        
        // step4. 꼭대기(i)부터 맨뒤 까지 내림차순형태의 순열을 오름차순으로 처리
        int k = N-1;
        while(i<k){
            swap(numbers, i++, k--);
        }
        return true;
    }
    private static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
