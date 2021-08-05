package BackJun.Silver;
// 입력 5 3 형태로 하면 됨
import java.io.*;
import java.util.StringTokenizer;
public class S3N과M3_15651 {
    static int N, R;
    static int[] input, answer;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N]; 
        answer = new int[R];
        isSelected = new boolean[N];
        for(int i=0; i<N; i++){
            input[i] = i+1;
        }
        permutation(0);
        bw.flush(); // bw에 있는거 다 출력
        bw.close(); // bw 종료
    }
    public static void permutation(int cnt) throws IOException{
        if(cnt==R){
            for(int i=0; i<cnt; i++){
                bw.write(Integer.toString(answer[i])+" "); // 버퍼에 값 저장
            }
            bw.newLine();   //bw에 행 삽입 ==\n
            return;
        }
        for(int x=0; x<N; x++){
            answer[cnt] = input[x];
            permutation(cnt+1);
        }
        
    }
}