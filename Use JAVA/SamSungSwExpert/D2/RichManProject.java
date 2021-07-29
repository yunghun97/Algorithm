package SamSungSwExpert.D2;

import java.util.Scanner;
public class RichManProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            long answer =0;                             // 입력 크기가 크므로 long으로 해야 오류가 안난다.
            long gap =0;
            long max =0;
        	int size = sc.nextInt();
          	int[] arr = new int[size];
            for(int i=0; i<arr.length; i++){
            	arr[i] = sc.nextInt();
            }
            max = arr[size-1];                          // 가장 마지막 값을 max로 우선 설정후 역 순 탐색 진행
            for(int j=size-2; j>=0; j--){               //  max보다 작으면  max와 그 숫자 차이를 더해준다
            	if(arr[j]<max){
                    gap = max-arr[j];
                    answer +=gap;}
                else { max = arr[j];                // 새로운 max값을 설정해주고 gap을 0으로 초기화 시켜준다.
                                 gap = 0;}
               
            }
            System.out.printf("#%d %d\n",t,answer);
        }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc