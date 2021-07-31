package D2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class RichManProject {
    public static void main(String[] args) throws IOException {             //Buffered 쓰면 속도 450 Scanner 는 2300
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	StringTokenizer st;
        //int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            long answer =0;			// long 타입 사용안하면 오버플로우 오류냠
            long gap =0;
            long max =0;
        	//int size = sc.nextInt();
          	int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            st = new StringTokenizer(br.readLine());  //st에 띄어쓰기 구분으로 입력받기
            for(int i=0; i<arr.length; i++){	// 배열에 날짜 입력받기
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            max = arr[size-1];
            for(int j=size-2; j>=0; j--){
            	if(arr[j]<max){
                    gap = max-arr[j];
                    answer +=gap;}
                else { max = arr[j];
                                 gap = 0;}
               
            }
            System.out.printf("#%d %d\n",t,answer);
        }
    }
}

       
       
       
        /* Scanner sc = new Scanner(System.in);
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
            System.out.printf("#%d %d\n",t,answer);*/

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc