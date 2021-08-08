package BackJun.Silver;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;

public class S2소가길을건너간이유5 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S2소가길을건너간이유5_14465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int normal = Integer.parseInt(st.nextToken());
        int error = Integer.parseInt(st.nextToken());
        int[] map = new int[size+1];
        int answer = Integer.MAX_VALUE;
        int temp = 0;
        for(int i=0; i<error; i++){
            map[Integer.parseInt(br.readLine())] = 1;   // 고장난거
        }
        int start =1;
        for(int i=1; i<=size; i++){             //N번째 까지 확인해서 고장난거 구함 + 최대 범위가되면 맨 앞의 갚을 빼준다. + 그 맨 앞찾는 값 +1
            temp += map[i];
            
            if(i>=normal){
                answer = Math.min(answer,temp);
                temp -= map[start];
                start++;
            }
        }
        /*                                      // 슬라이딩 윈도우 버전
        outer : for(int j=1; j<=size; j++){
            for(int l=0; l<normal; l++){
                if(j+l>size){ break outer;}         // 인덱스 범위 벗어나면 고장난거임
                if(map[j+l]==1){
                    temp++;
                }
            }
            if(temp==0){answer =0; break;}
            answer = Math.min(answer, temp);
            temp =0;
        }           */
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
