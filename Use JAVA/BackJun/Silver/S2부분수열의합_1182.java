package BackJun.Silver;

import java.io.*;
import java.util.StringTokenizer;



public class S2부분수열의합_1182 {
    static int N, GOAL,answer;
    static int[] input;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
    StringTokenizer st ;
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(
            "5 0\n"
            +"-7 -3 -2 5 8"));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    GOAL = Integer.parseInt(st.nextToken());
    input = new int[N];
    isSelected = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
        input[i] = Integer.parseInt(st.nextToken());
    }    
    cal(0,0);
    if(GOAL==0) answer--;   // 0일때 공집합의 합도 0이되므로 1개 뺴준다.
    bw.write(""+answer);
    bw.flush();
    bw.close();
    br.close();
    
    
    }
    

    private static void cal(int cnt, int sum) { // 부분집합
        if(cnt==N){
            if(sum==GOAL){
                answer++;
                return;
            }
            return;
        }
        cal(cnt+1, sum+input[cnt]);
        cal(cnt+1, sum);

    }

    

}
