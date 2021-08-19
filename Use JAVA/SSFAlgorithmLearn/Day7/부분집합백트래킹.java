package SSFAlgorithmLearn.Day7;

import java.util.Scanner;
public class 부분집합백트래킹 {
    static int totalCount2, totalCount3,N,S,callCount2,callCount3;
    static int[] input;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 크기 입력 : ");
        N = sc.nextInt();
        System.out.print("목표로 하는 합 : ");
        S = sc.nextInt(); // 목표로 하는 합
        input = new int[N];
        isSelected = new boolean[N];

        callCount2 =callCount3=totalCount2=totalCount3=0;
        for(int i=0; i<N; i++){
            input[i] = sc.nextInt();
        }
        generateSubset2(0,0);
        System.out.println("경우의 수 "+totalCount2+" 호출횟수 : " +callCount2);
        generateSubset3(0,0);
        System.out.println("경우의 수 "+totalCount3+" 호출횟수 : " +callCount3);
        sc.close();
    }
    private static void generateSubset2(int cnt, int sum){  // cnt : 부분집합을 처리하기 위해 고려된 원소수
                                                            // 부분집합들의 합
        callCount2++;                               
        if(cnt ==N){    
        if(sum==S){
                totalCount2++;
                for(int i=0;i <N; i++){
                    if(isSelected[i]) System.out.print(input[i]+" ");
                }            
                System.out.println();
        }
            return;
            }
        //현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        generateSubset2(cnt+1, sum+input[cnt]);
        
        //현재 원소를 부분집합에 넣지 않기 
        isSelected[cnt] =false;
        generateSubset2(cnt+1, sum);
    }

    private static void generateSubset3(int cnt, int sum){  // cnt : 부분집합을 처리하기 위해 고려된 원소수
                                                            // 부분집합들의 합
        callCount3++;                                                
        if(sum==S){
                totalCount3++;
                for(int i=0;i <N; i++){
                    if(isSelected[i]) System.out.print(input[i]+" ");
                }            
                System.out.println();
                return;
        }
        if(sum>S ||cnt==N) return;
        //현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        generateSubset3(cnt+1, sum+input[cnt]);
        
        //현재 원소를 부분집합에 넣지 않기 
        isSelected[cnt] =false;
        generateSubset3(cnt+1, sum);
    }
    
}
