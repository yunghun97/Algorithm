package BackJun.Silver;

import java.io.*;
import java.util.StringTokenizer;



public class S4스위치켜고끄기1244{
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine())+1;       // 1부터 샐꺼라서 +1;
        arr = new int[size];
        StringTokenizer st;
        
        
        st = new StringTokenizer(br.readLine());        // 스위치 배열 저장
        for(int i=1; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());  // 1부터 셀꺼니까 1부터
        }
        int num = Integer.parseInt(br.readLine());      // 학생 수

        for(int j=1; j<=num; j++){
            st = new StringTokenizer(br.readLine());        // 학생 성별, 번호 입력
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){boy(b);
            }
            else{girl(b);
            }
        }
        for(int i=1; i<arr.length; i++){        // 20일때 줄 바꿈 해주기!!
            System.out.print(arr[i]);
            if(i%20==0){System.out.println();}
            else System.out.print(" ");
        }
        br.close();
    }
    public static void boy(int b){
            for(int i=b; i<arr.length; i+=b){
                arr[i]^=1;              //  ^ XOR연산으로 1이 2개면 0 || 0,1은 1으로 출력된다
            }
    }
    public static void girl(int b){
        int x = b; int y =b;    
        arr[b]^=1;          // 자기 자신 반대로
            for(int i=1; i<arr.length; i++){  
                x--; y++;
                if(x>=1&&y<arr.length){     // 배열 범위 안에서
                if(arr[x]!=arr[y]){break;}  // 대칭이 아니면 break;
                else arr[x]^=1; arr[y]^=1;  // 대칭이면 xor연산 실행
                }
            }
    }
}