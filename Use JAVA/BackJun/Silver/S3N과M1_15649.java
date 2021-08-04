package BackJun.Silver;
import java.io.*;
import java.util.StringTokenizer;
public class S3N과M1_15649{
    static int N,R;
    static int[] answer,input;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException{
        // N과 R값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        answer = new int[R];
        isSelected = new boolean[N];
        for(int i=0; i<N; i++){
            input[i] = i+1;
        }
        permu(0);
    }
    public static void permu(int cnt){
        if(cnt==R){
            for(int i=0; i<R; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int x=0; x<N; x++){
            if(isSelected[x]) continue;
            
            answer[cnt] = input[x];
            isSelected[x]=true;
            permu(cnt+1);
            isSelected[x]=false;
        }
        
    }
}