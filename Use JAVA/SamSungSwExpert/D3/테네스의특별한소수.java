package SamSungSwExpert.D3;
import java.io.*;
import java.util.*;
public class 테네스의특별한소수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int tenes = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] arr = new int[1000001];
            int answer=0;
            arr[1]=1; // -> 1일 때 제외
            for(int i=2; i<end; i++){   // 2의 배수 3의 배수 등 찾아서 1로 만듬
                if(arr[i]==1) continue;
                for(int j=2*i; j<=end; j+=i){   // 자기 자신은 제외하고 배수 일 떄 부터 계산하기 때문에 2*i 시작이다.
                    arr[j]=1;
                }
            }
            for(int i=start; i<=end; i++){
                if(arr[i]==0){
                    if(String.valueOf(i).contains(String.valueOf(tenes))) answer++;
                }
            }
            
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
