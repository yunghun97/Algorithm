package SamSungSwExpert.D2;
import java.util.Scanner;
public class TwoNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
        	int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int[] arr1 = new int[num1];
            int[] arr2 = new int[num2];
            int answer =0;
            int temp=0;

            for(int i=0; i<num1; i++){
            	arr1[i] = sc.nextInt();
            }
              for(int j=0; j<num2; j++){
            	arr2[j] = sc.nextInt();
            }
            if(num1==num2){             // 같으면 그냥 곱해서 더하면 됨.
            	for(int a=0; a<num1; a++){
                    answer +=(arr1[a]*arr2[a]);             
                }
            }
            else if(num1>num2){                 // 크기가 다르면 크기가 다른 만큼 이동 가능하므로 크기다른만큼+1번 계산이 가능하다.
                for(int q1=0; q1<=num1-num2; q1++){     // 크기차이 +1 만큼 반복
                    for(int w1=0; w1<num2; w1++){
                        temp += arr1[w1+q1]*arr2[w1];   // 처음부터 시작해서 오른쪽으로 1칸씩 미는것을 나타내기 위해 작은 배열에 +q1해준다.
                    }
                    if(temp>answer){answer = temp; temp=0;}
                    else temp =0;
                }
            }
            else{
                for(int q2=0; q2<=num2-num1; q2++){     // 크기차이 +1 만큼 반복
                    for(int w2=0; w2<num1; w2++){
                        temp = temp + (arr1[w2]*arr2[w2+q2]);   // 처음부터 시작해서 오른쪽으로 1칸씩 미는것을 나타내기 위해 작은 배열에 +q2해준다.
                    }
                    if(temp>answer){answer = temp; temp=0;}
                    else temp =0;
                }
            }
            System.out.printf("#%d %d\n",t,answer);
            answer =0;
        }
    }
}
