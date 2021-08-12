package BackJun.Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class S2N과M9_15663 {
    static int[] input, answer;
    static int N,R;
    static boolean[] isSelected;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S2N과M9_15663.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N];
        input = new int[N];
        answer = new int[R];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        permutation(0);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void permutation(int cnt) throws IOException {
        if(cnt==R){
            for(int x=0; x<R; x++){
                bw.write(String.valueOf(answer[x])+" ");
            }
            bw.write("\n");
            return;
        }
        // 자릿수가 다르면 중복이 되어도 상관없으므로 재귀 호출할때마다 초기화 해준다
        // 재귀 호출이 됬다는 것은 자릿수가 바뀌었다는 뜻이므로 비교값을 -1 즉 없는 값으로 초기화해준다.
        int prevNumber = -1;
        for(int i=0; i<N; i++){
            if(isSelected[i]||input[i]==prevNumber) continue;

            answer[cnt] = input[i];
            prevNumber = input[i];      // 이전 값저장 어짜피 처음에 배열을 정렬해 줬으므로
                                        // 한번 중복검사가 끝나고 prevNumber의 값이 바뀌어도 
                                        // 뒤에는 이전에 값이 등장 할 수가 없다.
            isSelected[i]=true;
            permutation(cnt+1);
            isSelected[i]=false;
        }

    }
}
