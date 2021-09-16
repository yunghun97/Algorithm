package SSFAlgorithmLearn.Day11;

import java.util.Scanner;

public class DP_LISTest1 { // 시간 복잡도 N^2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 원소 개수
        int[] arr = new int[N]; // 원소 배열
        int[] LIS = new int[N]; 
        
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int max =0;
        for(int i=0; i<N; i++){
            LIS[i] = 1; // 본인 길이 1이므로
            for(int j=0; j<i; j++){ // j : i의 앞쪽 원소
                if(arr[j]<arr[i] && LIS[j]+1>LIS[i]){
                    LIS[i] = LIS[j]+1;
                }
            }
            max = Math.max(max,LIS[i]);
        }
        System.out.println(max);
        sc.close();
    }
}
