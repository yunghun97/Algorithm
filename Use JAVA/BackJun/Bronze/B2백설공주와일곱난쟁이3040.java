package BackJun.Bronze;

import java.io.*;


public class B2백설공주와일곱난쟁이3040 {
    static int R,N;
    static int[] arr,answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Bronze\\B2백설공주와일곱난쟁이3040.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        arr= new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        answer = new int[7];

        combination(0,0,0);
        bw.flush();
    }
    private static void combination(int cnt, int start, int sum) throws IOException {
        if(cnt==7){
            if(sum==100){
                for(int i=0; i<7; i++){
                bw.write(String.valueOf(answer[i])+"\n");
            }
            }
            return;
        }
        for(int x=start; x<9; x++){
            answer[cnt]=arr[x];
            combination(cnt+1, x+1, sum+arr[x]);
        }
    }
}
