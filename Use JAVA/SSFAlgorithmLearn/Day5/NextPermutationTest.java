package SSFAlgorithmLearn.Day5;

import java.util.Arrays;

public class NextPermutationTest{
    public static void main(String[] args) {
        int[] input = {7,1,4,6};
        Arrays.sort(input);


        do{
            //순열 사용
            System.out.println(Arrays.toString(input));
        }while(np(input));  // false 가 나올때 까지 돌리겠다.
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
