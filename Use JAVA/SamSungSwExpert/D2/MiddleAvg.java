package D2;

import java.util.Scanner;
import java.util.Arrays;
public class MiddleAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double answer =0.0;
        int[] arr = new int[10];
        for(int i=1; i<=t; i++){
            Arrays.fill(arr,0);             // 배열값 초기화
            for(int x=0; x<10; x++){        // 배열 생성
            	arr[x] = sc.nextInt();
            }
            Arrays.sort(arr);               //오름차순 정렬
            for(int y=1; y<=8; y++){        //배열 크기가 10고정이므로 앞 뒤 제외하고 값 저장
            	answer +=arr[y];
            }
            answer /=8.0;                   
            System.out.printf("#%d %.0f\n",i,answer);
            answer = 0.0;
        }
        sc.close();
    }
}
/*
입력
3      
3 17 1 39 8 41 2 32 99 2 
22 8 5 123 7 2 63 7 3 46 
6 63 2 3 58 76 21 33 8 1  

출력
#1 18
#2 20
#3 24

*/