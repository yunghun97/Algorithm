package BackJun.Bronze;
import java.io.*;
import java.util.Arrays;

public class B2일곱난쟁이_2309 {
    static int[] arr,answer;
    static BufferedWriter bw;
    static boolean end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[9];
        answer = new int[7];
        // int sum=0;
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            // sum+=arr[i];
        }
        Arrays.sort(arr);
        combi(0,0,0);
        // cal(sum);
        bw.flush();
        bw.close();
        br.close();
    }
   /* private static void cal(int sum) { //조합 안쓰고 풀기
        int a =0; int b=0;
        outer : for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(i==j) continue;
                if(sum-arr[i]-arr[j]==100){
                    a = i; b = j;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(i!=a&&i!=b)
            System.out.println(arr[i]);
        }
    }*/
    private static void combi(int cnt, int start,int sum) throws IOException{
        if(end) return;
        if(cnt==7){
            if(sum==100){
                for(int i=0; i<7; i++){
                    bw.write(""+answer[i]+"\n");
                }
                end = true;
            }
            return;
        }
        for(int x=start; x<9; x++){
            answer[cnt] = arr[x];
            combi(cnt+1, x+1, sum+arr[x]);
        }
    }
}
