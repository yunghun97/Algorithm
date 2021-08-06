package SamSungSwExpert.D3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
//평탄화 하는 거
public class Flatten{
        public static void main(String[] args) throws IOException{
            System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\Flatten.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            for(int t=1; t<=10; t++){
            int limit = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()); // 토크나이저 입력
            int arr[] = new int[100];
            int a=0;
            while(st.hasMoreTokens()){
                arr[a++] = Integer.parseInt(st.nextToken());		// 배열 입력
            }
            Arrays.sort(arr);		// 처음 정렬
            while(limit>0){				// 횟수가 남아 있을때까지
                for(int i=0; i<99; i++){
                	if(arr[i+1]<arr[i]){			// + 할 부분 처음부터 찾기
                    	arr[i+1]++; break;
                    }
                    else if(arr[i+1]==arr[i]) continue;		// 앞 두칸이 같으면 뒤로 한 칸 미뤄서 계산
                    else{arr[i]++; break;}		// 첫번째 칸이 더 크므로 arr[i]++
                }
                for(int j=99; j>0; j--){		// - 할 부분 찾기
                	if(arr[j]<arr[j-1]){		// 앞에가 더 크면 앞에 S값 --
                       arr[j-1]--; break;}
                    else if(arr[j]==arr[j-1]) continue;	// 똑같으면 한칸 앞으로 땡긴다.
                    else{arr[j]--;break;}		// 뒤에 값이 더 크므로 --;
                }
                limit--;
            }
            int max =0; int min = 100;			// 최대 최소 찾기
            for(int x=0; x<100; x++){
            	if(arr[x]>max){ max = arr[x];}
                else if(arr[x]<min){min = arr[x];}
            }
            System.out.printf("#%d %d\n",t,max-min);
            } //테스트 케이스 끝  
    }
}
